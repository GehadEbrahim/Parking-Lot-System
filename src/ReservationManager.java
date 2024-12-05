import java.io.*;
import java.util.*;

public class ReservationManager {
    public List<Reservation> loadReservations(String filePath) throws IOException {
        List<Reservation> spots = new ArrayList<>();
        try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {
            String line;
            while ((line = br.readLine()) != null) {
                if (line.trim().isEmpty() || line.trim().startsWith("/")) {
                    continue;
                }

                String[] parts = line.split(",");
                try {
                    int spotId = Integer.parseInt(parts[0].trim());
                    String type = parts[1].trim();
                    int slotId = Integer.parseInt(parts[2].trim());
                    int maxSlots = 3;
                    Reservation spot = new Reservation(spotId , slotId);
                    spots.add(spot);
                } catch (NumberFormatException e) {
                    System.out.println("Error parsing line: " + line);
                }
            }
        } catch (IOException e) {
            System.out.println("Error reading the file: " + filePath);
            throw e;
        }
        return spots;
    }

}
