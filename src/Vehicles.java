import java.io.*;
import java.util.*;

abstract class Vehicle {
    protected int hours;

    public Vehicle(int hours) {
        this.hours = hours;
    }

    public abstract double calculate();

    public int getHours() {
        return hours;
    }

    public static ArrayList<Vehicle> loadVehicles(String filePath) throws IOException {
        ArrayList<Vehicle> vehicles = new ArrayList<>();
        try (BufferedReader reader = new BufferedReader(new FileReader(filePath))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] data = line.split(",");
                String type = data[0].trim();
                int hours = Integer.parseInt(data[1].trim());

                switch (type.toLowerCase()) {
                    case "bike":
                        vehicles.add(new Bike(hours));
                        break;
                    case "normal":
                        vehicles.add(new Normal(hours));
                        break;
                    case "large":
                        vehicles.add(new Large(hours));
                        break;
                }
            }
        }
        return vehicles;
    }
}

class Bike extends Vehicle {
    public Bike(int hours) {
        super(hours);
    }

    @Override
    public double calculate() {
        double cost = hours * 10; // 10 dollars per hour
        if (hours > 6) {
            cost -= 10; // deduct the cost of one free hour
        }
        return cost;
    }

//    @Override
//    public void saveToFile(FileWriter writer) throws IOException {
//        writer.write("Bike," + hours + "\n");
//    }
}

class Normal extends Vehicle {
    public Normal(int hours) {
        super(hours);
    }

    @Override
    public double calculate() {
        double cost = hours * 20; // 20 dollars per hour
        if (hours > 6) {
            cost -= 20; // deduct the cost of one free hour
        }
        return cost;
    }

//    @Override
//    public void saveToFile(FileWriter writer) throws IOException {
//        writer.write("Normal," + hours + "\n");
//    }
}

class Large extends Vehicle {
    public Large(int hours) {
        super(hours);
    }

    @Override
    public double calculate() {
        double cost = hours * 30; // 30 dollars per hour
        if (hours > 6) {
            cost -= 30; // deduct the cost of one free hour
        }
        return cost;
    }

//    @Override
//    public void saveToFile(FileWriter writer) throws IOException {
//        writer.write("Large," + hours + "\n");
//    }
}