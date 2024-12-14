import java.io.*;
import java.util.*;

public class OwnerManager {
    Scanner in = new Scanner(System.in);
    public List<Owner> loadOwners(String filePath) throws IOException {
        List<Owner> owners = new ArrayList<>();
        try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {
            String line;
            while ((line = br.readLine()) != null) {
                if (line.trim().isEmpty() || line.trim().startsWith("/")) {
                    continue;
                }

                String[] parts = line.split(",");
                try {
                    int index = Integer.parseInt(parts[0].trim());
                    String name= parts[1].trim();
                    String password = parts[2].trim();
                    int phoneNumber = Integer.parseInt(parts[3].trim());
                    String email = parts[4].trim();
                    owners.add(new Owner(index ,email, name, password , phoneNumber));
                } catch (NumberFormatException e) {
                    System.out.println("Error parsing line: " + line);
                }
            }
        } catch (IOException e) {
            System.out.println("Error reading the file: " + filePath + e.getMessage());  // Changed to use the provided filePath
        }
        return owners;
    }
    public void displayOwners(List<Owner> owners){
        for (int i = 0; i < owners.size(); i++) {
            System.out.println((i + 1) + ") " + owners.get(i).getOwnerDetails());
        }
    }
//    public void displayOwnerVehicle() {
//        if (Main.owners.get(Main.index).getVehicles().isEmpty()) {
//            System.out.println("No vehicles associated with this owner.");
//        } else {
//            System.out.println("Vehicles : ");
//            for (Vehicle vehicle : Main.vehicles) {
//                vehicle.displayVehicleDetails();
//            }
//        }
//    }
    public void menu() throws IOException {
        while (true) {
                System.out.println("1) Show my account");
                System.out.println("2) Edit my account");
                System.out.println("3) Add vehicles");
                System.out.println("4) Reservations");
                System.out.println("5) Rewards");
                System.out.println("6) Log out");
                System.out.println("7) Delete my account");
                System.out.println("\n");
                System.out.print(" ==> ");

            int menuOwnerChoice = in.nextInt();
            switch (menuOwnerChoice) {
                case 1:
                    Main.owners.get(Main.index).displayDetails();
                    break;
                case 2:
                    this.editProfile();
                    break;
                case 3:
                    Main.vehicle.addVehicle();
                    break;
                case 4:
                    Main.reservationManager.reservationMenu();
                    break;
                case 5:
                    //rewards
                    break;
                case 6:
                    System.out.println("\t\t\t\t\t\tLogging out.....\n\t\t\t\t\t\t\t\tGoodbye!");
                    Main.name = null;
                    return;
                case 7:
                    String deleteChoice;
                    System.out.println("Are you sure you want to delete your account?(y/n)");
                    System.out.print(" ==> ");
                    deleteChoice = in.next();
                    Main.owners.remove(Main.index); //delete the owner who has logged in
                    System.out.println("Your account has been deleted.");
                    System.out.println("\t\t\t\t\t\tLogging out.....\n\t\t\t\t\t\t\t\tGoodbye!");
                    Main.name = null;
                    return;
                default:
                    System.out.print("Invalid choice. Please enter a valid number");
            }
        }
    }
    public void editProfile(){
        System.out.println("What do you want to edit?");
        System.out.println("1) Name");
        System.out.println("2) Password");
        System.out.println("3) Email");
        System.out.println("4) Phone number");
        System.out.println(" ==> ");

        int editChoice = in.nextInt();
        switch (editChoice){
            case 1:
                System.out.print("Enter the new name: ");
                String name = in.next();
                Main.owners.get(Main.index).setName(name);
                System.out.println("Name changed successfuly!\n");
                break;
            case 2:
                System.out.print("Enter the new password: ");
                String pass = in.next();
                Main.owners.get(Main.index).setPassword(pass);
                System.out.println("Password changed successfuly!\n");
                break;
            case 3:
                System.out.print("Enter the new email: ");
                String email = in.next();
                Main.owners.get(Main.index).setEmail(email);
                System.out.println("Email changed successfuly!\n");
                break;
            case 4:
                System.out.print("Enter the new phone number: ");
                int phone = in.nextInt();
                Main.owners.get(Main.index).setPhone(phone);
                System.out.println("Phone number changed successfuly!\n");
                break;
            default:
                System.out.println("Invalid Choice!");
        }

    }
    public void Register(){
        System.out.print("Enter your name: ");
        String name = in.next();
        Main.name = name;
        System.out.print("Create your password: ");
        String pass = in.next();
        System.out.print("Enter your emial: ");
        String email = in.next();
        System.out.print("Enter your phone number: ");
        int number = in.nextInt();
        Main.index = Main.owners.size();
        Main.owners.add(new Owner(Main.index , email , name , pass , number));
        Main.vehicle.addVehicle();
    }
}
