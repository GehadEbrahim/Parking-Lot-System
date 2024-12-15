import java.util.*;

public class Reservation {
//            Attributes
        Spot spot  = new Spot();
        private String ownerName;
        private List<Integer> slotIDs;
        private static int numOfReservation = 0;
        private String vehicleType;
        private String licenseNumber;

        // Constructor now accepts owner as a parameter
        public Reservation(String ownerName, int spotID, List<Integer> slotIDs, String vehicleType, String licenseNumber) {
//            this.owner = owner;
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
        for(int slotId : slotIDs){
            spot.getSlots().get(slotId).setReserved(true);
        }
    }

    public String reservationDetails(){
        return "Owner name: " + ownerName +
                "\nSpot ID: " + spot.getId()+
                "\nSlot IDs: " + slotsToString() +
                "\nVehicle type: "+ vehicleType+
                "\nLicense number: "+ licenseNumber;
    }

    // toString method to convert all date to String

    public String slotsToString(){
        StringBuilder slotIDsStringBuilder = new StringBuilder(); // StringBuilder => to collect texts

        for (int i = 0; i < slotIDs.size(); i++) {
            slotIDsStringBuilder.append(slotIDs.get(i)); //  String =>to add item as a String
            if (i < slotIDs.size() - 1) {
                // append(",") => add "," between each 2 elements --> that's mean add comma after each element except the last element
                slotIDsStringBuilder.append(",");
            }
        }

        return slotIDsStringBuilder.toString(); // Conver "slotIDsStringBuilder" to a String
    }
    @Override
    public String toString() {
        return ownerName +","+spot.getId()+","+this.slotsToString()+","+vehicleType+"," + licenseNumber;
    }
}