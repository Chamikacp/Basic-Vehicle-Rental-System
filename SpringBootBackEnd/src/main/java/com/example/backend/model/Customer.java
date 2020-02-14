package com.example.backend.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.Date;

@Document(collection = "Customer")
public class Customer {
    @Id
    String id;
    String plateNumber;
    Date pickUpDate;
    Date dropOffDate;
    String customerName;
    String licenseNumber;
    String address;
    String phoneNumber;

    public Customer(String plateNumber, Date pickUpDate, Date dropOffDate, String customerName, String licenseNumber, String address, String phoneNumber) {
        this.plateNumber = plateNumber;
        this.pickUpDate = pickUpDate;
        this.dropOffDate = dropOffDate;
        this.customerName = customerName;
        this.licenseNumber = licenseNumber;
        this.address = address;
        this.phoneNumber = phoneNumber;
    }

    public String getPlateNumber() {
        return plateNumber;
    }

    public void setPlateNumber(String plateNumber) {
        this.plateNumber = plateNumber;
    }

    public Date getPickUpDate() {
        return pickUpDate;
    }

    public void setPickUpDate(Date pickUpDate) {
        this.pickUpDate = pickUpDate;
    }

    public Date getDropOffDate() {
        return dropOffDate;
    }

    public void setDropOffDate(Date dropOffDate) {
        this.dropOffDate = dropOffDate;
    }

    public String getCustomerName() {
        return customerName;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    public String getLicenseNumber() {
        return licenseNumber;
    }

    public void setLicenseNumber(String licenseNUmber) {
        this.licenseNumber = licenseNUmber;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    @Override
    public String toString() {
        return "Customer{" +
                "plateNumber='" + plateNumber + '\'' +
                ", pickUpDate=" + pickUpDate +
                ", dropOffDate=" + dropOffDate +
                ", customerName='" + customerName + '\'' +
                ", licenseNUmber='" + licenseNumber + '\'' +
                ", address='" + address + '\'' +
                ", phoneNumber='" + phoneNumber + '\'' +
                '}';
    }
}
