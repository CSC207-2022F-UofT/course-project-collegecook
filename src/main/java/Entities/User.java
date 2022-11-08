package Entities;
import java.util.List;
public class User {

    private String username;
    private String password;
    private boolean LoginStatus;
    private Profile profile;
    private List<User> UserList;
    private List<User> followers;
    private List<User> followed;

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

    public int GetNumberOfFollowers(){return followers.size();}

    public int GetNumberOfFollowed(){return followed.size(); }

    public void setLoginStatus(boolean loginStatus) {
        LoginStatus = loginStatus;
    }
}

