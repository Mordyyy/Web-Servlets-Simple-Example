package UserPackage;

public class User {
    private String user;
    private String password;

    public User(String user, String password){
        this.user = user;
        this.password = password;
    }

    public String getUsername(){
        return user;
    }

    public String getPassword(){
        return password;
    }

}
