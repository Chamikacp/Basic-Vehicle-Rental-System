package com.example.backend.controller;

import com.example.backend.model.Car;
import com.example.backend.service.CarService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
public class CarController {

    @Autowired
    private CarService carService;

    @RequestMapping("/getCar")
    public Car getCar(@RequestParam String plateNumber) {
        return carService.getByPlateNumber(plateNumber);
    }

    @RequestMapping("/getAllCars")
    public List<Car> getAll() {
        return carService.getAll();
    }
}
