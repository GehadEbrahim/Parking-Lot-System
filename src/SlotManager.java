import java.io.*;
import java.time.*;
import java.util.*;

public class SlotManager {
    public List<Slot> loadSlots(String filePath) throws IOException {
        List<Slot> slots = new ArrayList<>();
        try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {
            String line;
            while ((line = br.readLine()) != null) {
                if (line.trim().startsWith("/") || line.trim().isEmpty()) continue;

                String[] parts = line.split(",");
                int slotId = Integer.parseInt(parts[0].trim());
                int spotId = Integer.parseInt(parts[1].trim());
                LocalDate date = LocalDate.parse(parts[2].trim());
                LocalTime startTime = LocalTime.parse(parts[3].trim());
                LocalTime endTime = LocalTime.parse(parts[4].trim());
                boolean isReserved = Boolean.parseBoolean(parts[5].trim());

                slots.add(new Slot(slotId, spotId, date, startTime, endTime, isReserved));
            }
        }
        return slots;
    }

    public void displaySlots(List<Slot> slots) {
        for (int i = 0 , num = 1; i < slots.size(); i++ , num++) {
            if(num == 4){
                num = 1;
            System.out.println(num + ") " + slots.get(i).toStringAll() );
            }
        }
    }

    public void displayAvailableSlots(List<Slot> slots, int spotId) {
        System.out.println("Available Slots for Spot ID " + spotId + ":");
        for (Slot slot : slots) {
            if (slot.getSpotId() == spotId && !slot.isReserved()) {
                System.out.println(slot.toString());
            }
        }
    }

    public Slot getSlotById(List<Slot> slots, int slotId) {
        for (Slot slot : slots) {
            if (slot.getSlotId() == slotId) {
                slot.setReserved(true);
                return slot;
            }
        }
        return null;
    }
}




