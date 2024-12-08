import java.io.*;
import java.util.*;

public class OwnerManager {
    public void menu(){
        System.out.println("1) View my account");
        System.out.println("2) Reservations");
        System.out.println("3) Rewards");
        System.out.println("4) Logout");
    }
    public List<Owner> loadOwners(String filePath) throws IOException {
        List<Owner> owners = new ArrayList<>();
        try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {
            String line;
            while ((line = br.readLine()) != null) {
                if (line.trim().isEmpty() || line.trim().startsWith("/")) {
                    continue;
                }

                String[] parts = line.split(",");
                try {
                    int index = Integer.parseInt(parts[0].trim());
                    String name= parts[1].trim();
                    String password = parts[2].trim();
                    int phoneNumber = Integer.parseInt(parts[3].trim());
                    String email = parts[4].trim();
                    owners.add(new Owner(index ,email, name, password , phoneNumber));
                } catch (NumberFormatException e) {
                    System.out.println("Error parsing line: " + line);
                }
            }
        } catch (IOException e) {
            System.out.println("Error reading the file: " + filePath);  // Changed to use the provided filePath
            throw e;
        }
        return owners;
    }
    public void displayOwners(List<Owner> owners){
        for (int i = 0; i < owners.size(); i++) {
            System.out.println((i + 1) + ") " + owners.get(i).toString());
        }
    }


}
