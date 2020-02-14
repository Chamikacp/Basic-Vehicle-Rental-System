package ConsoleMenu;

import com.mongodb.*;
import com.mongodb.Cursor;

import java.awt.*;
import java.io.*;
import java.math.BigDecimal;
import java.net.URI;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

public class WestminsterRentalVehicleManager implements RentalVehicleManager {

    //Connection to the mongoDB
    private MongoClient mongoClient = new MongoClient("localhost",27017);
    private DB database = mongoClient.getDB("Westminster_Rental_Vehicle_Manager");
    private DBCollection collectionCar = database .getCollection("Cars");
    private DBCollection collectionBike = database .getCollection("Motorbikes");

    //To get the count of collection
    private int carCount ;
    private int bikeCount;
    private int totalCount;
    private int availableCount;

    //To store the entered values
    private ArrayList<Vehicle> vehicles = new ArrayList<>();

    //To turn off the logging message to the mongoDB
    private static Logger mongoDBLogger = Logger.getLogger("org.mongodb.driver");

    private static void LogMessages() {
        mongoDBLogger.setLevel(Level.SEVERE);
    }

    //To get all the manger inputs
    Scanner managerInput = new Scanner(System.in);

    //To add vehicles to the database
    @Override
    public void addVehicle() {
        String plateNumber;
        BigDecimal rentalFeePerDay;
        int numberOfSeats;
        int numberOfDoors;

        //To get the count of the database objects
        carCount = (int) database.getCollection("Cars").count();
        bikeCount = (int) database.getCollection("Motorbikes").count();
        totalCount = carCount+bikeCount;
        availableCount = 50-totalCount;

        //Details of the parking lot
        System.out.println("* Number of Cars available             = "+carCount);
        System.out.println("* Number of Motorbikes available       = "+bikeCount);
        System.out.println("* Number of all the vehicles available = " +totalCount);
        System.out.println("* Number of available parking slots    = "+availableCount);
        System.out.println();

            //To get the maximum storage of the parking lot
            if (totalCount <= 50) {
                //To select the vehicle category
                System.out.println("\n What vehicle do you want to add? \n");
                System.out.println("Enter number 1 to Add a Car");
                System.out.println("Enter number 2 to Add a Motorbike");
                System.out.println();

                //To get the selected option
                System.out.print("INPUT : ");
                int addInput = managerInput.nextInt();

                //To get and validate the plate number of the vehicle
                while (true) {
                    System.out.print("Enter the plate number (Example:- ABC-1234) : ");
                    plateNumber = managerInput.next();
                    if (plateNumber.length() == 0) {
                        System.out.print("You didn't enter a value !!! Enter again");

                    } else if (plateNumber.length() > 8) {
                        System.out.println("Entered plate number is not valid !!! Enter again");

                    } else if (checkOldVehicle(plateNumber)){
                        System.out.println("Entered plate number already exists !!! Enter again new plate number");

                    }else {
                        break;
                    }

                }

                //To get and validate the rental of the vehicle
                while (true) {
                    try {
                        System.out.print("Enter the rental fee per day : ");
                        rentalFeePerDay = new BigDecimal(managerInput.next());
                        break;
                    } catch (Exception e) {
                        System.out.println("You have entered a invalid value.Please enter a valid value !!!");
                    }
                }

                //To get the make of the vehicle
                System.out.print("Enter the  make : ");
                String make = managerInput.next();

                //To get the model of the vehicle
                System.out.print("Enter the model : ");
                String model = managerInput.next();

                //To get the type of the vehicle
                System.out.print("Enter the type : ");
                String type = managerInput.next();

                //To get the engine capacity of the vehicle
                System.out.print("Enter the engine capacity (Example:- 1000cc) : ");
                String engineCapacity = managerInput.next();

                //To get the transmission type of the vehicle
                System.out.print("Enter the transmission type : ");
                String transmissionType = managerInput.next();

                //To get and validate number of seats of the vehicle
                while (true) {
                    try {
                        System.out.print("Enter the number of seats : ");
                        numberOfSeats = managerInput.nextInt();
                        break;
                    } catch (InputMismatchException e) {
                        System.out.println("You have entered a invalid value.Please enter a valid value !!! ");
                        managerInput.nextLine();
                    }
                }

                //To get the colour of the vehicle
                System.out.print("Enter the colour : ");
                String colour = managerInput.next();

                //For the selected category
                switch (addInput) {
                    case 1:

                        //To get and validate the number of doors of the car
                        while (true) {
                            try {
                                System.out.print("Enter the number of doors : ");
                                numberOfDoors = managerInput.nextInt();
                                break;
                            } catch (InputMismatchException e) {
                                System.out.println("You have entered a invalid value.Please enter a valid value !!!");
                                managerInput.nextLine();
                            }
                        }

                        //To get the A/C type of the car
                        System.out.print("Enter the air-conditioning type : ");
                        String airConditioningType = managerInput.next();

                        //To get fuel type of the car
                        System.out.print("Enter the fuel type : ");
                        String fuelType = managerInput.next();

                        //To access to the car class
                        Car car = new Car(plateNumber, rentalFeePerDay, make, model, type, engineCapacity, transmissionType, numberOfSeats, colour, numberOfDoors, airConditioningType, fuelType);

                        //To add the car attributes to the array
                        vehicles.add(car);

                        //To add the given attributes to the collection
                        BasicDBObject carRow = new BasicDBObject("plateNumber", car.getPlateNumber()).
                                append("rentalFeePerDay", car.getRentalFeePerDay()).
                                append("make", car.getMake()).
                                append("model", car.getModel()).
                                append("type", car.getType()).
                                append("engineCapacity", car.getEngineCapacity()).
                                append("transmissionType", car.getTransmissionType()).
                                append("numberOfSeats", car.getNumberOfSeats()).
                                append("colour", car.getColour()).
                                append("numberOfDoors", car.getNumberOfDoors()).
                                append("airConditioningType", car.getAirConditioning()).
                                append("fuelType", car.getFuelType());
                        collectionCar.insert(carRow);
                        System.out.println();
                        System.out.println("New Car added Successfully !!!");
                        break;

                    case 2:

                        //To get helmet type of the motor bike
                        System.out.print("Enter the motorbike helmet type : ");
                        String helmetType = managerInput.next();

                        //TO get the helmet size of the motor bike
                        System.out.print("Enter the motorbike helmet size (Example:- Small,Medium or Large) : ");
                        String helmetSize = managerInput.next();

                        //To access to the motorbike class
                        MotorBike motorBike = new MotorBike(plateNumber, rentalFeePerDay, make, model, type, engineCapacity, transmissionType, numberOfSeats, colour, helmetType, helmetSize);

                        //To add the motorbike attributes to the array
                        vehicles.add(motorBike);

                        //To add the given attributes to the collection
                        BasicDBObject motorbikeRow = new BasicDBObject("plateNumber", motorBike.getPlateNumber()).
                                append("rentalFeePerDay", motorBike.getRentalFeePerDay()).
                                append("make", motorBike.getMake()).
                                append("model", motorBike.getModel()).
                                append("type", motorBike.getType()).
                                append("engineCapacity", motorBike.getEngineCapacity()).
                                append("transmissionType", motorBike.getTransmissionType()).
                                append("numberOfSeats", motorBike.getNumberOfSeats()).
                                append("colour", motorBike.getColour()).
                                append("helmetType", motorBike.getHelmetType()).
                                append("helmetSize", motorBike.getHelmetSize());
                        collectionBike.insert(motorbikeRow);
                        System.out.println();
                        System.out.println("New Motorbike added Successfully !!!");
                        break;

                    //To validate choice
                    default:
                        System.out.println("\n Wrong INPUT !!! \n");
                        this.addVehicle();
                }
            } else {
                System.out.println("!!!!!! You can't add more vehicles,because parking lot is FULL !!!!!!");
                this.inputMenu();
            }
    }

    //To check the entered the plate number is already entered
    @Override
    public boolean checkOldVehicle(String plateNumber){
        BasicDBObject whereQuery = new BasicDBObject();
        whereQuery.put("plateNumber", plateNumber);
        carCount = database.getCollection("Cars").find(whereQuery).count();
        bikeCount = database.getCollection("Motorbikes").find(whereQuery).count();
        if (carCount>0){
            return true;
        }else if (bikeCount>0){
            return true;
        }
        return false;
    }

    //To check the entered plate number is available in Car list
    @Override
    public boolean findCar(String plateNumber){
        BasicDBObject findCarQuery = new BasicDBObject();
        findCarQuery.put("plateNumber", plateNumber);
        int carCount = database.getCollection("Cars").find(findCarQuery).count();
        if (carCount==0){
            return true;
        }
        return false;
    }

    //To check the entered plate number is available in Motorbike list
    @Override
    public boolean findBike(String plateNumber){
        BasicDBObject findBikeQuery = new BasicDBObject();
        findBikeQuery.put("plateNumber", plateNumber);
        int bikeCount = database.getCollection("Motorbikes").find(findBikeQuery).count();
        if (bikeCount==0){
            return true;
        }
        return false;
    }

    //TO delete vehicles from the database
    @Override
    public void deleteVehicle() {
        String plateNumber;

        carCount = (int) database.getCollection("Cars").count();
        bikeCount = (int) database.getCollection("Motorbikes").count();
        totalCount = carCount+bikeCount;
        availableCount = 50-totalCount;

        //Details of the parking lot
        System.out.println("Number of Cars available             = "+carCount);
        System.out.println("Number of Motorbikes available       = "+bikeCount);
        System.out.println("Number of all the vehicles available = " +totalCount);
        System.out.println();

        //To select the vehicle category
        System.out.println("\n What vehicle do you want to remove? \n");
        System.out.println("Enter number 1 to Remove a Car");
        System.out.println("Enter number 2 to Remove a Motorbike");
        System.out.println("Enter number 3 to Goto Main menu");

        //To get the selected option
        System.out.print("\n INPUT : ");
        int deleteInput = managerInput.nextInt();

        //For the selected category
        switch (deleteInput){
            case 1:

                //To print all the car list
                System.out.println();
                System.out.println("*** All available Cars ***");
                System.out.println();
                Cursor carsCursor = collectionCar.find();
                while (carsCursor.hasNext()){
                    System.out.println(carsCursor.next());
                }
                System.out.println();

                //To get and validate the plate number of the car
                while (true){
                    System.out.print("Enter the plate number of the car (Example:- ABC-1234) : ");
                    plateNumber = managerInput.next();
                    if (plateNumber.length() == 0){
                        System.out.println("You didn't enter a value !!! Enter again");

                    }else if (plateNumber.length() >8){
                        System.out.println("Entered plate number is not valid !!! Enter again");

                    }else if (findCar(plateNumber)){
                        System.out.println("Entered vehicle not available !!! Enter again");

                    }else {
                        break;
                    }
                }
                System.out.println();

                //To print the deleting car
                BasicDBObject deleteCarObject = new BasicDBObject("plateNumber",plateNumber);
                System.out.println("FOLLOWING CAR HAS BEEN DELETED !!!");
                System.out.println();
                DBCursor deleteCarCursor = collectionCar.find(deleteCarObject);
                while (deleteCarCursor.hasNext()){
                    System.out.println(deleteCarCursor.next());
                }

                //To delete the car
                collectionCar.remove(deleteCarObject);
                System.out.println();

                carCount = (int) database.getCollection("Cars").count();
                bikeCount = (int) database.getCollection("Motorbikes").count();
                totalCount = carCount+bikeCount;
                availableCount = 50-totalCount;

                //To print the available slots
                System.out.println("* Number of available parking slots = "+availableCount);
                break;
            case 2:

                //To print the motorbike list
                System.out.println();
                System.out.println("*** All available Motorbikes ***");
                System.out.println();
                Cursor bikesCursor = collectionBike.find();
                while (bikesCursor.hasNext()){
                    System.out.println(bikesCursor.next());
                }
                System.out.println();

                //To get and validate the plate number of the motorbike
                while (true){
                    System.out.print("Enter the plate number of the motorbike (Example:- ABC-1234):");
                    plateNumber = managerInput.next();
                    if (plateNumber.length() == 0){
                        System.out.println("You didn't enter a value !!! Enter again");

                    }else if (plateNumber.length() >8){
                        System.out.println("Entered plate number is not valid !!! Enter again");

                    }else if (findBike(plateNumber)){
                        System.out.println("Entered plate number not available !!! Enter again");

                    }else {
                        break;
                    }
                }
                System.out.println();

                //To print the deleting bike
                BasicDBObject deleteBikeObject = new BasicDBObject("plateNumber",plateNumber);
                System.out.println("FOLLOWING MOTORBIKE HAS BEEN DELETED !!!");
                System.out.println();
                DBCursor deleteBikeCursor = collectionBike.find(deleteBikeObject);
                while (deleteBikeCursor.hasNext()){
                    System.out.println(deleteBikeCursor.next());
                }

                //To remove the motorbike
                collectionBike.remove(deleteBikeObject);
                System.out.println();

                carCount = (int) database.getCollection("Cars").count();
                bikeCount = (int) database.getCollection("Motorbikes").count();
                totalCount = carCount+bikeCount;
                availableCount = 50-totalCount;

                //To print the available slots
                System.out.println("* Number of available parking slots = "+availableCount);
                break;
            case 3:
                this.inputMenu();
                break;
            default:
                System.out.println("\n Wrong INPUT !!! \n");
                this.deleteVehicle();
        }

    }

    //To update the details of a entered vehicle
    @Override
    public void updateVehicle() {
        String plateNumber;
        BigDecimal rentalFeePerDay;
        int numberOfSeats;
        int numberOfDoors;

        System.out.println("\n What vehicle do you want to update? \n");
        System.out.println("Enter number 1 to Update a Car");
        System.out.println("Enter number 2 to Update a Motorbike");
        System.out.println("Enter number 3 to Goto Main menu");

        System.out.print("\n INPUT : ");
        int updateInput = managerInput.nextInt();

        //To create a object to store the updating value
        BasicDBObject updateObject = new BasicDBObject();

        //To update car
        switch (updateInput){
            case 1:
                System.out.println();
                Cursor cursor1 = collectionCar.find();
                while (cursor1.hasNext()){

                    System.out.println(cursor1.next());
                }
                System.out.println();
                System.out.println("Enter the plate number of the car :");
                String updatePlateNumberCar = managerInput.next();

                BasicDBObject oldObjectCar = new BasicDBObject().append("plateNumber",updatePlateNumberCar);

                System.out.println("What is the attribute do  you want to update");
                System.out.println("Enter 1 to update vehicle number");
                System.out.println("Enter 2 to update rental fee per day");
                System.out.println("Enter 3 to update make");
                System.out.println("Enter 4 to update model");
                System.out.println("Enter 5 to update type");
                System.out.println("Enter 6 to update engine capacity");
                System.out.println("Enter 7 to update transmission type");
                System.out.println("Enter 8 to update number of seats");
                System.out.println("Enter 9 to update colour");
                System.out.println("Enter 10 to update number Of Doors");
                System.out.println("Enter 11 to update airConditioning Type");
                System.out.println("Enter 12 to update fuel type");

                System.out.print("\n INPUT : ");
                int updateAttributeCar = managerInput.nextInt();

                switch (updateAttributeCar){
                    case 1:
                        while (true){
                            System.out.print("Enter the new plate number (Example:- ABC-1234):");
                            plateNumber = managerInput.next();
                            if (plateNumber.length() == 0){
                                System.out.println("You didn't enter a value !!!");
                            }else if (plateNumber.length() >8){
                                System.out.println("Entered plate number is not valid !!!");
                            }else{
                                break;
                            }
                        }
                        updateObject.append("$set",new BasicDBObject().append("plateNumber",plateNumber));
                        collectionCar.update(oldObjectCar,updateObject);
                        break;
                    case 2:
                        while (true){
                            try{
                                System.out.print("Enter the new rental fee per day :");
                                rentalFeePerDay = new BigDecimal(managerInput.next());
                                break;
                            }catch (Exception e){
                                System.out.println("You have entered a invalid value.Please enter a valid value !!!");
                            }
                        }
                        updateObject.append("$set",new BasicDBObject().append("rentalFeePerDay",rentalFeePerDay));
                        collectionCar.update(oldObjectCar,updateObject);
                        break;
                    case 3:
                        System.out.print("Enter the new make :");
                        String make = managerInput.next();
                        updateObject.append("$set",new BasicDBObject().append("make",make));
                        collectionCar.update(oldObjectCar,updateObject);
                        break;
                    case 4:
                        System.out.print("Enter the new model :");
                        String model = managerInput.next();
                        updateObject.append("$set",new BasicDBObject().append("model",model));
                        collectionCar.update(oldObjectCar,updateObject);
                        break;
                    case 5:
                        System.out.print("Enter the new type :");
                        String type = managerInput.next();
                        updateObject.append("$set",new BasicDBObject().append("type",type));
                        collectionCar.update(oldObjectCar,updateObject);
                    case 6:
                        System.out.print("Enter the new engine capacity (Example:- 1000cc) :");
                        String engineCapacity = managerInput.next();
                        updateObject.append("$set",new BasicDBObject().append("engineCapacity",engineCapacity));
                        collectionCar.update(oldObjectCar,updateObject);
                        break;
                    case 7:
                        System.out.print("Enter the new transmission type :");
                        String transmissionType = managerInput.next();
                        updateObject.append("$set",new BasicDBObject().append("transmissionType",transmissionType));
                        collectionCar.update(oldObjectCar,updateObject);
                    case 8:
                        while (true){
                            try{
                                System.out.print("Enter the new number of seats :");
                                numberOfSeats = managerInput.nextInt();
                                break;
                            }catch (InputMismatchException e){
                                System.out.println("You have entered a invalid value.Please enter a valid value !!!");
                                managerInput.nextLine();
                            }
                        }
                        updateObject.append("$set",new BasicDBObject().append("numberOfSeats",numberOfSeats));
                        collectionCar.update(oldObjectCar,updateObject);
                        break;
                    case 9:
                        System.out.print("Enter the new colour :");
                        String colour = managerInput.next();
                        updateObject.append("$set",new BasicDBObject().append("rentalFeePerDay",colour));
                        collectionCar.update(oldObjectCar,updateObject);
                        break;
                    case 10:
                        while (true){
                            try{
                                System.out.print("Enter the new number of doors :");
                                numberOfDoors = managerInput.nextInt();
                                break;
                            }catch (InputMismatchException e){
                                System.out.println("You have entered a invalid value.Please enter a valid value !!!");
                                managerInput.nextLine();
                            }
                        }
                        updateObject.append("$set",new BasicDBObject().append("numberOfDoors",numberOfDoors));
                        collectionCar.update(oldObjectCar,updateObject);
                        break;
                    case 11:
                        System.out.print("Enter the new air-conditioning type :");
                        String airConditioningType = managerInput.next();
                        updateObject.append("$set",new BasicDBObject().append("airConditioningType",airConditioningType));
                        collectionCar.update(oldObjectCar,updateObject);
                        break;
                    case 12:
                        System.out.print("Enter the new fuel type :");
                        String fuelType = managerInput.next();
                        updateObject.append("$set",new BasicDBObject().append("fuelType",fuelType));
                        collectionCar.update(oldObjectCar,updateObject);
                        break;
                    default:
                        System.out.println("\n Wrong INPUT !!! \n");
                        this.updateVehicle();
                }
                System.out.println();
                System.out.println("Car updated Successfully !!!");
                break;

            //To update bike
            case 2:
                System.out.println();
                Cursor cursor2 = collectionBike.find();
                while (cursor2.hasNext()){
                    System.out.println(cursor2.next());
                }
                System.out.println();
                System.out.println("Enter the plate number of the motorbike :");
                String updatePlateNumberBike = managerInput.next();

                BasicDBObject oldObjectBike = new BasicDBObject().append("plateNumber",updatePlateNumberBike);

                System.out.println("What is the attribute do  you want to update");
                System.out.println("Enter 1 to update vehicle number");
                System.out.println("Enter 2 to update rental fee per day");
                System.out.println("Enter 3 to update make");
                System.out.println("Enter 4 to update model");
                System.out.println("Enter 5 to update type");
                System.out.println("Enter 6 to update engine capacity");
                System.out.println("Enter 7 to update transmission type");
                System.out.println("Enter 8 to update number of seats");
                System.out.println("Enter 9 to update colour");
                System.out.println("Enter 10 to update helmet type");
                System.out.println("Enter 11 to update helmet size");

                System.out.print("\n INPUT : ");
                int updateAttributeBike = managerInput.nextInt();

                switch (updateAttributeBike){
                    case 1:
                        while (true){
                            System.out.print("Enter the new plate number (Example:- ABC-1234):");
                            plateNumber = managerInput.next();
                            if (plateNumber.length() == 0){
                                System.out.println("You didn't enter a value !!!");
                            }else if (plateNumber.length() >8){
                                System.out.println("Entered plate number is not valid !!!");
                            }else{
                                break;
                            }
                        }
                        updateObject.append("$set",new BasicDBObject().append("plateNumber",plateNumber));
                        collectionBike.update(oldObjectBike,updateObject);
                        break;
                    case 2:
                        while (true){
                            try{
                                System.out.print("Enter the new rental fee per day :");
                                rentalFeePerDay = new BigDecimal(managerInput.next());
                                break;
                            }catch (Exception e){
                                System.out.println("You have entered a invalid value.Please enter a valid value !!!");
                            }
                        }
                        updateObject.append("$set",new BasicDBObject().append("rentalFeePerDay",rentalFeePerDay));
                        collectionBike.update(oldObjectBike,updateObject);
                        break;
                    case 3:
                        System.out.print("Enter the new make :");
                        String make = managerInput.next();
                        updateObject.append("$set",new BasicDBObject().append("make",make));
                        collectionBike.update(oldObjectBike,updateObject);
                        break;
                    case 4:
                        System.out.print("Enter the new model :");
                        String model = managerInput.next();
                        updateObject.append("$set",new BasicDBObject().append("model",model));
                        collectionBike.update(oldObjectBike,updateObject);
                        break;
                    case 5:
                        System.out.print("Enter the new type :");
                        String type = managerInput.next();
                        updateObject.append("$set",new BasicDBObject().append("type",type));
                        collectionBike.update(oldObjectBike,updateObject);
                        break;
                    case 6:
                        System.out.print("Enter the new engine capacity (Example:- 1000cc) : ");
                        String engineCapacity = managerInput.next();
                        updateObject.append("$set",new BasicDBObject().append("engineCapacity",engineCapacity));
                        collectionBike.update(oldObjectBike,updateObject);
                        break;
                    case 7:
                        System.out.print("Enter the new transmission type :");
                        String transmissionType = managerInput.next();
                        updateObject.append("$set",new BasicDBObject().append("transmissionType",transmissionType));
                        collectionBike.update(oldObjectBike,updateObject);
                        break;
                    case 8:
                        while (true){
                            try{
                                System.out.print("Enter the new number of seats :");
                                numberOfSeats = managerInput.nextInt();
                                break;
                            }catch (InputMismatchException e){
                                System.out.println("You have entered a invalid value.Please enter a valid value !!!");
                                managerInput.nextLine();
                            }
                        }
                        updateObject.append("$set",new BasicDBObject().append("numberOfSeats",numberOfSeats));
                        collectionBike.update(oldObjectBike,updateObject);
                        break;
                    case 9:
                        System.out.print("Enter the new colour :");
                        String colour = managerInput.next();
                        updateObject.append("$set",new BasicDBObject().append("rentalFeePerDay",colour));
                        collectionBike.update(oldObjectBike,updateObject);
                    case 10:
                        System.out.print("Enter the new helmet type :");
                        int helmetType = managerInput.nextInt();
                        updateObject.append("$set",new BasicDBObject().append("helmetType",helmetType));
                        collectionBike.update(oldObjectBike,updateObject);
                        break;
                    case 11:
                        System.out.print("Enter the new helmet size (Example:- Small,Medium or Large) : ");
                        String helmetSize = managerInput.next();
                        updateObject.append("$set",new BasicDBObject().append("helmetSize",helmetSize));
                        collectionBike.update(oldObjectBike,updateObject);
                        break;
                    default:
                        System.out.println("\n Wrong INPUT !!! \n");
                }
                System.out.println();
                System.out.println("Motorbike updated Successfully !!!");
                break;
            case 3:
                this.inputMenu();
                break;
            default:
                System.out.println("\n Wrong INPUT !!! \n");
                this.updateVehicle();
        }
    }

    //To print the all vehicles in a sorted way
    @Override
    public void printAllVehicles() {

        //To find the all vehicles and sort them using make
        Cursor cursorPrintCars = collectionCar.find().sort(new BasicDBObject("make",1));
        Cursor cursorPrintBikes = collectionBike.find().sort(new BasicDBObject("make",1));

        System.out.println();
        System.out.println("--------  ALL CARS --------");
        System.out.println();
        while (cursorPrintCars.hasNext()){
            System.out.println(cursorPrintCars.next());
        }
        System.out.println();
        System.out.println("-------- ALL MOTORBIKES --------");
        System.out.println();
        while (cursorPrintBikes.hasNext()){
            System.out.println(cursorPrintBikes.next());
        }
    }

    //To save the all details of the vehicles to text file
    @Override
    public void saveToAFile() {
        try {
            Cursor cursorCarData = (Cursor) collectionCar.find().iterator();
            Cursor cursorMotorbikeData = (Cursor) collectionBike.find().iterator();

            //Saving path of the text file
            String path = "./allVehicleData.txt";

            PrintWriter out = new PrintWriter(
                    new BufferedWriter(new FileWriter(path, true))
            );

            //To specify the saved day
            DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss");
            LocalDateTime today = LocalDateTime.now();
            out.println("###############################  "+dateTimeFormatter.format(today)+"  ###############################");

            //To print all car details
            out.println();
            out.println("ALL CARS");
            out.println();
            while(cursorCarData.hasNext()){
                out.println(cursorCarData.next().toString());
            }

            //To print all bike details
            out.println();
            out.println("ALL MOTORBIKES");
            out.println();
            while(cursorMotorbikeData.hasNext()){
                out.println(cursorMotorbikeData.next().toString());
            }
            out.flush();
            out.close();

            System.out.println();
            System.out.println("Saved to the text file !!!");
            System.out.println();
        } catch (IOException e) {
            System.out.println("Error in writing to the file !!!!");
        }
    }

    //To open the customer GUI
    @Override
    public void openCustomerBooking() {
        try {
            Desktop gui = java.awt.Desktop.getDesktop();
            URI guiURL = new URI("http://localhost:4200/");
            gui.browse(guiURL);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    //Main menu for the all the methods
    @Override
    public boolean inputMenu() {
        boolean quit = false;
        System.out.println();
        System.out.println("Enter 1 to Add a new vehicle");
        System.out.println("Enter 2 to Remove a vehicle");
        System.out.println("Enter 3 to Update a vehicle");
        System.out.println("Enter 4 to View all vehicles");
        System.out.println("Enter 5 t0 Add all data to a text file");
        System.out.println("Enter 6 to Open the customer bookings");
        System.out.println("Enter 7 to Log out");
        System.out.println();

        System.out.print("INPUT : ");
        System.out.println();
        int enteredNumber = managerInput.nextInt();

        switch (enteredNumber){
            case 1:
                this.addVehicle();
                break;
            case 2:
                this.deleteVehicle();
                break;
            case 3:
                this.updateVehicle();
                break;
            case 4:
                this.printAllVehicles();
                break;
            case 5:
                this.saveToAFile();
                break;
            case 6:
                this.openCustomerBooking();
                break;
            case 7:
                System.out.println("\n SYSTEM IS SHUTTING DOWN 3...2...1 !!!");
                quit = true;
                break;
            default:
                System.out.println("\n WRONG INPUT !!! \n");
                this.inputMenu();
        }
       return quit;
    }

    //Main method with the login to the system
    public static void main(String[] args) {
        LogMessages();
        boolean quit = false;
        while (!quit) {
            System.out.println("------------------------------------------------------------------------------ \n");
            System.out.println(" ********************* WESTMINSTER RENTAL VEHICLE MANAGER ********************* \n");
            System.out.println("_________________________________________________________________________________");
            System.out.println();
            Scanner y = new Scanner(System.in);
            System.out.print("Enter user name : ");
            String userName = y.nextLine();
            System.out.print("Enter password  : ");
            String password = y.nextLine();
            if (userName.equals("user") && password.equals("password")) {
                System.out.println();
                System.out.println("--------------------------- LOGIN SUCCESSFUL ---------------------------------");
                System.out.println();
                System.out.println("!!!!!!!!!!!!!!!!!!! REMEMBER YOU MUST FILL THE FIELD OTHERWISE YOU CANT GO FURTHER !!!!!!!!!!!!!!!!!!!");
                RentalVehicleManager rentalVehicleManager = new WestminsterRentalVehicleManager();

                while (!quit) {
                    quit = rentalVehicleManager.inputMenu();
                }
            } else {
                System.out.println("!!!!!!!!!!!!!!!!!!!!! LOGIN UNSUCCESSFUL !!!!!!!!!!!!!!!!!!!!!!!!!!!");
            }
        }

    }
}
