package com.example.backend.controller;

import com.example.backend.model.Motorbike;
import com.example.backend.service.MotorbikeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
public class MotorbikeController {

    @Autowired
    private MotorbikeService motorbikeService;

    @RequestMapping("/getMotorbike")
    public Motorbike getMotorbike(@RequestParam String plateNumber) {
        return motorbikeService.getByPlateNumber(plateNumber);
    }

    @RequestMapping("/getAllMotorbikes")
    public List<Motorbike> getAll() {
        return motorbikeService.getAll();
    }
}
