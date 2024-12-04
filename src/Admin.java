//Start Admin class
public class Admin extends User{


    public Admin(String name, String password) {
        super(name, password);
    }

    @Override
    public int logIn(String name, String password) {
        return 0;
    }
}
