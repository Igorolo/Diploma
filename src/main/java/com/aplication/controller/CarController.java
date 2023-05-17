package com.aplication.controller;


import com.aplication.controller.dto.CarRequestDTO;
import com.aplication.controller.dto.CarResponseDTO;
import com.aplication.service.CarService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class CarController {
    private final CarService carService;

    @Autowired
    public CarController(CarService carService) {
        this.carService = carService;
    }

    @PostMapping("/cars")
    public Long createCar(@RequestBody CarRequestDTO carRequestDTO) {
        return carService.save(
                carRequestDTO.getMileage(),
                carRequestDTO.getCarBrand(),
                carRequestDTO.getManufacturerCountry(),
                carRequestDTO.getEngine(),
                carRequestDTO.getTransmission(),
                carRequestDTO.getBrakeSystem(),
                carRequestDTO.getSteeringWheel(),
                carRequestDTO.getAccountId()
        );
    }

    @GetMapping("/cars/{carId}")
    public CarResponseDTO getById(@PathVariable Long carId) {
        return new CarResponseDTO(carService.getById(carId));
    }

    @DeleteMapping("/cars/{carId}")
    public void deleteCar(@PathVariable Long carId) {
        carService.deleteById(carId);
    }
}
