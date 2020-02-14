package ConsoleMenu;

import java.math.BigDecimal;

public class MotorBike extends Vehicle {
    protected String helmetType;
    protected String helmetSize;

    public MotorBike(String plateNumber, BigDecimal rentalFeePerDay, String make, String model, String type, String engineCapacity, String transmissionType, int numberOfSeats, String colour, String helmetType, String helmetSize) {
        super(plateNumber, rentalFeePerDay, make, model, type, engineCapacity, transmissionType, numberOfSeats, colour);
        this.helmetType = helmetType;
        this.helmetSize = helmetSize;
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
        return "MotorBike{" +
                "helmetType='" + helmetType + '\'' +
                ", helmetSize='" + helmetSize + '\'' +
                '}';
    }
}
