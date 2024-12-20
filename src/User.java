import java.io.IOException;

public abstract class User {
    protected String name;
    protected String password;
    public User(String name , String password){
        this.name = name;
        this.password = password;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
    // 0 => admin , 1 => owner , -1 => Invalid
    abstract public int logIn(String name, String password) throws IOException;
}
