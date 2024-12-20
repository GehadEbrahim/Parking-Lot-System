import java.io.*;
import java.util.*;

public class Vehicle {
    private String licence_number;
    private String ownerName;
    private String Type;
    private int vehicleId;

    Scanner in = new Scanner(System.in);

    //constructors

    public Vehicle() {

    }

    public Vehicle(int vehicleId ,String ownerName, String type, String licence_number) {
        this.vehicleId = vehicleId;
        this.licence_number = licence_number;
        this.ownerName = ownerName;
        this.Type = type;
    }

    public List<Vehicle>loadVehicles(String filepath) throws IOException {
            List<Vehicle> vehicles = new ArrayList<>();
        try(BufferedReader read = new BufferedReader(new FileReader(filepath))) {
            String line;
            while ((line = read.readLine()) != null) {
                if (line.trim().isEmpty() || line.trim().startsWith("/")) {
                    continue;
                }try {
                    String[] parts = line.split(",");
                    vehicles.add(new Vehicle(Integer.parseInt(parts[0].trim()), parts[1].trim(), parts[2].trim(), parts[3].trim()));
                }catch (NumberFormatException e){
                    System.out.println("In " + filepath + " => Error reading line " + line);
                    throw e;
                }
            }
        }catch (IOException e){
            System.out.println("Error reading the file: " + filepath + e.getMessage());  // Changed to use the provided filePath
        }
        return vehicles;
    }
    public void setLicence_number(String licence_number) {
        this.licence_number = licence_number;
    }

    public void setOwnerName(String ownerName) {
        this.ownerName = ownerName;
    }

    public void setType(String type) {
        Type = type;
    }

    public String getLicence_number() {
        return licence_number;
    }

    public String  getOwnerName() {
        return ownerName;
    }

    public String getType() {
        return Type;
    }

    public int getVehicleId() {
        return vehicleId;
    }

    public void setVehicleId(int vehicleId) {
        this.vehicleId = vehicleId;
    }

    public void addVehicle(){
        System.out.println("How many vehicles do you want to add? (Max 3)");
        int vehicleCount = in.nextInt();
        if(vehicleCount <= 3){
            for (int i = 0; i < vehicleCount; i++) {
                System.out.println("Enter details for vehicle " + (i + 1) + ":");
                String type = null;
                System.out.print("Your vehicle type is: \n" +
                        "1) 4*4 Car\n" +
                        "2) Car\n" +
                        "3) Bike");
                System.out.print(" ==> ");
                int vehicleChoice = in.nextInt();
                switch (vehicleChoice){
                    case 1:
                        type = "large";
                        break;
                    case 2:
                        type = "normal";
                        break;
                    case 3:
                        type = "bike";
                        break;
                    default:
                        System.out.println("Invalid vehicle type choice!");
                }
                System.out.print("License Number: ");
                String licenseNumber = in.next();
                Vehicle vehicle = new Vehicle(Main.vehicles.size() + 1 , Main.owners.get(Main.index).name , type, licenseNumber);
                Main.vehicles.add(vehicle);
                System.out.println("Vehicle added successfully!\n-----------------------------");
            }
        }
        else{
            System.out.println("You can add 3 vehicles maximum.");
        }
    }
    public String vehicleDetails(){
        return "Vehicle Details:\n------------\n" +
                "Vehicle ID: " + vehicleId +"\n"+
                "Owner name: " + ownerName + "\n" +
                "License Number: " + licence_number + "\n" +
                "Vehicle Type: " + Type +"\n";
    }
    public void displayVehicles(List<Vehicle> vehicles) {
        int indexVehicle = 1;
        if (Main.vehicles.isEmpty()) {
            System.out.println("No vehicles found.");
        } else {
            for (Vehicle vehicle : Main.vehicles) {
                System.out.println(indexVehicle + ") " +vehicle.vehicleDetails());
                indexVehicle++;
            }
        }
    }
    public void displayOwnerVehicles(String ownerName) {
        boolean found = false;
        for (Vehicle vehicle : Main.vehicles) {
            if (vehicle.getOwnerName().toLowerCase().equals(ownerName.toLowerCase())) {
                System.out.println((vehicle.vehicleDetails()));
                found = true;
            }
        }
        if (!found) {
            System.out.println("No vehicles found.\nDo you want to add a vehicle? (y/n)");
            String ownerAns = in.next();
            if (ownerAns.equalsIgnoreCase("y")) {
                Main.vehicle.addVehicle();
            }
            System.out.println("For which vehicle you want to make a reservation?");
            Main.vehicle.displayOwnerVehicles(Main.name);
        }
    }

    @Override
    public String toString(){
        return vehicleId+","+ownerName + "," + Type +"," + licence_number;
    }
}


