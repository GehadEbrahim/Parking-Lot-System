public abstract class User {
    protected String name;
    protected String password;
    public User(String name , String password){
        this.name = name;
        this.password = password;
    }
    abstract public int logIn(String name, String password);
    // public abstract void logOut(String name , String password);
}