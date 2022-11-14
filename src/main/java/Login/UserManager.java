package Login;

import entities.User;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class UserManager {
    private List<User> AllUser;

    public UserManager() {
        AllUser = new ArrayList<>();
    }

    public void setAllUser(String username, String password) {
        for(User person :AllUser){
            if (Objects.equals(person.getUsername(), username)){
                continue;
            } else{
                User UserName = new User(username, password);
                AllUser.add(UserName);
            }
        }
    }


    // method to add user to the allUsers when user created the account,need to check if the username already in the list

    // method to find the user in the allUsers and change the status to logged in
    // method to find the user in the allUsers and change the status to logged out

    // method to find the user in the allUsers and add the other user in to the followed list(attribute of user),need to
    //check if the other user is already followed,also find the other user and add the user from the following list(attribute of user)

    // method to find the user in the allUsers and remove the other user in to the followed list(attribute of user),need to
    //check if the other user is already followed,also find the other user and remove the user from the following list(attribute of user)



}
