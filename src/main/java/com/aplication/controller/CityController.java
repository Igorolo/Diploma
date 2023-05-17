package com.aplication.controller;


import com.aplication.controller.dto.CityRequestDTO;
import com.aplication.controller.dto.CityResponseDTO;
import com.aplication.service.CityService;
import org.springframework.web.bind.annotation.*;

@RestController
public class CityController {
    private final CityService cityService;

    public CityController(CityService cityService) {
        this.cityService = cityService;
    }

    @PostMapping("/cities")
    public Long createCity(@RequestBody CityRequestDTO cityRequestDTO){
        return cityService.createCity(cityRequestDTO.getCountry(), cityRequestDTO.getCity());
    }

    @GetMapping("/cities/{cityId}")
    public CityResponseDTO getById(@PathVariable Long cityId){
        return new CityResponseDTO(cityService.getCityById(cityId));
    }

    @DeleteMapping("/cities/{cityId}")
    public void deleteCity(@PathVariable Long cityId){
        cityService.deleteCity(cityId);
    }
}
