import java.util.ArrayList;

public class Reservation {
    // Attributes of The Reservation Class
    private String ownerName;
    private int spotID;
    private ArrayList<Integer> slotIDs; // لتخزين أكثر من Slot
    static int numOfReservation = 0;

    // Constructor
    public Reservation(String ownerName, int spotID) {
        this.ownerName = ownerName;
        this.spotID = spotID;
        this.slotIDs = new ArrayList<>(); // تهيئة القائمة
        numOfReservation++;
    }

    // Setter and Getter for Owner Name
    public void setOwnerName(String ownerName) {
        this.ownerName = ownerName;
    }

    public String getOwnerName() {
        return ownerName;
    }

    // Setter and Getter for Spot ID
    public void setSpotID(int spotID) {
        this.spotID = spotID;
    }

    public int getSpotID() {
        return spotID;
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
        return "Owner Name: " + ownerName +
                "\nSpot ID: " + spotID +
                "\nSlot IDs: " + slotIDs.toString();
    }
}
//Other Methods +calculateFees() : double
  /*  public double calculateFees(int indexOfSpot ,Slot slots[]) { //I'll pass the indexOfSpot and the hours of the reservation to be able to calculate fees
        //هيختار هو عايز كام slot و انا هحسب الوقت الكلي و ابعته كـ parameter للـ function عشان تحسب الـ fees
        int hours = 5;
        setFees(0);
        if(spotID >=1 && spotID <= 10){
            setFees(20 * hours);
        }
        else if(spotID >=11 && spotID <= 20){
            setFees(10 * hours);
        }
       else{
            setFees(30 * hours);
        }
       return getFees();
    }

    public double getFees() {
        return fees;
    }*/
    //Other Methods

