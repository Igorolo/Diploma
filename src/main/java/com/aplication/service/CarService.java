package com.aplication.service;

import com.aplication.entity.Account;
import com.aplication.entity.Car;
import com.aplication.exceptions.AccountNotFoundException;
import com.aplication.exceptions.CarNotFoundException;
import com.aplication.repository.AccountRepository;
import com.aplication.repository.CarRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class CarService {
    private final CarRepository carRepository;
    private final AccountRepository accountRepository;

    @Autowired
    public CarService(CarRepository carRepository, AccountRepository accountRepository) {
        this.carRepository = carRepository;
        this.accountRepository = accountRepository;
    }

    public Long save(Integer mileage, String carBrand, String manufacturerCountry, String engine, String transmission,
                     String brakeSystem, String steeringWheel, Long accountId) {
        Optional<Account> accountOptional = accountRepository.findById(accountId);
        Account account = accountOptional.orElseThrow(() -> new AccountNotFoundException("Unable to find account with id " + accountId));

        Car car = new Car(mileage, carBrand, manufacturerCountry, engine, transmission, brakeSystem, steeringWheel, account);
        Car savedCar = carRepository.save(car);
        return savedCar.getId();
    }

    public Car getById(Long carId) {
        return carRepository.findById(carId)
                .orElseThrow(() -> new CarNotFoundException("Unable to find car with id " + carId));
    }

    public void deleteById(Long carId) {
        carRepository.deleteById(carId);
    }

}
