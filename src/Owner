import java.util.*;

public class Owner {
    private String name;
    private String password;
    private int ID;
    private int phone;
    //private float wallet;
    private String email;
    private ArrayList<Reservation> reservationArray = new ArrayList<>(); // Dynamic array for reservations

    Scanner in = new Scanner(System.in);

    public Owner(int id, String email, String name, String password , int phone) {
        //super(name, password);
        this.name = name;
        this.password = password;
        this.ID = id;
        this.email = email;
        this.phone = phone;
    }
    @Override
    public String toString() {
        return "Name: " +name +"\n" +
                "   Password: " + password +"\n" +
                "   ID: " + ID + "\n" +
                "   Phone number: " + phone + "\n" +
                "   Email: " + email;
    }

    // Login method
    public int logIn(String name, String password) {
        while (true) {
            System.out.print("Enter your name: ");
            name = in.next();
            System.out.print("Enter your password: ");
            password = in.next();

            if (this.name.equals(name) && this.password.equals(password)) {
                return 1; // Login successful
            } else {
                System.out.println("Incorrect username or password! Try again, please.");
            }
        }
    }

    // Logout method
    public void logOut() {
        System.out.println("You have been logged out.");
    }

    // Display menu
    public int menu() {
        System.out.println("1) Show my account");
        System.out.println("2) Make a reservation");
        System.out.println("3) Cancel a reservation");
        System.out.println("4) Update a reservation");
        System.out.println("5) Rewards");
        System.out.println("6) Log out");
        System.out.println("7) Delete my account");
        System.out.println("\n");
        System.out.print("Enter your choice: ");

        while (!in.hasNextInt()) {
            System.out.println("Invalid input. Please enter a number:");
            in.next();
        }
        return in.nextInt();
    }

    // Display account details
    public void displayDetails() {
        System.out.println("Name: " + this.name);
        System.out.println("Password: " + this.password);
        System.out.println("Email: " + this.email);
        System.out.println("ID: " + this.ID);
    }

    // Make a reservation
    public void makeReservation(Spot spot, int choice) {
        System.out.println("Reservation made for Spot ID: " + spot.getId());
        // Add logic for adding a reservation to the reservationArray
    }

    // Handle user choice
    public void selectedChoice(int choice) {
        switch (choice) {
            case 1 :
                displayDetails();
            case 2 :
                System.out.println("Make a reservation feature");
                break;
            case 3 :
                System.out.println("Cancel a reservation feature");
                break;
                case 4 :
                System.out.println("Update a reservation feature");
                break;
            case 5 :
                System.out.println("Rewards feature");
                break;
            case 6 :
                logOut();
                break;
            case 7 :
                System.out.println("Delete my account feature");
                break;
            default :
                System.out.println("Invalid choice. Please try again.");
        }
    }
}

