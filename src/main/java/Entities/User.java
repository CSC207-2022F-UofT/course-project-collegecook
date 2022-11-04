package Entities;
import java.util.List;
public class User {

    private String username;
    private String password;
    private boolean LoginStatus;
    public Profile profile;
    public List<User> UserList;
    public List<User> followers;

    public User(String username, String password) {
        this.username = username;
        this.passward = passward;
    }

    public String getUsername() {
        return username;
    }

    public boolean isLoginStatus() {
        return LoginStatus;
    }

}
