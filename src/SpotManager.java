import java.io.*;
import java.util.*;

public class SpotManager {
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
                    int spotId = Integer.parseInt(parts[0].trim());
                    String type = parts[1].trim();
                    double fees = Double.parseDouble(parts[2].trim());
                    spots.add(new Spot(type, spotId, fees));
                } catch (NumberFormatException e) {
                    System.out.println("Error parsing line: " + line);
                }
            }
        }
        return spots;
    }

    public void displayAvailableSpots(List<Spot> spots , String type) {
        boolean availableFound = false;
        for (Spot spot : spots) {
            if (!spot.isFull() && spot.getType().toUpperCase().equals(type)){
                System.out.println(spot.toString());
                availableFound = true;
            }
        }
        if (!availableFound) {
            System.out.println("No available spots.");
        }
    }

    public static void displaySpots(List<Spot> spots) {
        for (int i = 0; i < spots.size(); i++) {
            System.out.println((i + 1) + ") " + spots.get(i).toStringAll());
        }
    }

        //use it in owner profile => display the spots he reserved and its slots
    public Spot getSpotById(List<Spot> spots, int spotId) {
        for (Spot spot : spots) {
            if (spot.getId() == spotId) {
                return spot;
            }
        }
        return null;
    }

    public void deleteSpot(List<Spot> spots, int spotId) {
        spots.removeIf(spot -> spot.getId() == spotId);
    }
}