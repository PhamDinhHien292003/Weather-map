package com.example.demo.DTO;

public class CountryDTO {
    private String countryName;
    private String Capital;
    private CountryDetailsDTO countryDTO;

    public void setCountryDTO(CountryDetailsDTO countryDTO) {
        this.countryDTO = countryDTO;
    }

    public CountryDTO(String countryName, String capital, CountryDetailsDTO countryDTO) {
        this.countryName = countryName;
        Capital = capital;
        this.countryDTO = countryDTO;
    }

    public CountryDTO(String countryName, String capital) {
        this.countryName = countryName;
        Capital = capital;
    }

    public CountryDetailsDTO getCountryDTO() {
        return countryDTO;
    }

    public String getCountryName() {
        return countryName;
    }

    public void setCountryName(String countryName) {
        this.countryName = countryName;
    }

    public String getCapital() {
        return Capital;
    }

    public void setCapital(String capital) {
        Capital = capital;
    }
}
