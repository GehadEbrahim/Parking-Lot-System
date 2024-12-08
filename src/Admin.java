import java.util.ArrayList;

public class Admin extends User
{
    private String Email;
    private double total_earning;
    private ArrayList<Owner> ownerList; // ArrayList for Owners
    private ArrayList <Spot> spotList;   // ArrayList for Spots


    public Admin(String name, String password) {
        super(name, password);
    }

    public Admin() {
        super("admin", "admin");
        this.Email = "admin@example.com";
        this.total_earning = total_earning;
    }

    public String getEmail() {
        return Email;
    }

    public double getTotal_earning() {
        return total_earning;
    }

    @Override
    public int logIn(String name, String password) {
        return 0;
    }
    public void display_data() {
        System.out.println("---->> Owner Data");
        for (Owner owner : ownerList) {
            System.out.print(owner.toString()); // Use the owner instance to call getDetails()
            System.out.println("---->> Spot Data");
            for (Spot spot : spotList) {
                System.out.println(spot.toString());
                System.out.println("---->> Slot Data");
                ArrayList<Slot> slots = spot.getSlots();
                for (int i = 0; i < spot.getSlotCount(); i++) {
                    System.out.println(slots.get(i).toString());
                }
            }
        }
    }
}
