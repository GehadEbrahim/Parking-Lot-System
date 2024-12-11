
import java.util.ArrayList;

public class Reservation {
    // Attributes of The Reservation Class
    Spot spot;
    private Owner owner =new Owner(Main.owners.get(Main.index).getID() , Main.owners.get(Main.index).getEmail() ,Main.owners.get(Main.index).name ,Main.owners.get(Main.index).password ,Main.owners.get(Main.index).getPhone());
    private ArrayList<Integer> slotIDs;
    static int numOfReservation = 0;

    // Constructor
    public Reservation(String ownerName, int spotID) {
        owner.name = ownerName;
        this.spot = new Spot();
        this.spot.setId(spotID);
        this.slotIDs = new ArrayList<>();
        numOfReservation++;
    }

    // Setter and Getter for Owner Name
    public void setOwnerName(String ownerName) {
        owner.name = ownerName;
    }

    public String getOwnerName() {
        return owner.name;
    }

    // Setter and Getter for Spot ID
    public void setSpotID(int spotID) {
        this.spot.setId(spotID);
    }

    public int getSpotID() {
        return spot.getSpotID();
    }

    // Add a Slot ID
    public void addSlotID(int slotID) {
        slotIDs.add(slotID);
    }

    // Get all Slot IDs
    public ArrayList<Integer> getSlotIDs() {
        return slotIDs;
    }

    // toString method to display reservation details
    @Override
    public String toString() {
        return "Owner Name: " + owner.name +
                "\nSpot ID: " + spot.getId() +
                "\nSlot IDs: " + slotIDs;
    }
}