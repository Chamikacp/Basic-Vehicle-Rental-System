package ConsoleMenu;

import java.math.BigDecimal;

public class Car extends Vehicle{
    protected int numberOfDoors;
    protected String airConditioning;
    protected String fuelType;

    public Car(String plateNumber, BigDecimal rentalFeePerDay, String make, String model, String type, String engineCapacity, String transmissionType, int numberOfSeats, String colour, int numberOfDoors, String airConditioning, String fuelType) {
        super(plateNumber, rentalFeePerDay, make, model, type, engineCapacity, transmissionType, numberOfSeats, colour);
        this.numberOfDoors = numberOfDoors;
        this.airConditioning = airConditioning;
        this.fuelType = fuelType;
    }

    public int getNumberOfDoors() {
        return numberOfDoors;
    }

    public void setNumberOfDoors(int numberOfDoors) {
        this.numberOfDoors = numberOfDoors;
    }

    public String getAirConditioning() {
        return airConditioning;
    }

    public void setAirConditioning(String airConditioning) {
        this.airConditioning = airConditioning;
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
                "numberOfDoors=" + numberOfDoors +
                ", airConditioning='" + airConditioning + '\'' +
                ", fuelType='" + fuelType + '\'' +
                '}';
    }
}
