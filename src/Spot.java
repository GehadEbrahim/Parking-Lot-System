import java.util.ArrayList;

public class Spot {
    private String Type;   // Type of spot (Normal, Bike, Large)
    private int Spot_ID;
    private ArrayList<Slot> slots;
    // Array to hold 3 Slots objects
    private static int slotCount; // how many slots are assigned
    private double fees;
    private boolean isSpotReserved;

    // Default Constructor
    public Spot() {
        slots = new ArrayList<>(3);
        slotCount = 0;
    }

    // Parameterized Constructor
    public Spot(String Type, int Spot_ID, double fees) {
        this.Type = Type;
        this.Spot_ID = Spot_ID;
        this.fees = fees;
        slots = new ArrayList<>(3);
        slotCount = 0;
        this.isSpotReserved = false; // Default to not reserved
    }

    public Spot(int spot_ID,  String type,  double fees, boolean isSpotReserved){
        this.fees = fees;
        this.isSpotReserved = isSpotReserved;
        Spot_ID = spot_ID;
        Type = type;
    }

    // Add Slot to the Spot
    public boolean assignSlot(Slot slot) {
        for (int i = 0; i < slots.size(); i++) {
            if (slots.get(i) == null) { //Searching if there is a place to add slot or not
                slots.add(slot); //if there is => add the slot
                return true;
            }
        }
        return false; // there is no available space to add another slot
    }

    // Getters and setters
    public String getType() {
        return Type;
    }

    public void setType(String type) {
        this.Type = type;
    }

    public double getFees() {
//        if(Main.owners.get(Main.index).getVehicle().toLowerCase().equals("normal")) {
//            return "function calculat"
//        }
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
        return slotCount == 3; //if slotCount == 3 => return true
    }

    public String SpotDetails(){
        return "Spot ID: " + getId() + "\n" +
                "Type: " + getType() + "\n" +
                "Price: " + fees + "\n";
    }
    public String AllSpotDetails(){
        return "Spot ID: " + getId() + "\n" +
                "Type: " + getType() + "\n" +
                "Price: " + fees + "\n"+
                "Reserved: " + isSpotReserved + "\n";
    }
    @Override
    public String toString() { //Owner
        return getId() + "," + getType() + "," + fees + "," + isSpotReserved;
    }
}