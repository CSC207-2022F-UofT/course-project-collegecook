package entities;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class UserList implements Serializable {
    private final List<User> AllUser;


    public UserList() {
        this.AllUser = new ArrayList<>();
    }

    /**
     * Method to make sure no users has same username when creating new account
     * @param username string username of a user that needs to be checked
     * @return Return true if there are no matching usernames, false of the username already exits
     */
    public boolean CheckAllUser(String username) {
        for (User person : AllUser) {
            if (Objects.equals(person.getUsername(), username)) {
                return false;
            }
        }return true;
    }

    /**
     * To add a user to the allUser list when user created the account and the username is not already in the list
     * @param username string username of a new user account
     * @param password string password of a new user account
     */
    public void AddAllUser(String username, String password) {

        User CollegeCook = new User(username, password);
        AllUser.add(CollegeCook);
    }

    /**
     * To check if UserList has certain user
     * @param username string username that needs to be checked
     * @return return true if the user is in the UserList,false if it is not.
     */
    public Boolean contains(String username) {
        for (User person : AllUser) {
            if (Objects.equals(person.getUsername(),username)){
                return true;
            }
        }return false;
    }

    /**
     * To get a user from the UserList
     * @param username string username of the user that need to return
     * @return return the user with the username
     */

    public User getUser(String username) {
        for (User person : AllUser) {
            if (Objects.equals(person.getUsername(), username)) {
                return person;
            }
        }
        return null;
    }


    /**
     * To get a UserList
     * @return a list of users that has an account
     */
    public List<User> getAllUser() {
        return AllUser;
    }

}
