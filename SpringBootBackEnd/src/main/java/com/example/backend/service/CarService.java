package com.example.backend.service;

import com.example.backend.model.Car;
import com.example.backend.repository.CarRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CarService {

    @Autowired
    private CarRepository carRepository;

    public List<Car> getAll() {
        return carRepository.findAll();
    }

    public Car getByPlateNumber(String plateNumber) {
        return carRepository.findByPlateNumber(plateNumber);
    }

}
