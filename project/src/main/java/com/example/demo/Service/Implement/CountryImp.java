package com.example.demo.Service.Implement;

import com.example.demo.DTO.CountryDTO;

import java.util.List;

public interface CountryImp {
    public List<CountryDTO> getAllCountries();
    public CountryDTO getCountryById(String name);
}
