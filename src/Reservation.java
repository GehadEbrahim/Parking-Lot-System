//Start Reservation class
//I'll edit it, it's not the final virsion
import java.io.*;
public class Reservation {

    //Attributes of The Reservation Class
    private int ownerID;
    private int spotID;
    private Spot spots[];
    static int numOfReservation = 0;

    //Constructor
    public Reservation(int ownerID , int spotID) {
        this.ownerID = ownerID;
        this.spotID = spotID;
        numOfReservation++;
    }
    //# Methods of The Reservation Class

    //## Setter methods of The Reservation Class
    public int getOwnerID(){
        return ownerID;
    }
    public int getSpotID(){
        return spotID;
    }

    public void displaySpots(){
                String filePath = "C:/Users/gebra//OneDrive/Desktop/PLS/Spots.txt";

                try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {
                    String line;
                    System.out.println("SpotID\tType\tFees");
                    System.out.println("**********************");

                    while ((line = br.readLine()) != null) {
                        if (line.trim().isEmpty() || line.contains("****")) {
                            continue;
                        }
                        String[] data = line.split(",");
                        if (data.length == 3) {
                            System.out.printf("%s\t%s\t%s%n", data[0].trim(), data[1].trim(), data[2].trim());
                        } else {
                            System.out.println(line.trim());
                        }
                    }
                } catch (IOException e) {
                    System.out.println("Error reading the file: " + e.getMessage());
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
}

