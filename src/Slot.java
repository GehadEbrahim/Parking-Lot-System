import java.time.*;

public class Slot {
    private int slotId;
    private int spotId;
    private LocalDate date;
    private LocalTime startTime;
    private LocalTime endTime;
    private boolean isReserved;

    // Constructor
    public Slot(int slotId, int spotId, LocalDate date, LocalTime startTime, LocalTime endTime, boolean isReserved) {
        this.slotId = slotId;
        this.spotId = spotId;
        this.date = date;
        this.startTime = startTime;
        this.endTime = endTime;
        this.isReserved = isReserved;
    }

    // Default constructor (optional, if needed)
    public Slot() {
        this.slotId = 0;
        this.spotId = 0;
        this.date = LocalDate.now();
        this.startTime = LocalTime.now();
        this.endTime = LocalTime.now();
        this.isReserved = false;
    }

    // Getters
    public int getSlotId() {
        return slotId;
    }

    public int getSpotID() {
        return spotId;
    }

    public LocalDate getDate() {
        return date;
    }

    public LocalTime getStartTime() {
        return startTime;
    }

    public LocalTime getEndTime() {
        return endTime;
    }

    public boolean isReserved() {
        return isReserved;
    }

    // Setters
    public void setSlotId(int slotId) {
        this.slotId = slotId;
    }

    public void setSpotID(int spotId) {
        this.spotId = spotId;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public void setStartTime(LocalTime startTime) {
        this.startTime = startTime;
    }

    public void setEndTime(LocalTime endTime) {
        this.endTime = endTime;
    }

    public void setReserved(boolean isReserved) {
        this.isReserved = isReserved;
    }

    // Override toString()
    @Override
    public String toString() {
        return "Slot Details:\n" +
                "Slot ID: " + slotId + "\n" +
                "Spot ID: " + spotId + "\n" +
                "Date: " + date + "\n" +
                "Start Time: " + startTime + "\n" +
                "End Time: " + endTime + "\n" +
                "Reserved: " + isReserved + "\n";
    }


    public void setSlotID(int slotID) {
        this.slotId = slotID;
    }
}
