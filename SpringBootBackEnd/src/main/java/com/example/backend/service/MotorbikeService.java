package com.example.backend.service;

import com.example.backend.model.Motorbike;
import com.example.backend.repository.MotorbikeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MotorbikeService {
    @Autowired
    private MotorbikeRepository motorbikeRepository;

    public List<Motorbike> getAll() {
        return motorbikeRepository.findAll();
    }

    public Motorbike getByPlateNumber(String plateNumber) {
        return motorbikeRepository.findByPlateNumber(plateNumber);
    }
}
