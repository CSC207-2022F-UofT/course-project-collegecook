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

    //Used refactoring to factor out check method to make sure no users has same username when creating new account

    public boolean CheckAllUser(String username) {
        for (User person : AllUser) {
            if (Objects.equals(person.getUsername(), username)) {
                return false;
            }
        }return true;
    }

    // method to add user to the allUsers when user created the account,need to check if the username already in the list
    public void AddAllUser(String username, String password) {

        User CollegeCook = new User(username, password);
        AllUser.add(CollegeCook);
    }

    public Boolean contains(String username) {
        for (User person : AllUser) {
            if (Objects.equals(person.getUsername(),username)){
                return true;
            }
        }return false;
    }

    public User getUser(String username) {
        for (User person : AllUser) {
            if (Objects.equals(person.getUsername(), username)) {
                return person;
            }
        }
        return null;
    }

    public List<User> getAllUser() {
        return AllUser;
    }

}
