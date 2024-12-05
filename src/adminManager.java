import java.io.IOException;
import java.util.*;

public class adminManager {
    private Scanner in = new Scanner(System.in);

    public void meanFunction() throws IOException {
        while (true) {
            System.out.println("\n1) Profile");
            System.out.println("2) Delete");
            System.out.println("3) Add slots");
            System.out.println("4) Display");
            System.out.println("5) Update");
            System.out.println("6) The total amount");
            System.out.println("7) Exit");
            System.out.print(" ==> ");
            int menuChoice;
            try {
                menuChoice = Integer.parseInt(in.nextLine()); //Integer.parseInt => to convert from String to Integer
            } catch (NumberFormatException e) {
                System.out.println("Invalid input. Please enter a number.");
                continue;
            }
            switch (menuChoice) {
                case 1:
                    System.out.println("Profile selected.");
                    // calling displayEntity method
                    break;
                case 2:
                    System.out.println("Delete selected.");
                    // calling deleteEntity method
                    break;
                case 3:
                    System.out.println("Add slots selected.");
                    // calling AddSlots method
                    break;
                case 4:
                    System.out.println("Display selected.");
                    displayMenu();
                    break;
                case 5:
                    System.out.println("Update selected.");
                    // calling Update method
                    break;
                case 6:
                    System.out.println("The total amount selected.");
                    //calling calculate and display method
                    break;
                case 7:
                    System.out.println("\t\t\t\t\t\tExiting the program.\n\t\t\t\t\t\t\t\tGoodbye!");
                    return;
                default:
                    System.out.println("Invalid choice. Please try again.");
                    break;
            }
        }
    }

    private void displayMenu() throws IOException {
        System.out.println("What do you want to display?");
        System.out.println("1) Owner");
        System.out.println("2) Slot");
        System.out.println("3) Spot");
        System.out.println("4) Vehicle");
        System.out.print(" ==> ");
        int displayChoice = Integer.parseInt(in.nextLine());

        switch (displayChoice) {
            case 1:
                System.out.println("Displaying Owners...");
                // استدعاء دالة عرض الملاك
                break;
            case 2:
                System.out.println("Displaying Slots...");
                // call displaySlots method
                break;
            case 3:
                spotManager s = new spotManager();
                List<Spot> spots = s.loadSpots( FilePaths.SPOTS_FILE_PATH);
                if (spots != null) {
                    for (Spot spot : spots) {
                        System.out.println(spot); // Assuming Spot has a toString() method.
                    }
                } else {
                    System.out.println("No spots available to display.");
                }
                break;
            case 4:
                System.out.println("Displaying Vehicles...");
                // استدعاء دالة عرض المركبات
                break;
            default:
                System.out.println("Invalid choice.");
                break;
        }
    }
    public void deletEntity(int choice ,List<?> entityList){
        System.out.println("What to you want to delete?");
        System.out.println("1) Owner");
        System.out.println("2) Slot");
        System.out.println("3) Spot");
        System.out.println("4) vehicle");
        System.out.print(" ==> ");


        int deleteChoose = Integer.parseInt(in.nextLine());
        switch (deleteChoose){
            case 1:
                System.out.println("Which user you want to delete?");
                 //ownerManager.diaplay();
                 //deleteOne()
                break;
            case 2:
                System.out.println("Which slot you want to delete?");
                 //ownerManager.diaplay();
                 //deleteOne()
                break;
            case 3:
                System.out.println("Which spot you want to delete?");
                 //ownerManager.diaplay();
                 //deleteOne()
                break;
        }
        /*
        Delete entity from Chat GPT
        public void deleteEntity(List<?> entityList) {
    System.out.println("Which item do you want to delete?");
    for (int i = 0; i < entityList.size(); i++) {
        System.out.println((i + 1) + ") " + entityList.get(i).toString());
    }
    System.out.print(" ==> ");
    int choice = in.nextInt();
    if (choice > 0 && choice <= entityList.size()) {
        entityList.remove(choice - 1);
        System.out.println("Item deleted successfully.");
    } else {
        System.out.println("Invalid choice.");
    }
}
*/
    }
}
