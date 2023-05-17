package com.aplication.service;

import com.aplication.entity.City;
import com.aplication.exceptions.CityNotFoundException;
import com.aplication.repository.CityRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CityService {

    private final CityRepository cityRepository;

    @Autowired
    public CityService(CityRepository cityRepository) {
        this.cityRepository = cityRepository;
    }

    public Long createCity(String cityName, String country){
        City city = new City(cityName, country);
        return cityRepository.save(city).getId();
    }

    public City getCityById(Long cityId){
        return cityRepository.findById(cityId).
                orElseThrow(() -> new CityNotFoundException("Could not find city with the id " + cityId));
    }

    public void deleteCity(Long cityId){
        cityRepository.deleteById(cityId);
    }

}
