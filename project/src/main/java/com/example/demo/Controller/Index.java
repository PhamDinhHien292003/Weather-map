package com.example.demo.Controller;


import com.example.demo.Service.CountryService;
import com.fasterxml.jackson.core.JsonProcessingException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.oauth2.core.user.OAuth2User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/check-weather")
public class Index {

    @Autowired
    CountryService countryService;

    @GetMapping("/login")
    public String  testing(){
        return "index";
    }

    @GetMapping("/oauth2/callback/google")
    public String googleLogin(OAuth2User oauth2User) {
        return "redirect:/";
    }


    @GetMapping("/map")
    public String getMap(Model model) throws JsonProcessingException {
        model.addAttribute("location_lst", countryService.getAllCountries());
        return "map";
    }




   /* @GetMapping("/location/find-country")
    public String location(@RequestParam String id , Model model){
        model.addAttribute("found_country", countryService.getCountryById(id));
        return "location-with-id";
    }*/



    @GetMapping("weather")
    public String  weather(){
        return "show-weather";
    }


  /*  @GetMapping("weather/{id}")
    public String  weather(@PathVariable String id , Model model){  
        return "location";
    }*/
    
}
