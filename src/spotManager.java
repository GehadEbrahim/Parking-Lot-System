import java.io.*;
import java.util.*;

public class spotManager {
    public List<Spot> loadSpots(String filePath) throws IOException {
        List<Spot> spots = new ArrayList<>();
        try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {
            String line;
            while ((line = br.readLine()) != null) {
                if (line.trim().isEmpty() || line.trim().startsWith("/")) {
                    continue;
                }

                String[] parts = line.split(",");
                try {
                    int spotId = Integer.parseInt(parts[0].trim()); //Integer.parseInt => to convert from String to Integer
                    String type = parts[1].trim();
                    double fees = Double.parseDouble(parts[2].trim());
                } catch (NumberFormatException e) {
                    System.out.println("Error parsing line: " + line);
                }
            }
        } catch (IOException e) {
            System.out.println("Error reading the file: " + FilePaths.RESERVATIONS_FILE_PATH);
            throw e;
        }
        return spots;
    }

    public void displayAvailableSpots(List<Spot> spots) {
        System.out.println("Spot ID       Spot Type       Fees");
        for (Spot spot : spots) {
            if (spot.getId() != 0) {
                System.out.println(spot.getDetails());
            }
        }
    }

    public void displaySpots(List<Spot> spots) {
        System.out.println("Spot ID       Spot Type       Fees");
        for (int i = 0; i < spots.size(); i++) {
            System.out.println((i + 1) + ") " + spots.get(i).getDetails());
        }
    }

    public Spot getSpotById(List<Spot> spots, int spotId) {
        for (Spot spot : spots) {
            if (spot.getId() == spotId) {
                return spot;
            }
        }
        return null; // if it didn't find any spot , it will return null
    }

    public void deleteSpot(List<Spot> spots, int spotId) {
        spots.removeIf(spot -> spot.getId() == spotId);
    }
}
