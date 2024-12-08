public class Reservation {

    //Attributes of The Reservation Class
    private int ownerID;
    private int spotID;
    //private ArrayList<Spot> spots;
    private String slotID;
    static int numOfReservation = 0;

    //Constructor
    public Reservation(String ownerName, int spotId, int slotId){
        numOfReservation++;
    }
    public Reservation(int ownerID , int spotID , String slotID) {
        this.ownerID = ownerID;
        this.spotID = spotID;
        numOfReservation++;
    }

    public void setOwnerID(int ownerID) {
        this.ownerID = ownerID;
    }

    public void setSpotID(int spotID) {
        this.spotID = spotID;
    }
//# Methods of The Reservation Class

    //## Setter methods of The Reservation Class
    public int getOwnerID(){
        return ownerID;
    }
    public int getSpotID(){
        return spotID;
    }

    //## to string method => we use it to display data from the document
    @Override
    public String toString() {
        return "Owner ID :" + ownerID +"\n   Spot ID : " + spotID  +"\n " ;
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
}
