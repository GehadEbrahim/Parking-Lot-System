import java.io.*;
import java.time.LocalDate;
import java.util.*;

public class ReservationManager {
    OwnerManager ownerManager = new OwnerManager();
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
                if (line.trim().isEmpty() || line.trim().startsWith("/")) {
                    continue; // Skip empty lines or comments
                }
                String[] parts = line.split(",");
                try {
                    ArrayList<Integer> slotIds = new ArrayList<>();
                    int i = 2;
                    while (i < parts.length - 2) { // Assume last 2 fields are type and licenseNumber
                        slotIds.add(Integer.parseInt(parts[i].trim()));
                        i++;
                    }
                    Reservation reservation = new Reservation(parts[0].trim(), Integer.parseInt(parts[1].trim()), slotIds,parts[parts.length - 2].trim(),parts[parts.length - 1].trim() );
                    reservation.setSlotIDs(slotIds);

                    reservations.add(reservation);
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

    public void reservationMenu() throws IOException {
        String ans = "y";
        while (ans.equalsIgnoreCase("y")) {  // Use equalsIgnoreCase to handle lower/uppercase input
            System.out.println("1) View my reservations");
            System.out.println("2) Make reservation");
            System.out.println("3) Update reservation");
            System.out.println("4) Edit a reservation");
            System.out.println("5) Cancel reservation");
            System.out.print("==>");

            int reservationMenuChoice = in.nextInt();

            switch (reservationMenuChoice) {
                case 1:
                    displayReservations();
                    break;
                case 2:
                    System.out.println("For which vehicle you want to make a reservation?");
                    Main.vehicle.displayOwnerVehicles(Main.index);
//                    System.out.println("For which vehicle you want to make a reservation?");
//                    for (int i = 0; i < Main.vehicles.size(); i++) {
//                        System.out.println((i + 1) + ") " + Main.vehicles.get(i).vehicleDetails());
//                    }
                    System.out.print(" ==> ");
                    int vehicleChoice = in.nextInt();
                    String vehicleType = Main.vehicles.get(vehicleChoice).getType();
                    String licenceNumber = Main.vehicles.get(vehicleChoice).getLicence_number();
                    if (vehicleChoice < 1 || vehicleChoice > Main.vehicles.size()) {
                        System.out.println("Invalid choice. Please try again.");
                        return;
                    }
                    System.out.print("Which spot you want to reserve?\n==>");
                    Main.spotManager.displayAvailableSpots(Main.spots, vehicleType.toUpperCase());
                    int spotChoice = in.nextInt();

                    Main.slotManager.displayAvailableSlots(Main.slots, spotChoice);
                    System.out.println("Enter the slot IDs you want to reserve (comma-separated):");
                    String slotInput = in.next();
                    String[] slotStrings = slotInput.split(",");
                    List<Integer> slotIDs = new ArrayList<>();
                    for (String s : slotStrings) {
                        slotIDs.add(Integer.parseInt(s.trim()));
                    }

                    makeReservation(Main.name, spotChoice, slotIDs, vehicleType, licenceNumber);
                    break;
                case 3:
                    // Implement the update reservation functionality
                    break;
                case 4:
                    // Implement the edit reservation functionality
                    break;
                case 5:
                    // Implement the cancel reservation functionality
                    break;
                default:
                    System.out.println("Invalid choice. Please try again.");
                    break;
            }
            System.out.println("Back to the reservation menu? (Y / N)");
            System.out.print(" ==> ");
            ans = in.next();
        }
        System.out.println("Returning to the main menu...");
    }

    public void makeReservation(String name, int spotID, List<Integer> slotIDs, String vehicleType, String licenceNumber) {
        LocalDate today = LocalDate.of(2024, 10, 30); // Assume today's date is 30-11-2024
        Reservation reservation = new Reservation(Main.name, spotID, slotIDs ,vehicleType, licenceNumber);

        for (int slotID : slotIDs) {
            Slot slot = Main.slotManager.getSlotById(Main.slots, slotID);

            if (slot != null) {
                LocalDate slotDate = slot.getDate();
                if (slotDate.isEqual(today) || slotDate.isBefore(today.minusDays(2))) {
                    System.out.println("Cannot reserve slot " + slotID + " as it is either today or too soon. Please choose a date 3 or more days before or after today.");
                    return;
                }
                reservation.addSlotID(slotID);
            } else {
                System.out.println("Slot with ID " + slotID + " not found.");
            }
        }

        reservations.add(reservation);
        System.out.println("Reservation Done!");
    }

    public void displayReservations() {
        if (reservations.isEmpty()) {
            System.out.println("No reservations found.");
        } else {
            for (Reservation reservation : reservations) {
                System.out.println(reservation.reservationDetails());
            }
        }
    }
}
