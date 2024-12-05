import java.util.*;

public class adminManager {
    static  Scanner in = new Scanner(System.in);
    //Parameters:
    // Object & List<?>=> To take any object I'll send (owner , spot , slot , vehicle...etc) & (slot_arrayList , spot_arrayList...etc)
    public int Menu(){
        System.out.println("1) Profile");
        System.out.println("2) Delete");
        System.out.println("3) Add slots");
        System.out.println("4) Display");
        System.out.println("5) Update");
        System.out.println("6) The total amount");
        System.out.print(" ==> ");
        int choice = in.nextInt();
        return choice;
    }
    public void meanFunction(){
        int choice = this.Menu();
        switch (choice){
            case 1:
                //display(User[0]);
                break;
            case 2:
                //displsyEntity(object , arrayList);
                //deletEntity(object , arrayList);
                break;
            case 3:
                //addSlot(arrayList);
                break;
            case 4:
                System.out.println("What to you want to display?");
                System.out.println("1) Owner");
                System.out.println("2) Slot");
                System.out.println("3) Spot");
                System.out.println("4) vehicle");
                System.out.print(" ==> ");


                int choose = in.nextInt();
                switch (choose) {
                    case 1:
                        //display() => choose one then display what he selected
                        spotManager s = new spotManager();
                        List<Spot> spots= s.loadSpots("C:/Users/gebra/OneDrive/Desktop/PLS/Spots.txt");
                        //s.displaySpots();

                }
                break;
            case 5:
                //update() => choose one then update what he selected
                break;
            case 6:
                //calculateMoney() => choose one then calculate & display what he selected
                break;
        }
    }
    public void deletEntity(int choice , Object obj , List<?> entityList){
        System.out.println("What to you want to delete?");
        System.out.println("1) Owner");
        System.out.println("2) Slot");
        System.out.println("3) Spot");
        System.out.println("4) vehicle");
        System.out.print(" ==> ");


        int choose = in.nextInt();
        switch (choose){
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
    }
}
