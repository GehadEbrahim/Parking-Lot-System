import java.time.*;
public class Slot {

    private int SlotID;
    private int SpotID;
    private LocalDate Date;
    private LocalTime StartTime;
    private LocalTime EndTime;
    private boolean isReserved; // Is it reserved or not


    //constructor
    public Slot(int SlotID , int SpotID , LocalDate date , LocalTime startTime , LocalTime endTime , boolean isReserved){
        this.SlotID = SlotID;
        this.SpotID = SpotID;
        this.Date = date;
        this.StartTime = startTime;
        this.EndTime =endTime;
        isReserved = false; //It has not reserved yet
    }

    //Getter & Setter
    public int getSlotID(){
        return getSlotID();
    }
    public void setSlotID(int SlotID){
        this.SlotID = SlotID;
    }
   public int getSpotID(){
        return SpotID;
   }
   public void setSpotID(){
        this.SpotID = SpotID;
   }
   public LocalDate getDate(){
        return Date;
   }
   public void setDate(LocalDate Date){
        this.Date = Date;
   }
   public LocalTime getStartTime(){
        return StartTime;
   }
   public void setStartTime(LocalTime startTime){
        this.StartTime = startTime;
   }
   public LocalTime getEndTime(){
        return EndTime;
   }
   public void setEndTime(LocalTime endTime){
        this.EndTime = endTime;
   }
    public boolean isReserved() {
        return isReserved;
    }

    public void reserve() {
        this.isReserved = true;
    }


   //Other Methods

    @Override
    public String toString() {
        return "Slot ID: " + SlotID + ", Spot ID: " + SpotID + ", Date: " + Date + ", Time: " + StartTime + " - " + EndTime;
    }

}
