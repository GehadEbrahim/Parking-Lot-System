import java.io.IOException;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) throws IOException {
        System.out.println("\t\t\t\tWelcome to the praking lot System!\n\t\t\t\t----------------------");
        //Reservation reserv = new Reservation(2001 , 5);
        adminManager a= new adminManager();
        a.meanFunction();

    }
}