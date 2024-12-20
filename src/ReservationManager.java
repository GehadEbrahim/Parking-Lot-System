import java.io.*;
import java.util.*;

public class ReservationManager {
    //OwnerManager ownerManager = new OwnerManager();
    private Scanner in = new Scanner(System.in);
    // Load reservations from file
    private Reservation reservation = new Reservation();
    public List<Reservation> loadReservations(String filePath) throws IOException {
        List<Reservation> reservations = new ArrayList<>();
        try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {
            String line;
            while ((line = br.readLine()) != null) {
                if (line.trim().isEmpty() || line.trim().startsWith("/")) {
                    continue; // Skip empty lines or comments
                }
                String[] parts = line.split(",");
                try {
                    // Check if the line has the correct number of columns
                    if (parts.length < 4) {
                        System.out.println("In " + filePath + " => Error: line does not have enough fields: " + line);
                        continue; // Skip this line if it doesn't have enough columns
                    }

                    ArrayList<Integer> slotIds = new ArrayList<>();
                    int i = 2;
                    while (i < parts.length - 2) { // Assume last 2 fields are type and licenseNumber
                        slotIds.add(Integer.parseInt(parts[i].trim()));
                        i++;
                    }

//                     Create the reservation

                    Reservation reservation = new Reservation(parts[0].trim(), Integer.parseInt(parts[1].trim()), slotIds, parts[parts.length - 2].trim(), parts[parts.length - 1].trim());
                    //reservation.setSlotIDs(slotIds);

                    // Add reservation to the list
                    reservations.add(reservation);
                } catch (NumberFormatException e) {
                    System.out.println("In " + filePath + " => Error parsing line: " + line);
                }
            }
        } catch (IOException e) {
            System.out.println("Error reading the file: " + filePath);
            throw e;
        }
        return reservations;
    }


    public void reservationMenu(){
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
                    beforeMakeReser();
                    break;
                case 3:
                    // Implement the update reservation functionality
                    break;
                case 4:
                    // Implement the edit reservation functionality
                    break;
                case 5:
                    cancelReservation();
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

    public void beforeMakeReser() {
        System.out.println("For which vehicle ID you want to make a reservation?");
        Main.vehicle.displayOwnerVehicles(Main.name);
        System.out.print(" ==> ");
        int vehicleChoice = in.nextInt() - 1;

        if (vehicleChoice < 0 || vehicleChoice >= Main.vehicles.size()) {
            System.out.println("Invalid choice. Please try again.");
            return;
        }

        String vehicleType = Main.vehicles.get(vehicleChoice).getType();
        String licenceNumber = Main.vehicles.get(vehicleChoice).getLicence_number();

        System.out.print("Which spot you want to reserve?\n");
        Main.spotManager.displayAvailableSpots(Main.spots, vehicleType);
        System.out.print("\n ==> ");
        int spotChoice = in.nextInt();

        System.out.println("Spot ID ==> " + spotChoice);

        // Display available slots for the chosen spot
        Main.slotManager.displayAvailableSlots(Main.slots, spotChoice);

        // Take slot IDs as input
        System.out.println("Enter the slot IDs you want to reserve (comma-separated):");
        System.out.print("\n==>");
        String anEmptyLineFromTheFile = in.nextLine(); // To consume the leftover newline
        String slotString = in.nextLine(); // To take input from the user
        String[] slotIDsParts = slotString.split(",");
        for (String part : slotIDsParts) {
            try {
                int slotID = Integer.parseInt(part.trim());
                reservation.addSlotID(slotID);
            } catch (NumberFormatException n) {
                System.out.println("Invalid input: " + part.trim() + " is not a number!\nPlease, just enter numbers separated by commas.");
            } catch (Exception e) {
                throw new RuntimeException(e);
            }
        }
        // Make the reservation
        makeReservation(Main.name, spotChoice, reservation.getSlotIDs(), vehicleType, licenceNumber);
    }

    public void makeReservation(String name, int spotID, List<Integer> slotIDs, String vehicleType, String licenceNumber) {
        Reservation reservation = new Reservation(name, spotID, slotIDs, vehicleType, licenceNumber);

        // Update slot status to reserved
        for (Integer slotID : slotIDs) {
            reservation.spot.reserveSlot(spotID, slotID);
        }
//        for (int slotID : slotIDs) {
//            for (Slot slot : Main.slots) {
//                if (slot.getSlotId() == slotID) {
//                    slot.setReserved(true);
//                }
//            }
//        }

        // Add reservation to the list
        Main.owners.get(Main.index).setReservationToArray(reservation);
        Main.reservations.add(reservation);
        System.out.println("Reservation Done!");
    }




//        public void displayOwnerReservations() {
//        for(int i = 0 ; i < Main.owners.get(Main.index).getReservationArray().size(); i++){
//        if(Main.reservations.get(i).getOwnerName().equalsIgnoreCase(reservation.getOwnerName())){
//            reservation.reservationDetails();
//        }
//        else{
//            System.out.println("You do not have reservations yet!");
//        }
//        }
//    }
    public void displayReservations() {
        if (Main.reservations.isEmpty()) {
            System.out.println("No reservations found.");
        } else {
            for (Reservation reservation : Main.reservations) {
                System.out.println(reservation.reservationDetails());
            }
        }
    }

    public void cancelReservation() {
        // Step 1: Display existing reservations
        if (Main.reservations.isEmpty()) {
            System.out.println("You have no reservations to cancel.");
            return;
        }

        System.out.println("Your existing reservations:");
        for (int i = 0; i < Main.reservations.size(); i++) {
            System.out.println((i + 1) + ") " + Main.reservations.get(i).reservationDetails());
        }

        // Step 2: Allow user to select a reservation to cancel
        System.out.print("Enter the number of the reservation you want to cancel (1-" + Main.reservations.size() + "): ");
        int reservationChoice = in.nextInt() - 1;

        if (reservationChoice < 0 || reservationChoice >= Main.reservations.size()) {
            System.out.println("Invalid reservation choice. Please try again.");
            return;
        }

        // Step 3: Remove the selected reservation from the list
        Reservation reservationToCancel = Main.reservations.get(reservationChoice);
        Main.reservations.remove(reservationChoice);

        // Step 5: Confirm cancellation
        System.out.println("Reservation for " + reservationToCancel.getVehicleType() + " with license number " +
                reservationToCancel.getLicenseNumber() + " has been successfully canceled.");
    }
}
