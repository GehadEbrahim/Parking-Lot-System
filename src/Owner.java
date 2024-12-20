import java.util.*;

//Attributes
public class Owner extends User{
    private int ID;
    private int phone;
    private String email;
    private ArrayList<Reservation> reservationArray = new ArrayList<>(); // Dynamic array for reservations
    private ArrayList<Vehicle> vehiclesArray = new ArrayList<>();
    //private float wallet;

    // عايزه استخدمهم ف وانا بغير الاسم للمالك لازم اسمه فالسيارة يتغير كمان
//    public ArrayList<Vehicle> getVehiclesArray() {
//        return vehiclesArray;
//    }
//
//    public void setVehicleToOwner(Vehicle vehicle) {
//        vehiclesArray.add(vehicle);
//    }
//
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

    public void setPhone(int phone) {
        this.phone = phone;
    }

    public void setReservationToArray(Reservation reservation) {
        this.reservationArray.add(reservation);
    }
    public void setEmail(String email) {
        this.email = email;
    }

    public String getOwnerDetails(){
      return
                "Name: " +getName() +"\n" +
                "Password: " + getPassword() +"\n" +
                "ID: " +getID() + "\n" +
                "Phone number: " + getPhone() + "\n" +
                "Email: " + getEmail() + "\n";
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
        int maxTries = 3;
        boolean isOwner = false;
        int size =Main.owners.size(); //It loops each time on the owners list to know the size , so that it is saved in a variable
        while (counter < maxTries) {
            counter++;
            for (int i = 0; i < size; i++) {
                if (Main.owners.get(i).name.equalsIgnoreCase(name) && Main.owners.get(i).password.equals(password)) {
                    Main.index = i;
                    System.out.println("Login successful!");
                    isOwner = true;
                    return 1;
                }
            }
            if(!isOwner){
                if((maxTries - counter) != 0)
                System.out.println("Incorrect Username or Password. You have " + (maxTries - counter) + " attempts left.");
                else return -1;
            }
            System.out.print("Enter your name: ");
            name = in.nextLine();
            System.out.print("Enter Your Password: ");
            password = in.nextLine();
        }
        System.out.println("Too many incorrect attempts. Access denied.");
        return -1;
    }


    // Display account details
    public void displayDetails() {
        System.out.println("Name: " + this.name);
        System.out.println("Password: " + this.password);
        System.out.println("Email: " + this.email);
        System.out.println("ID: " + this.ID);
    }
}