package com.example.demo.DTO;

public class CountryDetailsDTO {
    private int idCountry;
    private float areaCountry;
    private int populationCountry;
    private String officialLanguageCountry;
    private String currencyCountry;

    // Getters and Setters
    public int getIdCountry() {
        return idCountry;
    }

    public void setIdCountry(int idCountry) {
        this.idCountry = idCountry;
    }

    public float getAreaCountry() {
        return areaCountry;
    }

    public void setAreaCountry(float areaCountry) {
        this.areaCountry = areaCountry;
    }

    public int getPopulationCountry() {
        return populationCountry;
    }

    public void setPopulationCountry(int populationCountry) {
        this.populationCountry = populationCountry;
    }

    public String getOfficialLanguageCountry() {
        return officialLanguageCountry;
    }

    public void setOfficialLanguageCountry(String officialLanguageCountry) {
        this.officialLanguageCountry = officialLanguageCountry;
    }

    public String getCurrencyCountry() {
        return currencyCountry;
    }

    public void setCurrencyCountry(String currencyCountry) {
        this.currencyCountry = currencyCountry;
    }


    public CountryDetailsDTO(int idCountry, float areaCountry, int populationCountry, String officialLanguageCountry, String currencyCountry) {
        this.idCountry = idCountry;
        this.areaCountry = areaCountry;
        this.populationCountry = populationCountry;
        this.officialLanguageCountry = officialLanguageCountry;
        this.currencyCountry = currencyCountry;
    }
}
