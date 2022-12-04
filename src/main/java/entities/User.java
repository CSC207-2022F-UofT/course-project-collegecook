package entities;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import java.util.Objects;

public class User implements Serializable {
    /**
     * This is the class of User, which is an entity.
     */

    private String username;
    private String password;

    private List<User> followers;
    private List<User> followed;

    /**
     * Constructor for class User
     * @param username The name of the user.
     * @param password The password of the recipe
     */

    public User(String username, String password) {
        this.username = username;
        this.password = password;
        this.followers = new ArrayList<>();
        this.followed = new ArrayList<>();

    }

    /**
     * To return the username of User
     */
    public String getUsername() {
        return username;
    }

    /**
     * To return the password of User
     */
    public String getPassword() {
        return password;
    }

    /**
     * To return the number of followers of the User
     */
    public int GetNumberOfFollowers(){return followers.size();}

    /**
     * To return the number of users a User followed
     */

    public int GetNumberOfFollowed(){return followed.size();}


    /**
     * To add other user to the User's list of followers
     * @param Other The name of the user that want to follow the User.
     */

    public void addFollowers(User Other) {this.followers.add(Other);}

    /**
     * To add the Other user into the list of users a User has followed
     * @param Other The name of the user that the User want to follow.
     */
    public void addFollowed(User Other) {this.followed.add(Other);}

    /**
     * To remove other user from the User's list of followers
     * @param other The name of the user that the User want to follow.
     */
    public void RemoveFollowers(User other) {this.followers.remove(other);}

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
        return Objects.equals(getUsername(), user.getUsername()) && Objects.equals(getPassword(), user.getPassword()) && Objects.equals(getFollowers(), user.getFollowers()) && Objects.equals(getFollowed(), user.getFollowed());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getUsername());
    }
}

