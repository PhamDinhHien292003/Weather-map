package com.example.demo.Entity;
import jakarta.persistence.*;


@Entity
@Table(name = "detail_country")
public class Country_details {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_country")
    private int idCountry;

    @Column(name = "area_country")
    private float areaCountry;

    @Column(name = "population_country")
    private int populationCountry;

    @Column(name = "official_language_country"  )
    private String officialLanguageCountry;

    @Column(name = "currency_country")
    private String currencyCountry;

    @OneToOne(mappedBy = "countryDetails", cascade = CascadeType.ALL)
    private Country country_lst;

    public Country_details(int idCountry, float areCountry, int populationCountry, String officialLanguageCountry, String currencyCountry, Country country) {
        this.idCountry = idCountry;
        this.areaCountry = areCountry;
        this.populationCountry = populationCountry;
        this.officialLanguageCountry = officialLanguageCountry;
        this.currencyCountry = currencyCountry;
        this.country_lst = country;
    }

    public Country_details() {
    }

    public int getIdCountry() {
        return idCountry;
    }

    public void setIdCountry(int idCountry) {
        this.idCountry = idCountry;
    }

    public float getAreCountry() {
        return areaCountry;
    }

    public void setAreCountry(float areCountry) {
        this.areaCountry = areCountry;
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

    public Country getCountry() {
        return country_lst;
    }

    public void setCountry(Country country) {
        this.country_lst = country;
    }
}
