import java.util.*;

public class Owner extends User{
    private int ID;
    private int phone;
    private String email;

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public int getID() {
        return ID;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    public Scanner getIn() {
        return in;
    }

    public void setIn(Scanner in) {
        this.in = in;
    }

    public int getPhone() {
        return phone;
    }

    public void setPhone(int phone) {
        this.phone = phone;
    }

    public ArrayList<Reservation> getReservationArray() {
        return reservationArray;
    }

    public void setReservationArray(ArrayList<Reservation> reservationArray) {
        this.reservationArray = reservationArray;
    }

    //private float wallet;
    private ArrayList<Reservation> reservationArray = new ArrayList<>(); // Dynamic array for reservations

    Scanner in = new Scanner(System.in);

    public Owner(int id, String email, String name, String password , int phone) {
        super(name, password);
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
    @Override
    public int logIn(String name, String password) {
        int counter = 0;
        boolean isValid = false;
        while (counter == 3) {
            int noOfTries = 3;
            System.out.println("Enter your name: ");
            name = in.nextLine();
            System.out.println("Enter Your Password: ");
            password = in.next();
            for (Owner owner : Main.owners) {
                if (name.equalsIgnoreCase(owner.name) && password.equals(owner.password)) {
                    isValid = true;
                    Main.index = owner.ID;
                    System.out.println("\t\t\t\tWelcome back");
                    break;
                }
            }
            if (!isValid) {
                while (counter < 3) {
                    if (isValid) {
                        System.out.println("Welcome back");
                        break;
                    } else {
                        System.out.println("Incorrect Password or Username. You have " + (2 - counter) + " attempts left.");
                        counter++;
                    }
                }
                if (counter == 3) {
                    System.out.println("Too many incorrect attempts. Access denied.");
                }
            }
        }
        return Main.index;
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
                //logOut();
                break;
            case 7 :
                System.out.println("Delete my account feature");
                break;
            default :
                System.out.println("Invalid choice. Please try again.");
        }
    }
}