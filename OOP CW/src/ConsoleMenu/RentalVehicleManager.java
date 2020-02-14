package ConsoleMenu;

public interface RentalVehicleManager {
    public abstract void addVehicle();
    public abstract void deleteVehicle();
    public abstract void updateVehicle();
    public abstract void printAllVehicles();
    public abstract void saveToAFile();
    public abstract void openCustomerBooking();
    public abstract boolean inputMenu();
    public abstract boolean checkOldVehicle(String plateNumber);
    public abstract boolean findCar(String plateNumber);
    public abstract boolean findBike(String plateNumber);
}
