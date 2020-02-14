package com.example.backend.repository;

import com.example.backend.model.Customer;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CustomerRepository extends MongoRepository<Customer, String> {
    public Customer findByPlateNumber(String plateNumber);

    public List<Customer> findByCustomerName(String customerName);

}
