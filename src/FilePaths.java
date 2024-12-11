import java.io.*;
import java.util.List;

public class FilePaths {
    public static final String SPOTS_FILE_PATH = "C:\\Users\\gebra\\OneDrive\\Desktop\\PLS\\Spots.txt";
    public static final String SLOTS_FILE_PATH = "C:/Users/gebra/OneDrive/Desktop/PLS/Slots.txt";
    public static final String OWNERS_FILE_PATH = "C:\\Users\\gebra\\OneDrive\\Desktop\\PLS\\Owners.txt";
    public static final String RESERVATIONS_FILE_PATH = "C:\\Users\\gebra\\OneDrive\\Desktop\\PLS\\Reservations.txt";
    //public static final String VEHICLES_FILE_PATH = "C:/path/to/Vehicles.txt";

    private <T> void saveToFile(List<T> entityList, String filePath) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(filePath))) {
            for (T entity : entityList) {
                writer.write(entity.toString());
                writer.newLine();
            }
        } catch (IOException e) {
            System.out.println("Error writing to the file: " + filePath);
        }
    }
}