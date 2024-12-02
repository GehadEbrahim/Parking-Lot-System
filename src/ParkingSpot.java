// Start ParkingSpot class
public class Spot {
  //Attributes
    private String Type;   // Type of spot (Normal Bike Large)
    private int Spot_ID;
    private Slot[] slots;  // Array to hold Slot objects
    private int slotCount; // how many slots are assigned

    // Constructor
    public Spot(String Type, int Spot_ID, int maxSlots) {
        this.Type = Type;
        this.Spot_ID = Spot_ID;
        this.slots = new Slot[maxSlots]; // Initialize the slots array
        this.slotCount = 0; // Start with 0 slots
    }


    public boolean assignSlot(Slot slot) {
        if (slotCount < slots.length) {
            slots[slotCount] = slot;
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
        this.Type = Type;
    }

    public int getId() {
        return Spot_ID;
    }

    public void setId(int Spot_ID) {
        this.Spot_ID=Spot_ID;
    }
