import java.util.*;

public class Reservation {
    // Attributes of The Reservation Class
    Spot spot  = new Spot();
    private Owner owner =new Owner(Main.owners.get(Main.index).getID() ,
            Main.owners.get(Main.index).getEmail() ,
            Main.owners.get(Main.index).name ,
            Main.owners.get(Main.index).password ,
            Main.owners.get(Main.index).getPhone());
    private String ownerName ;
    private List<Integer> slotIDs;
    private static int numOfReservation = 0;
    private String vehicleType;
    private String licenseNumber;


    public static int getNumOfReservation() {
        return numOfReservation;
    }

    // Constructor
    public Reservation(String ownerName , int spotID, List<Integer> slotIDs, String vehicleType, String licenseNumber) {
        this.ownerName = ownerName;
        this.spot.setId(spotID);
        this.vehicleType = vehicleType;
        this.licenseNumber = licenseNumber;
        this.slotIDs = slotIDs;
        numOfReservation++;
    }

                 // Getters
    public String getOwnerName() {
        return ownerName;
    }

    public int getSpotID() {
        return spot.getSpotID();
    }

    public String getVehicleType() {
        return vehicleType;
    }

    // Get all Slot IDs
    public List<Integer> getSlotIDs() {
        return slotIDs;
    }

    public String getLicenseNumber() {
        return licenseNumber;
    }

                 // Setters //I'll need it in the edit reservation method
    public void setSpotID(int spotID) {
        this.spot.setId(spotID);
    }

    public void setOwnerName(String ownerName) {
        owner.name = ownerName;
    }

    public void setLicenseNumber(String licenseNumber) {
        this.licenseNumber = licenseNumber;
    }

    public void setVehicleType(String vehicleType) {
        this.vehicleType = vehicleType;
    }

    // Add a Slot ID
    public void addSlotID(int slotID) {
        slotIDs.add(slotID);
    }

    public void setSlotIDs(ArrayList<Integer> slotIDs) {
        this.slotIDs = slotIDs;
    }

    public String reservationDetails(){
        return "Owner name: " + ownerName +
                "\nSpot ID: " + spot.getId()+
                "\nSlot IDs: " + slotIDs.toString() +
                "\nVehicle type: "+ vehicleType+
                "\nLicense number: "+ licenseNumber;
    }

    // toString method to convert all date to String
    @Override
    public String toString() {
        return owner.name +","+spot.getId()+","+slotIDs.toString()+","+vehicleType+"," + licenseNumber;
    }
}