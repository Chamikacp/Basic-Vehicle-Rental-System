package com.example.backend.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.math.BigDecimal;

@Document(collection = "Cars")
public class Car {
    @Id
    String id;
    String plateNumber;
    BigDecimal rentalFeePerDay;
    String make;
    String model;
    String type;
    String engineCapacity;
    String transmissionType;
    int numberOfSeats;
    String colour;
    int numberOfDoors;
    String airConditioningType;
    String fuelType;

    public Car(String plateNumber, BigDecimal rentalFeePerDay, String make, String model, String type, String engineCapacity, String transmissionType, int numberOfSeats, String colour, int numberOfDoors, String airConditioningType, String fuelType) {
        this.plateNumber = plateNumber;
        this.rentalFeePerDay = rentalFeePerDay;
        this.make = make;
        this.model = model;
        this.type = type;
        this.engineCapacity = engineCapacity;
        this.transmissionType = transmissionType;
        this.numberOfSeats = numberOfSeats;
        this.colour = colour;
        this.numberOfDoors = numberOfDoors;
        this.airConditioningType = airConditioningType;
        this.fuelType = fuelType;
    }

    public String getPlateNumber() {
        return plateNumber;
    }

    public void setPlateNumber(String plateNumber) {
        this.plateNumber = plateNumber;
    }

    public BigDecimal getRentalFeePerDay() {
        return rentalFeePerDay;
    }

    public void setRentalFeePerDay(BigDecimal rentalFeePerDay) {
        this.rentalFeePerDay = rentalFeePerDay;
    }

    public String getMake() {
        return make;
    }

    public void setMake(String make) {
        this.make = make;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getEngineCapacity() {
        return engineCapacity;
    }

    public void setEngineCapacity(String engineCapacity) {
        this.engineCapacity = engineCapacity;
    }

    public String getTransmissionType() {
        return transmissionType;
    }

    public void setTransmissionType(String transmissionType) {
        this.transmissionType = transmissionType;
    }

    public int getNumberOfSeats() {
        return numberOfSeats;
    }

    public void setNumberOfSeats(int numberOfSeats) {
        this.numberOfSeats = numberOfSeats;
    }

    public String getColour() {
        return colour;
    }

    public void setColour(String colour) {
        this.colour = colour;
    }

    public int getNumberOfDoors() {
        return numberOfDoors;
    }

    public void setNumberOfDoors(int numberOfDoors) {
        this.numberOfDoors = numberOfDoors;
    }

    public String getAirConditioning() {
        return airConditioningType;
    }

    public void setAirConditioning(String airConditioning) {
        this.airConditioningType = airConditioning;
    }

    public String getFuelType() {
        return fuelType;
    }

    public void setFuelType(String fuelType) {
        this.fuelType = fuelType;
    }

    @Override
    public String toString() {
        return "Car{" +
                "plateNumber='" + plateNumber + '\'' +
                ", rentalFeePerDay=" + rentalFeePerDay +
                ", make='" + make + '\'' +
                ", model='" + model + '\'' +
                ", type='" + type + '\'' +
                ", engineCapacity='" + engineCapacity + '\'' +
                ", transmissionType='" + transmissionType + '\'' +
                ", numberOfSeats=" + numberOfSeats +
                ", colour='" + colour + '\'' +
                ", numberOfDoors=" + numberOfDoors +
                ", airConditioning='" + airConditioningType + '\'' +
                ", fuelType='" + fuelType + '\'' +
                '}';
    }
}

