package com.example.backend.controller;

import com.example.backend.model.Customer;
import com.example.backend.repository.CustomerRepository;
import com.example.backend.service.CustomerService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.time.Period;
import java.util.List;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
public class CustomerController {

    @Autowired
    private CustomerService customerService;

    @Autowired
    private CustomerRepository customerRepository;

    @PostMapping("/addCustomer")
    public Customer addCustomer(@RequestBody Customer customer) {
        customerRepository.save(customer);
        return customer;
    }


    @RequestMapping("/getCustomer")
    public Customer getCustomer(@RequestParam String plateNumber) {
        return customerService.getByPlateNumber(plateNumber);
    }

    @RequestMapping("/getAllCustomers")
    public List<Customer> getAll() {
        return customerService.getAll();
    }



}

