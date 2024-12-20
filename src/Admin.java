import java.io.IOException;
public class Admin extends User
{
    private String Email;
    private double total_earning;

    public Admin() {
        super("admin", "admin");
        this.Email = "admin@example.com";
        this.total_earning = total_earning;
    }

    public String getEmail() {
        return Email;
    }

    public double getTotal_earning() {
        return total_earning;
    }

    @Override
    public int logIn(String name, String password) throws IOException {
        if (name.toLowerCase().equals("admin") && password.toLowerCase().equals("admin")) {
            return 0;}
        else
            return -1;
    }
}