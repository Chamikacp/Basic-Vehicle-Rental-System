package com.example.backend.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.math.BigDecimal;

@Document(collection = "Motorbikes")
public class Motorbike {

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
    String helmetType;
    String helmetSize;

    public Motorbike(String plateNumber, BigDecimal rentalFeePerDay, String make, String model, String type, String engineCapacity, String transmissionType, int numberOfSeats, String colour, String helmetType, String helmetSize) {
        this.plateNumber = plateNumber;
        this.rentalFeePerDay = rentalFeePerDay;
        this.make = make;
        this.model = model;
        this.type = type;
        this.engineCapacity = engineCapacity;
        this.transmissionType = transmissionType;
        this.numberOfSeats = numberOfSeats;
        this.colour = colour;
        this.helmetType = helmetType;
        this.helmetSize = helmetSize;
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

    public String getHelmetType() {
        return helmetType;
    }

    public void setHelmetType(String helmetType) {
        this.helmetType = helmetType;
    }

    public String getHelmetSize() {
        return helmetSize;
    }

    public void setHelmetSize(String helmetSize) {
        this.helmetSize = helmetSize;
    }

    @Override
    public String toString() {
        return "Motorbike{" +
                "plateNumber='" + plateNumber + '\'' +
                ", rentalFeePerDay=" + rentalFeePerDay +
                ", make='" + make + '\'' +
                ", model='" + model + '\'' +
                ", type='" + type + '\'' +
                ", engineCapacity='" + engineCapacity + '\'' +
                ", transmissionType='" + transmissionType + '\'' +
                ", numberOfSeats=" + numberOfSeats +
                ", colour='" + colour + '\'' +
                ", helmetType='" + helmetType + '\'' +
                ", helmetSize='" + helmetSize + '\'' +
                '}';
    }
}
