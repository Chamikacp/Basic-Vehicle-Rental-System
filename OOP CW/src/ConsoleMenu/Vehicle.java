package ConsoleMenu;

import java.math.BigDecimal;
import java.util.Objects;

public abstract class Vehicle {
    protected String plateNumber;
    protected BigDecimal rentalFeePerDay;
    protected String make;
    protected String model;
    protected String type;
    protected String engineCapacity;
    protected String transmissionType;
    protected int numberOfSeats;
    protected String colour;

    public Vehicle(String plateNumber, BigDecimal rentalFeePerDay, String make, String model, String type, String engineCapacity, String transmissionType, int numberOfSeats, String colour) {
        this.plateNumber = plateNumber;
        this.rentalFeePerDay = rentalFeePerDay;
        this.make = make;
        this.model = model;
        this.type = type;
        this.engineCapacity = engineCapacity;
        this.transmissionType = transmissionType;
        this.numberOfSeats = numberOfSeats;
        this.colour = colour;
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

    @Override
    public String toString() {
        return "Vehicle{" +
                "plateNumber='" + plateNumber + '\'' +
                ", rentalFeePerDay=" + rentalFeePerDay +
                ", make='" + make + '\'' +
                ", model='" + model + '\'' +
                ", type='" + type + '\'' +
                ", engineCapacity='" + engineCapacity + '\'' +
                ", transmissionType='" + transmissionType + '\'' +
                ", numberOfSeats=" + numberOfSeats +
                ", colour='" + colour + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Vehicle)) return false;
        Vehicle vehicle = (Vehicle) o;
        return getNumberOfSeats() == vehicle.getNumberOfSeats() &&
                getPlateNumber().equals(vehicle.getPlateNumber()) &&
                getRentalFeePerDay().equals(vehicle.getRentalFeePerDay()) &&
                getMake().equals(vehicle.getMake()) &&
                getModel().equals(vehicle.getModel()) &&
                getType().equals(vehicle.getType()) &&
                getEngineCapacity().equals(vehicle.getEngineCapacity()) &&
                getTransmissionType().equals(vehicle.getTransmissionType()) &&
                getColour().equals(vehicle.getColour());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getPlateNumber(), getRentalFeePerDay(), getMake(), getModel(), getType(), getEngineCapacity(), getTransmissionType(), getNumberOfSeats(), getColour());
    }

}
