import java.io.*;
import java.util.*;

public class Main {

    public static List<Spot> spots = new ArrayList<>();
    public static List<Slot> slots = new ArrayList<>(3);
    public static List<Reservation> reservations = new ArrayList<>();
    public static List<Owner> owners = new ArrayList<>();
    public static List<Vehicle> vehicles = new ArrayList<>();

    public static SpotManager spotManager = new SpotManager();
    public static SlotManager slotManager = new SlotManager();
    public static ReservationManager reservationManager = new ReservationManager();
    public static OwnerManager ownerManager = new OwnerManager();
    public static String name;
    public static int index = 0;
    public static Vehicle vehicle = new Vehicle();
    static Admin admin = new Admin();

    //****************************Start Main****************************//
    public static void main(String[] args) throws IOException {
            GeneralFunctions generalFunctions = new GeneralFunctions();
        try {
            vehicles = vehicle.loadVehicles(FilePaths.VEHICLES_FILE_PATH);
            spots = spotManager.loadSpots(FilePaths.SPOTS_FILE_PATH); // it returns an ArrayList its type is Spot
            slots = slotManager.loadSlots(FilePaths.SLOTS_FILE_PATH);
            reservations = reservationManager.loadReservations(FilePaths.RESERVATIONS_FILE_PATH);
            owners = ownerManager.loadOwners(FilePaths.OWNERS_FILE_PATH);
        } catch (Exception e) {
            System.out.println("Error loading data: " + e.getMessage());
        }
        try {
            System.out.println("Vehicles loaded: " + Main.vehicles.size());

            startLog();
        } catch (Exception e) {
            System.out.print("An error occurred: " + e.getMessage());
        }
        // Save any changes to the file only at the end
        generalFunctions.WriteInFile(FilePaths.OWNERS_FILE_PATH , owners);
        generalFunctions.WriteInFile(FilePaths.RESERVATIONS_FILE_PATH , reservations);
        generalFunctions.WriteInFile(FilePaths.SPOTS_FILE_PATH , spots);
        generalFunctions.WriteInFile(FilePaths.SLOTS_FILE_PATH , slots);

    }








    /***********methods*********************/
    public static void startLog() throws Exception {
        Scanner in = new Scanner(System.in);
        String ans = "Y";
        int anserLogReges;
        String password;

        System.out.println("\n\t\t\t\tWelcome to the parking lot System!\n\t\t\t\t\t\t----------------------");
        try {
            System.out.println("1) LogIn");
            System.out.println("2) Register");
            System.out.print(" ==> ");
            anserLogReges = in.nextInt();
            in.nextLine(); // consume newline character from nextInt()

            if (anserLogReges == 1) {
                System.out.print("Enter your name: ");
                name = in.nextLine();
                System.out.print("Enter Your Password: ");
                password = in.nextLine(); // Using nextLine() instead of next()
                if(name.toLowerCase().equals("admin") && password.toLowerCase().equals("admin")){
                    System.out.println("\n\t\t\t\tWelcome Admin \n\t\t\t  ----------------------");
                    AdminManager adminManager= new AdminManager();
                    adminManager.meanFunction();
                }
                else{
                    boolean found = false;
                    for (int i = 0; i < owners.size(); i++) {
                        if (owners.get(i).name.toLowerCase().equals(name.toLowerCase()) && owners.get(i).password.equals(password)) {
                            index = i;
                            found = true;
                            System.out.println("\n\t\t\t\tWelcome " + owners.get(index).getName() + "\n\t\t\t  ----------------------");
                            owners.get(index).logIn(name, password);
                            ownerManager.menu();
                            break;
                        }
                    }
                    if (!found) {
                        System.out.println("Invalid credentials. Please try again.");
                    }
                }
            }
        else if (anserLogReges == 2) {
                ownerManager.Register();
                System.out.println("\t\t\t\tWelcome " + name + "\n\t\t\t  ----------------------");
                ownerManager.menu();
            } else {
                System.out.println("Invalid choice!");
            }
        } catch (Exception e) {
            System.out.print("An error occurred: " + e.getMessage());
        }
    }
}
