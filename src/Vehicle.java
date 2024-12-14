import java.io.*;
import java.util.*;

public class Vehicle {
    private String licence_number;
    private String ownerName;
    private String Type;

    Scanner in = new Scanner(System.in);

    //constructors

    public Vehicle() {

    }

    public Vehicle(String ownerName, String licence_number, String type) {
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
                }
                String[] parts = line.split(",");
                vehicles.add(new Vehicle(parts[0].trim() , parts[1].trim(), parts[2].trim()));
            }
        }catch (IOException e){
            System.out.println("Error reading the file: " + filepath + e.getMessage());  // Changed to use the provided filePath
        }
        return vehicles;
    }
    public void setLicence_number(String licence_number) {
        this.licence_number = licence_number;
    }

    public void setOwner_id(String ownerName) {
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


    public void displayVehicleDetails() {
        System.out.println("nOwner Id : " + ownerName +
                "\nLicense Number :" + licence_number +
                "\nVehicle type : " + Type);
    }

    public void addVehicle(){
        System.out.println("How many vehicles do you want to add? (Max 3)");
        int vehicleCount = in.nextInt();

        for (int i = 0; i < vehicleCount; i++) {
            System.out.println("Enter details for vehicle " + (i + 1) + ":");
            System.out.print("License Number: ");
            String licenseNumber = in.next();
            System.out.print("Vehicle Type (large, bike, normal): ");
            String type = in.next().toLowerCase();
            Vehicle vehicle = new Vehicle( Main.owners.get(Main.index).name, licenseNumber, type);
            Main.vehicles.add(vehicle);
        }
    }
    public String vehicleDetails(){
        return "Vehicle Details:\n" +
                "Owner name: " + ownerName + "\n" +
                "License Number: " + licence_number + "\n" +
                "Vehicle Type: " + Type +"\n";
    }
    public void displayVehicles(List<Vehicle> vehicles) {
        if (Main.vehicles.isEmpty()) {
            System.out.println("No vehicles found.");
        } else {
            for (Vehicle vehicle : Main.vehicles) {
                System.out.println(vehicle.vehicleDetails());
            }
        }
    }
     public void displayOwnerVehicles(int ownerId){
     if (Main.vehicles.isEmpty()) {
        System.out.println("No vehicles found.");
     } else {
            for (Vehicle vehicle : Main.vehicles) {
                if(Main.index == ownerId)
                     System.out.println(vehicle.vehicleDetails());
                else {
                    System.out.println("No vehicles found.\nDo you want to add a vehicle? (y/n)");
                    String ownerAns = in.next();
                    if (ownerAns.toLowerCase().equals("y"))
                        Main.vehicle.addVehicle();
                    else
                        return;
                }
            }
     }
}
    @Override
    public String toString(){
        return ownerName + "," + Type +"," + licence_number;
    }

}
