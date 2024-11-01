package com.example.demo.DTO;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonIgnoreProperties(ignoreUnknown = true)
public class WeatherDTO {

    @JsonProperty("name")
    private String name_city;

    @JsonProperty("main")
    private MainDTO main;

    @JsonProperty("wind")
    private WindDTO wind;

    // ... Getters and setters

    public String getName_city() {
        return name_city;
    }

    public void setName_city(String name_city) {
        this.name_city = name_city;
    }

    public String getTemp() {
        if (main != null) {
            return String.valueOf(main.getTemp());
        } else {
            return null;
        }
    }

    public void setTemp(String temp) {
        if (main == null) {
            main = new MainDTO();
        }
        main.setTemp(Double.parseDouble(temp));
    }

    public String getHumidity() {
        if (main != null) {
            return String.valueOf(main.getHumidity());
        } else {
            return null;
        }
    }

    public void setHumidity(String humidity) {
        if (main == null) {
            main = new MainDTO();
        }
        main.setHumidity(Integer.parseInt(humidity));
    }

    public String getWindSpeed() {
        if (wind != null) {
            return String.valueOf(wind.getSpeed());
        } else {
            return null;
        }
    }

    public void setWindSpeed(String windSpeed) {
        if (this.wind == null) {
            this.wind = new WindDTO();
        }
        this.wind.setSpeed(Double.parseDouble(windSpeed));
    }

    // ... Inner classes for "main" and "wind" (simplified)


    public MainDTO getMain() {
        return main;
    }

    public void setMain(MainDTO main) {
        this.main = main;
    }

    public WindDTO getWind() {
        return wind;
    }

    public void setWind(WindDTO wind) {
        this.wind = wind;
    }

    @JsonIgnoreProperties(ignoreUnknown = true)
    public static class MainDTO {
        private double temp;
        private int humidity;

        public double getTemp() {
            return temp;
        }

        public void setTemp(double temp) {
            this.temp = temp;
        }

        public int getHumidity() {
            return humidity;
        }

        public void setHumidity(int humidity) {
            this.humidity = humidity;
        }
    }

    @JsonIgnoreProperties(ignoreUnknown = true)
    public static class WindDTO {
        private double speed;

        public double getSpeed() {
            return speed;
        }

        public void setSpeed(double speed) {
            this.speed = speed;
        }
    }

    public WeatherDTO(String name_city, String temp, String humidity, String windSpeed) {
        this.name_city = name_city;

        this.main = new MainDTO();
        this.main.setTemp(Double.parseDouble(temp));
        this.main.setHumidity(Integer.parseInt(humidity));

        this.wind = new WindDTO();
        this.wind.setSpeed(Double.parseDouble(windSpeed));
    }

    public WeatherDTO() {
    }
}

