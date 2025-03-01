import java.io.*;
import java.util.*;

public class ReservationManager {
    private Scanner in = new Scanner(System.in);
    private List<Reservation> reservations = new ArrayList<>();

    // Load reservations from file
    public List<Reservation> loadReservations(String filePath) throws IOException {
        if (!reservations.isEmpty()) {
            return reservations; // Avoid reloading if already loaded
        }

        try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {
            String line;
            while ((line = br.readLine()) != null) {
                if (line.trim().isEmpty() || line.trim().startsWith("#")) {
                    continue;
                }

                String[] parts = line.split(",");
                try {
                    String ownerName = parts[0].trim();
                    int spotId = Integer.parseInt(parts[1].trim());
                    int slotId = Integer.parseInt(parts[2].trim());
                    reservations.add(new Reservation(ownerName, spotId));
                } catch (NumberFormatException e) {
                    System.out.println("Error parsing line: " + line);
                }
            }
        } catch (IOException e) {
            System.out.println("Error reading the file: " + filePath);
            throw e;
        }
        return reservations;
    }


    public void reservation() throws IOException {
        System.out.println("1) View my reservations");
        System.out.println("2) Make reservation");
        System.out.println("3) Update reservation");
        System.out.println("4) Cancel reservation\n==>");
        int reservationMenuChoice = in.nextInt();

        switch (reservationMenuChoice) {
            case 1:
                displayReservations();
                break;
            case 2:
                // Step 1: Select Spot
                spotManager spot = new spotManager();
                List<Spot> spots = spot.loadSpots(FilePaths.SPOTS_FILE_PATH);
                spot.displayAvailableSpots(spots);
                System.out.print("Which spot you want to reserve?\n==>");
                int spotChoice = in.nextInt();

                // Step 2: Select Slots
                slotManager slot = new slotManager();
                List<Slot> slots = slot.loadSlots(FilePaths.SLOTS_FILE_PATH);
                slot.displayAvailableSlots(slots, spotChoice);

                System.out.println("Enter the slot IDs you want to reserve (comma-separated):");
                String slotInput = in.next(); // مثال: "1,2,3"
                String[] slotStrings = slotInput.split(",");
                List<Integer> slotIDs = new ArrayList<>();
                for (String s : slotStrings) {
                    slotIDs.add(Integer.parseInt(s.trim()));
                }

                // Step 3: Make Reservation
                makeReservation("Ali", spotChoice, slotIDs); // Replace "Ali" with actual user input if needed
                System.out.println("Reservation Done!");
                break;
        }
    }


    public void makeReservation(String ownerName, int spotID, List<Integer> slotIDs) {
        Reservation reservation = new Reservation(ownerName, spotID);
        for (int slotID : slotIDs) {
            reservation.addSlotID(slotID); // Add each slotID to the reservation
        }
        reservations.add(reservation);
    }


    public void displayReservations() {
        if (reservations.isEmpty()) {
            System.out.println("No reservations found.");
        } else {
            for (Reservation reservation : reservations) {
                System.out.println(reservation);
            }
        }
    }
}
    // Save reservations to file


    /*private void saveReservations(String filePath) throws IOException {
    try (BufferedWriter bw = new BufferedWriter(new FileWriter(filePath))) {
        for (Reservation reservation : reservations) {
            bw.write(reservation.getOwnerName() + "," + reservation.getSpotID() + "," +
                    String.join(",", reservation.getSlotIDs().stream()
                            .map(String::valueOf)
                            .toArray(String[]::new)));
            bw.newLine();
        }
    }
}*/
