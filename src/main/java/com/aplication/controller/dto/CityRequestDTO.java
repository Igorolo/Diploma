package com.aplication.controller.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

public class CityRequestDTO {

    @JsonProperty("country")
    private String country;

    @JsonProperty("city")
    private String city;

    public CityRequestDTO(String country, String city) {
        this.country = country;
        this.city = city;
    }

    public CityRequestDTO() {
    }


    public String getCountry() {
        return country;
    }

    public String getCity() {
        return city;
    }
}
