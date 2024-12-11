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
            System.out.println("Error reading the file: " + filePath);  // Changed to use the provided filePath
            throw e;
        }
        return owners;
    }
    public void displayOwners(List<Owner> owners){
        for (int i = 0; i < owners.size(); i++) {
            System.out.println((i + 1) + ") " + owners.get(i).toString());
        }
    }
    public void menu() throws IOException {
        while (true) {
                System.out.println("1) Show my account");
                System.out.println("2) Make a reservation");
                System.out.println("3) Cancel a reservation");
                System.out.println("4) Update a reservation");
                System.out.println("5) Rewards");
                System.out.println("6) Log out");
                System.out.println("7) Delete my account");
                System.out.println("\n");
                System.out.print("Enter your choice: ");

            int menuOwnerChoice = in.nextInt();
            switch (menuOwnerChoice) {
                case 1:
                    Main.owners.get(Main.index).displayDetails();
                    break;
                case 2:
                    Main.reservationManager.reservation();
                    break;
                case 3:
                    //
                    break;
                case 4:
                    //edit
                    break;
                case 5:
                    //rewards
                    break;
                case 6:
                    System.out.println("Logging out...");
                    return;
                case 7:
                    String deleteChoice;
                    System.out.println("Are you sure you want to delete your account?(y/n)");
                    System.out.print(" ==> ");
                    deleteChoice = in.next();
                    Main.owners.remove(Main.index); //delete the owner who has logged in
                    System.out.println("Your account has been deleted.");
                    System.out.println("Logging out...");
                    return;
                default:
                    System.out.print("Invalid choice. Please enter a valid number");

            }
        }
    }
    public void Register(){
        System.out.print("Enter your name: ");
        String name = in.next();
        System.out.print("Create your password: ");
        String pass = in.next();
        System.out.print("Enter your emial: ");
        String email = in.next();
        System.out.print("Enter your phone number: ");
        int number = in.nextInt();
        Main.owners.add(new Owner(Main.owners.size() , email , name , pass , number));
    }
    public void saveOwners(String filePath) throws IOException {
        try (BufferedWriter bw = new BufferedWriter(new FileWriter(filePath))) {
            for (Owner owner : Main.owners) {
                bw.write(owner.getID() + "," +
                        owner.name + "," +
                        owner.password + "," +
                        owner.getPhone() + "," +
                        owner.getEmail());
                bw.newLine();
            }
        }
    }

}
