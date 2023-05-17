package com.aplication.controller.dto;

import com.aplication.entity.City;

public class CityResponseDTO {

    private Long cityId;

    private String country;

    private String city;

    public CityResponseDTO(Long cityId, String country, String city) {
        this.cityId = cityId;
        this.country = country;
        this.city = city;
    }

    public CityResponseDTO(City city) {
        cityId = city.getId();
        country = city.getCountry();
        this.city = city.getCity();
    }

    public Long getCityId() {
        return cityId;
    }

    public void setCityId(Long cityId) {
        this.cityId = cityId;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }
}
