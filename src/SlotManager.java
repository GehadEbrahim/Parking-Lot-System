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
                try {
                    String[] parts = line.split(",");
                    int slotId = Integer.parseInt(parts[0].trim());
                    int spotId = Integer.parseInt(parts[1].trim());
                    LocalDate date = LocalDate.parse(parts[2].trim());
                    LocalTime startTime = LocalTime.parse(parts[3].trim());
                    LocalTime endTime = LocalTime.parse(parts[4].trim());
                    boolean isReserved = Boolean.parseBoolean(parts[5].trim());

                    slots.add(new Slot(slotId, spotId, date, startTime, endTime, isReserved));
                } catch (NumberFormatException e) {
                    System.out.println("In " + filePath + " => Error parsing line: " + line);
                }
            }
        }catch (IOException e) {
            System.out.println("Error reading the file: " + filePath);
            throw e;
        }
        return slots;
    }

    public void displaySlots(List<Slot> slots) {
        for (int i = 0 , num = 1; i < slots.size(); i++ , num++) {
            if(num == 4){
                num = 1; // to just display 1 ,2 ,3
            System.out.println((i+1) + ") " + slots.get(i).allSlotDetails());
            }
        }
    }

    public void displayAvailableSlots(List<Slot> slots, int spotId) {
        System.out.println("Available Slots for Spot ID " + spotId + ":");
        for (Slot slot : slots) {
            if (slot.getSpotId() == spotId && !slot.isReserved()) {
                System.out.println(slot.slotDetails());
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

//    public void saveSlots(String filePath) throws IOException {
//        List<String> updatedLines = new ArrayList<>();
//        boolean slotUpdated = false;
//
//        // قراءة البيانات الحالية من الملف
//        try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {
//            String line;
//            while ((line = br.readLine()) != null) {
//                updatedLines.add(line);
//            }
//        }
//
//        // فتح الملف للكتابة من جديد
//        try (BufferedWriter bw = new BufferedWriter(new FileWriter(filePath))) {
//            for (Slot slot : Main.slots) {
//                String slotData = slot.getSlotId() + "," +
//                        slot.getSpotId() + "," +
//                        slot.getDate() + "," +
//                        slot.getStartTime() + "," +
//                        slot.getEndTime() + "," +
//                        slot.isReserved();
//                // البحث إذا كان هذا الـ Slot موجود مسبقًا
//                boolean found = false;
//                for (String existingLine : updatedLines) {
//                    if (existingLine.contains(String.valueOf(slot.getSlotId()))) {
//                        found = true;
//                        break;
//                    }
//                }
//                // إذا لم يتم العثور على الـ Slot، نضيفه
//                if (!found) {
//                    bw.write(slotData);
//                    bw.newLine();
//                }
//            }
//        }
//    }

}





