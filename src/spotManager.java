import java.io.*;
import java.util.*;

public class spotManager {
    public List<Spot> loadSpots(String filePath) throws IOException {
        List<Spot> spots = new ArrayList<>();
       // filePath = "C:/Users/gebra/OneDrive/Desktop/PLS/Spots.txt";
        try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {
            String line;
            while ((line = br.readLine()) != null) {
                // if (line.startsWith("#") || line.trim().isEmpty()) continue;

                String[] parts = line.split(",");
                int spotId = Integer.parseInt(parts[0].trim());
                String type = parts[1].trim();
                //int maxSlots = Integer.parseInt(parts[2].trim());
                double fees = Integer.parseInt(parts[2].trim());

                Spot spot = new Spot(type, spotId, fees/*, maxSlots*/);
                spots.add(spot);
            }
        }catch(IOException e){
            e.printStackTrace();
        }
        return spots;
    }

    public void displayAvailableSpots(List<Spot> spots) {
        System.out.println("Spot ID       Spot Type       Fees");
        for (Spot spot : spots) {
            if(spot.getId() != 0)
                System.out.println(spot.getDetails());
        }
    }
    public void displaySpots(List<Spot> spots) {
        System.out.println("Spot ID       Spot Type       Fees");
        for (int i =0 ; i < spots.toArray().length ; i++) {         /*Spot spot : spots*/
                System.out.println((i+1) + ") " +spots.get(i).getDetails());
        }

    }

    public Spot getSpotById(List<Spot> spots, int spotId) {
        for (Spot spot : spots) {
            if (spot.getId() == spotId) {
                return spot;
            }
        }
        return null; // إذا لم يتم العثور على أي Spot
    }
    public void deleteSpot(List<Spot> spots , int spotId){
        for (Spot spot : spots) {
            if (spot.getId() == spotId) {
                spot.setId(0);
                spot.setType(null);
                spot.setFees(0.0);
            }
        }
    }
}
