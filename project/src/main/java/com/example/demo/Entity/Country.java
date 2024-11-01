package com.example.demo.Entity;


import jakarta.persistence.*;

@Entity
@Table(name = "country")
public class Country {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id_country")
    private int id ;

    @Column(name = "name_country")
    private String name ;

    @Column(name = "capital_country")
    private String capital ;

    @OneToOne
    @JoinColumn(name = "id_country")
    private Country_details countryDetails ;

    public Country(int id, String name, String capital, Country_details countryDetails) {
        this.id = id;
        this.name = name;
        this.capital = capital;
        this.countryDetails = countryDetails;
    }

    public Country() {
    }


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNameCountry() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCapital() {
        return capital;
    }

    public void setCapital(String capital) {
        this.capital = capital;
    }

    public Country_details getCountryDetails() {
        return countryDetails;
    }

    public void setCountryDetails(Country_details countryDetails) {
        this.countryDetails = countryDetails;
    }
}
