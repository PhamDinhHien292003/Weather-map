package com.example.demo.Controller;


import com.example.demo.DTO.CountryDTO;
import com.example.demo.Payload.ResponseData;
import com.example.demo.Service.Implement.WeatherImp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;


@Controller
@RequestMapping("details-weather")
public class WeatherController {
    @Autowired
    private WeatherImp weatherImp;

    @GetMapping("get")
    public String getWeather(@RequestParam String city , Model model) {
        model.addAttribute( "weatherData" , weatherImp.getWeather(city) );
        return "show-weather";
    }
}
