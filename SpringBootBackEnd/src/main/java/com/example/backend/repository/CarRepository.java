package com.example.backend.repository;

import com.example.backend.model.Car;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.math.BigDecimal;
import java.util.List;

@Repository
public interface CarRepository extends MongoRepository<Car, String> {

    public Car findByPlateNumber(String plateNumber);

    public List<Car> findByRentalFeePerDay(BigDecimal rentalFeePerDay);

}
