import java.util.ArrayList;

public class Spot {
    private String Type;   // Type of spot (Normal, Bike, Large)
    private int Spot_ID;
    private ArrayList<Slot> slots;  // ArrayList to hold Slot objects
    private int slotCount; // how many slots are assigned
    private double fees;

    // Constructor
    public Spot() {
        slots = new ArrayList<>();
    }

    public Spot(String Type, int Spot_ID, double fees) {
        this.Type = Type;
        this.Spot_ID = Spot_ID;
        this.fees = fees;
        slots = new ArrayList<>();
        this.slotCount = 0; // Start with 0 slots
    }

    // Add Slot to the Spot
    public boolean assignSlot(Slot slot) {
        if (slotCount < 3) {  //Assume each spot has a max of 3 slots for example
            slots.add(slot);
            slotCount++;
            return true;
        }
        return false; // no space for more slots
    }

    public String getDetails() {
        return "Spot ID: " + Spot_ID + ", Type: " + Type + ", Slots Assigned: " + slotCount;
    }

    // Getters and setters
    public String getType() {
        return Type;
    }

    public void setType(String type) {
        this.Type = type;
    }

    public void setFees(double fees) {
        this.fees = fees;
    }

    public int getId() {
        return Spot_ID;
    }

    public void setId(int spot_ID) {
        this.Spot_ID = spot_ID;
    }

    @Override
    public String toString() {
        return "Spot ID: " + getId() + ", Type: " + getType() + ", Price: " + fees;
    }

    // Method to check if the spot is full "Chat GPT " لسه مش سألته بتعمل اي كنت بحل مشكلة الاول
    public boolean isFull() {
        return slotCount == slots.size();
    }

    public double getFees() {
        return fees;
    }
}
