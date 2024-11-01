package com.example.demo.Service;

import com.example.demo.DTO.WeatherDTO;
import com.example.demo.Service.Implement.WeatherImp;
import com.fasterxml.jackson.databind.JsonNode; // For more flexible JSON handling
import com.fasterxml.jackson.databind.ObjectMapper;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import org.springframework.stereotype.Service;

import java.io.IOException;

@Service
public class WeatherService implements WeatherImp {
    @Override
    public WeatherDTO getWeather(String city) {

        OkHttpClient client = new OkHttpClient();
        String resp = "";
        Request request = new Request.Builder()
                .url("http://api.openweathermap.org/data/2.5/weather?q=" + city + "&appid=c161bf762aa782f92ad1a4a4e2936146") // Replace with your actual API key
                .get()
                .build();

        try (Response response = client.newCall(request).execute()) {
            resp = response.body().string();

            if (response.isSuccessful()) {
                ObjectMapper objectMapper = new ObjectMapper();
                JsonNode rootNode = objectMapper.readTree(resp);


                WeatherDTO weather = objectMapper.readValue(resp, WeatherDTO.class);

                if(weather.getName_city().length() > 50 ) return null;
                return new WeatherDTO(
                        weather.getName_city(),
                        String.valueOf(convertKtoC(weather.getMain().getTemp())),
                        String.valueOf(weather.getMain().getHumidity()),
                        String.valueOf(weather.getWind().getSpeed())
                );

            } else {

            }

        } catch (IOException e) {
            e.printStackTrace();


        }
        return null;
    }

    public float convertKtoC(double num){
        return (float) (num -  273.15);
    }
}