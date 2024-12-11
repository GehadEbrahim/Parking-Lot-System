
import java.util.*;
import java.io.*;

public class AdminManager {
    private Scanner in = new Scanner(System.in);

    public void meanFunction() throws IOException {
        System.out.println("\n1) Profile");
        System.out.println("2) Delete");
        System.out.println("3) Add slots");
        System.out.println("4) Display");
        System.out.println("5) Update");
        System.out.println("6) The total amount");
        System.out.println("7) Exit");
        System.out.print(" ==> ");
        int menuChoice = 0;
        try {
            menuChoice = Integer.parseInt(in.nextLine());
        } catch (NumberFormatException e) {
            System.out.println("\t\t\t\t\t\tInvalid input. Please enter a number.");
        }

        switch (menuChoice) {
            case 1:
                System.out.println("\t\t\t\t\t\tProfile selected.");
                break;
            case 2:
                System.out.println("\t\t\t\t\t\tDelete selected.");
                deleteEntity();
                break;
            case 3:
                System.out.println("\t\t\t\t\t\tAdd slots selected.");
                break;
            case 4:
                System.out.println("\t\t\t\t\t\tDisplay selected.");
                displayMenu();
                break;
            case 5:
                System.out.println("\t\t\t\t\t\tUpdate selected.");
                break;
            case 6:
                System.out.println("\t\t\t\t\t\tThe total amount selected.");
                break;
            case 7:
                System.out.println("\t\t\t\t\t\tExiting the program.\n\t\t\t\t\t\t\t\tGoodbye!");
                return;
            default:
                System.out.println("\t\t\t\t\t\tInvalid choice. Please try again.");
                break;
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
                System.out.println("\t\t\t\t\t\tDisplaying Owners...");
                Main.ownerManager.displayOwners(Main.owners);
                break;
            case 2:
                System.out.println("\t\t\t\t\t\tDisplaying Slots...\n");
                Main.slotManager.displaySlots(Main.slots);
                break;
            case 3:
                System.out.println("\t\t\t\t\t\tDisplaying Spots...\n");
                Main.spotManager.displaySpots(Main.spots);
                break;
            case 4:
                System.out.println("\t\t\t\t\t\tDisplaying Vehicles...");
                break;
            default:
                System.out.println("\t\t\t\t\t\tInvalid choice.");
                break;
        }
    }
    public void deleteEntity() throws IOException {
        System.out.println("What do you want to delete?");
        System.out.println("1) Owner");
        System.out.println("2) Slot");
        System.out.println("3) Spot");
        System.out.print(" ==> ");

        int deleteChoose = Integer.parseInt(in.nextLine());
        switch (deleteChoose) {
            case 1:
                System.out.println("\t\t\t\t\t\tWhich owner do you want to delete?");
                Main.ownerManager.displayOwners(Main.owners);
                deleteOne(Main.owners);
                break;
            case 2:
                System.out.println("\t\t\t\t\t\tWhich slot do you want to delete?");
                Main.slotManager.displaySlots(Main.slots);
                deleteOne(Main.slots);
                break;
            case 3:
                System.out.println("\t\t\t\t\t\tWhich spot do you want to delete?");
                Main.spotManager.displaySpots(Main.spots);
                deleteOne(Main.spots);
                break;
            default:
                System.out.println("\t\t\t\t\t\tInvalid choice.");
                break;
        }
    }


    protected  <T> void deleteOne(List<T> entityList) {
        if (entityList.isEmpty()) {
            System.out.println("\t\t\t\t\t\tThe list is empty. Nothing to delete.");
            return;
        }

        // Display items in the list
        int userChoice;
        try {
            userChoice = Integer.parseInt(in.nextLine());
        } catch (NumberFormatException e) {
            System.out.println("\t\t\t\t\t\tInvalid input.");
            return;
        }

        if (userChoice > 0 && userChoice <= entityList.size()) {
            // Remove the selected item from the list
            entityList.remove(userChoice - 1);
            System.out.println("\t\t\t\t\t\tItem deleted successfully.");

        } else {
            System.out.println("\t\t\t\t\t\tInvalid choice.");
        }
    }
}
