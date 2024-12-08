import java.util.ArrayList;

public class Spot {
    private String Type;   // Type of spot (Normal, Bike, Large)
    private int Spot_ID;
    private ArrayList<Slot> slots;  // ArrayList to hold Slot objects
    private int slotCount; // how many slots are assigned
    private double fees;
    private boolean isSpotReserved;

    // Default Constructor
    public Spot() {
        slots = new ArrayList<Slot>();
        this.slotCount = 0;
    }

    // Parameterized Constructor
    public Spot(String Type, int Spot_ID, double fees) {
        this.Type = Type;
        this.Spot_ID = Spot_ID;
        this.fees = fees;
        this.slots = new ArrayList<Slot>();
        this.slotCount = 0;
        this.isSpotReserved = false; // Default to not reserved
    }

    // Add Slot to the Spot
    public boolean assignSlot(Slot slot) {
        if (slotCount < 3) {  // Assume each spot has a max of 3 slots
            slots.add(slot);
            slotCount++;
            return true;
        }
        return false; // No space for more slots
    }

    // Getters and setters
    public String getType() {
        return Type;
    }

    public void setType(String type) {
        this.Type = type;
    }

    public double getFees() {
        return fees;
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

    public int getSlotCount() {
        return slotCount;
    }

    public int getSpotID() {
        return Spot_ID;
    }

    public ArrayList<Slot> getSlots() {
        return slots;
    }

    public boolean isSpotReserved() {
        return isSpotReserved;
    }

    public void setSpotReserved(boolean spotReserved) {
        isSpotReserved = spotReserved;
    }

    // Check if the spot is full
    public boolean isFull() {
        return slotCount == 3;
    }

    @Override
    public String toString() {
        return "Spot ID: " + getId() + "\n" +
                "Type: " + getType() + "\n" +
                "Price: " + fees + "\n" +
                "Reserved: " + isSpotReserved + "\n";
    }
}
