package Entities;
import java.util.List;
public class User {

    private String username;
    private String password;
    private User creator;
    private boolean LoginStatus;
    private Profile profile;
    private List<User> UserList;
    private List<User> followers;
    private List<User> followed;

    public User(String username, String password, User creator) {
        this.username = username;
        this.password = password;
        this.creator = creator;
    }

    public String getUsername() {
        return username;
    }

    public boolean isLoginStatus() {
        return LoginStatus;
    }

    public int GetNumberOfFollowers(){return followed.size();}

    public int GetNumberOfFollowed(){return followed.size();}



}
