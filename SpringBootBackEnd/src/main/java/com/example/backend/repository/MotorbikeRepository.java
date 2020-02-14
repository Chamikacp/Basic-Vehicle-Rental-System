package com.example.backend.repository;

import com.example.backend.model.Motorbike;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.math.BigDecimal;
import java.util.List;

@Repository
public interface MotorbikeRepository extends MongoRepository<Motorbike, String> {
    public Motorbike findByPlateNumber(String plateNumber);

    public List<Motorbike> findByRentalFeePerDay(BigDecimal rentalFeePerDay);
}
