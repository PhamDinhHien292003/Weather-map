package com.example.demo.Service;

import com.example.demo.DTO.CountryDTO;
import com.example.demo.DTO.CountryDetailsDTO;
import com.example.demo.Entity.Country;
import com.example.demo.Repository.CountryRepository;
import com.example.demo.Service.Implement.CountryImp;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;

import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class CountryService implements CountryImp {

    @Autowired
    private CountryRepository countryRepository;

    @Autowired
    private RedisTemplate redisTemplate;

    private Gson gson = new Gson();


    @Override
    public List<CountryDTO> getAllCountries() {
        String data = (String)redisTemplate.opsForValue().get("countries");
        /// check isn't empty
        if(data != null){
            //convert json -> list object
            Type listType = new TypeToken<List<CountryDTO>>(){}.getType();
            return  new Gson().fromJson(data, listType);
        }

        List<Country> country = countryRepository.findAll();
        List<CountryDTO> countryDTOList = new ArrayList<>();
        country.forEach((items) -> {
            countryDTOList.add(new CountryDTO(items.getNameCountry()
                    , items.getCapital()
                    , new CountryDetailsDTO(items.getCountryDetails().getIdCountry(),
                    items.getCountryDetails().getAreCountry(),
                    items.getCountryDetails().getPopulationCountry(),
                    items.getCountryDetails().getOfficialLanguageCountry(), items.getCountryDetails().getCurrencyCountry())
            ));
        });
        String lst = gson.toJson(countryDTOList);
        redisTemplate.opsForValue().set("countries", lst);
        return countryDTOList;
    }

    @Override
    public CountryDTO getCountryById(String name) {
        String data = (String)redisTemplate.opsForValue().get("countries");
        if(data!=null){
            Type listType = new TypeToken<List<CountryDTO>>(){}.getType();
            List<CountryDTO> allOfList =  new Gson().fromJson(data, listType);
            Optional<CountryDTO> foundCountry = allOfList.stream()
                    .filter(items -> items.getCountryName().equalsIgnoreCase(name))
                    .findFirst();
            return foundCountry.orElse(null);
        }
        else {
            List<Country> country = countryRepository.findAll();
            CountryDTO countryDTOList = null;
            for (Country items : country) {
                if (items.getNameCountry().equals(name)) {
                    countryDTOList = new CountryDTO(items.getNameCountry()
                            , items.getCapital()
                            , new CountryDetailsDTO(items.getCountryDetails().getIdCountry(),
                            items.getCountryDetails().getAreCountry(),
                            items.getCountryDetails().getPopulationCountry(),
                            items.getCountryDetails().getOfficialLanguageCountry(), items.getCountryDetails().getCurrencyCountry()));
                    return countryDTOList;
                }
            }
        }
        return null ;
    }
}
