package com.example.demo.Service.Implement;

import com.example.demo.DTO.WeatherDTO;
import org.springframework.stereotype.Service;

public interface WeatherImp {
    public WeatherDTO getWeather(String city);
}
