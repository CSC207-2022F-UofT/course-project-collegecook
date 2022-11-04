package Entities;
import java.util.List;
public class User {

    private String username;
    private String password;
    private boolean LoginStatus;
    private Profile profile;
    private List<User> UserList;
    private List<User> followers;

    public User(String username, String password) {
        this.username = username;
        this.password = password;
    }

    public String getUsername() {
        return username;
    }

    public boolean isLoginStatus() {
        return LoginStatus;
    }

    public int GetNumberOfFollowers(){return size(followers);}

}
