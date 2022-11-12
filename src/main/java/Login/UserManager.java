package Login;

import Entities.User;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import static com.sun.tools.doclint.Entity.and;

public class UserManager {
    private List<User> AllUser;

    public UserManager() {
        AllUser = new ArrayList<>();
    }


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



    // method to find the user in the allUsers and change the status to logged in
    public void Login(String username, String password){
        for(User person :AllUser){
            if(Objects.equals(person.getUsername(), username) && Objects.equals(person.getPassword(), password)){
                person.setLoginStatus(true);}else{return something;}

            }


        }

    // method to find the user in the allUsers and change the status to logged out
    public void Logout(String username){
        for(User person :AllUser){
            if(Objects.equals(person.getUsername(), username)){
                person.setLoginStatus(false);}else{return something;}

        }


    }

    }


    // method to find the user in the allUsers and add profile

    // method to find the user in the allUsers and add the other user in to the followed list(attribute of user),need to
    //check if the other user is already followed,also find the other user and add the user from the following list(attribute of user)

    // method to find the user in the allUsers and remove the other user in to the followed list(attribute of user),need to
    //check if the other user is already followed,also find the other user and remove the user from the following list(attribute of user)



}
