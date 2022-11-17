package Entities;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class User {

    private String username;
    private String password;

    private boolean LoginStatus;
    private Profile profile;
    private List<User> followers;
    private List<User> followed;

    public User(String username, String password) {
        this.username = username;
        this.password = password;
        this.followers = new ArrayList<>();
        this.followed = new ArrayList<>();

    }

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }

    public boolean isLoginStatus() {
        return LoginStatus;
    }

    public int GetNumberOfFollowers(){return followers.size();}

    public int GetNumberOfFollowed(){return followed.size(); }

    public void setLoginStatus(boolean loginStatus) {
        LoginStatus = loginStatus;
    }

    public void addFollowers(User Other) {

        this.followers.add(Other);
    }
    public void addFollowed(User Other) {

        this.followed.add(Other);
    }

    public void setProfile(Profile profile) {
        this.profile = profile;
    }

    public void RemoveFollowers(User other) {
        this.followers.remove(other);
    }

    public void RemoveFollowed(User other) {
        this.followed.remove(other);
    }

    public List<User> getFollowers() {
        return followers;
    }

    public List<User> getFollowed() {
        return followed;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof User)) return false;
        User user = (User) o;
        return getUsername().equals(user.getUsername());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getUsername());
    }
}

