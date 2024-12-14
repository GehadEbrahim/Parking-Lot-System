import java.util.*;

//Attributes
public class Owner extends User{
    private int ID;
    private int phone;
    private String email;
    private ArrayList<Reservation> reservationArray = new ArrayList<>(); // Dynamic array for reservations
    //private float wallet;

    Scanner in = new Scanner(System.in);
    //Constructor
    public Owner(int id, String email, String name, String password , int phone) {
        super(name, password);
        this.ID = id;
        this.email = email;
        this.phone = phone;
    }

    //Getter

    public String getEmail() {
        return email;
    }

    public int getID() {
        return ID;
    }

    public Scanner getIn() {
        return in;
    }
    public int getPhone() {
        return phone;
    }

    public ArrayList<Reservation> getReservationArray() {
        return reservationArray;
    }

    //Setter

    public void setID(int ID) {
        this.ID = ID;
    }

    public void setIn(Scanner in) {
        this.in = in;
    }

    public void setPhone(int phone) {
        this.phone = phone;
    }

    public void setReservationArray(ArrayList<Reservation> reservationArray) {
        this.reservationArray = reservationArray;
    }
    public void setEmail(String email) {
        this.email = email;
    }

    public String getOwnerDetails(){
      return
                "Name: " +name +"\n" +
                "Password: " + password +"\n" +
                "ID: " + ID + "\n" +
                "Phone number: " + phone + "\n" +
                "Email: " + email + "\n";
    }
//Methods

    @Override
    public String toString() {
        return ID+","+name+","+password+","+phone+","+email;
    }

    // Login method
    @Override
    public int logIn(String name, String password) {
        int counter = 0;
        boolean isValid = false;
        while (counter == 3) {
            int noOfTries = 3;
            System.out.print("Enter your name: ");
            name = in.nextLine(); //read till "\n"
            System.out.print("Enter Your Password: ");
            password = in.next(); //read till the white space
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
}