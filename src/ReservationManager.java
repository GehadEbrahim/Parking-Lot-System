
import java.io.*;
import java.time.LocalDate;
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
        String ans = "y";
        while (ans.equalsIgnoreCase("y")) {  // Use equalsIgnoreCase to handle lower/uppercase input
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
                    // Select Spot
                    System.out.print("Which spot you want to reserve?\n==>");
                    Main.spotManager.displayAvailableSpots(Main.spots , Main.type);
                    int spotChoice = in.nextInt();

                    // Select Slots
                    Main.slotManager.displayAvailableSlots(Main.slots, spotChoice);
                    System.out.println("Enter the slot IDs you want to reserve (comma-separated):");
                    String slotInput = in.next();
                    String[] slotStrings = slotInput.split(",");
                    List<Integer> slotIDs = new ArrayList<>();
                    for (String s : slotStrings) {
                        slotIDs.add(Integer.parseInt(s.trim()));
                    }

                    // Make Reservation
                    makeReservation(Main.name, spotChoice, slotIDs); // Replace "Ali" with actual user input if needed
                    break;
                case 3:
                    // Implement the update reservation functionality
                    break;
                case 4:
                    // Implement the cancel reservation functionality
                    break;
                default:
                    System.out.println("Invalid choice. Please try again.");
                    break;
            }

            // Ask user if he want to go back to the reservation menu
            System.out.println("Back to the reservation menu? (Y / N)");
            System.out.print("==>");
            ans = in.next();
        }
        // If 'N' is pressed, the program will exit from the reservation loop.
        System.out.println("Returning to the main menu...");
    }


    public void makeReservation(String name , int spotID, List<Integer> slotIDs) {
       // LocalDate today = LocalDate.now();  //Get today's date using LocalDate.now()
        LocalDate today = LocalDate.of(2024, 10, 30); //Assume that today's date is 30-11-2024
        // Create a new reservation object with the provided owner name and spot ID
        Reservation reservation = new Reservation(Main.name, spotID);
        // Iterate over the list of slot IDs that the user wants to reserve
        for (int slotID : slotIDs) {
            // Return the Slot object using the provided slotID
            Slot slot = Main.slotManager.getSlotById(Main.slots, slotID);
            // Check if the slot with the provided ID exists
            if (slot != null) {
                LocalDate slotDate = slot.getDate(); // Get the date of the selected slot
                // Check if the slot's date is today or in the past (less than 3 days ago)
                if (slotDate.isEqual(today) || slotDate.isBefore(today.minusDays(2))) {
                    // If the slot's date is today or less than 2 days in the past, print a message and cancel the reservation
                    System.out.println("Cannot reserve slot " + slotID + " as it is either today or too soon. Please choose a date 3 or more days before or after today.");
                    return;
                }
                // If the slot is valid, add the slot ID to the reservation
                reservation.addSlotID(slotID);
            } else {
                // If the slot with the given ID is not found, print a message
                System.out.println("Slot with ID " + slotID + " not found.");}
        }
        // Once all slot IDs are added to the reservation, add the reservation to the list of reservations
        reservations.add(reservation);
        // Print a success message => the reservation was completed
        System.out.println("Reservation Done!");
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
// Save reservations to file


    public void saveReservations(String filePath) throws IOException {
        try (BufferedWriter bw = new BufferedWriter(new FileWriter(filePath))) {
            for (Reservation reservation : Main.reservations) {
                StringBuilder sb = new StringBuilder();
                sb.append(reservation.getOwnerName()).append(",");
                sb.append(reservation.getSpotID()).append(",");

                //add slots IDs
                for (int i = 0; i < reservation.getSlotIDs().size(); i++) {
                    sb.append(reservation.getSlotIDs().get(i));
                    if (i < reservation.getSlotIDs().size() - 1) {
                        sb.append(",");
                    }
                }

                bw.write(sb.toString());
                bw.newLine();
            }
        }
    }

}
