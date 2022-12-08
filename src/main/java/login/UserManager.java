package login;

import entities.*;

import java.io.IOException;
import java.util.List;
import java.util.Objects;

public class UserManager implements LoginInputBound {
    private UserList AllUser;

    private final UserGateWay urg;

    final login.LoginOutputBound LoginOutputBound;
    private String loggedInUser;

    public UserManager(login.LoginOutputBound loginOutputBound, UserGateWay userGateWay) {
        this.urg = userGateWay;
        this.LoginOutputBound = loginOutputBound;
        try {
            AllUser = urg.getAllUser();
        } catch (IOException e) {
            AllUser = new UserList();
        }
    }

    /**
     * To add a user to the allUser list when user created the account and show a success
     * massage when an account is created and an error message if unsuccessful
     * the username is  already in the list
     * @param username string username of a new user account
     * @param password string password of a new user account
     */
    @Override
    //create Account
    public void CheckAllUser(String username,String password){
        if (AllUser.CheckAllUser(username)){
            AllUser.AddAllUser(username,password);
            try {
                urg.saveUser(AllUser);
                LoginOutputBound.CreatAccountSuccess();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }else{LoginOutputBound.CreatAccountFail();}
    }

    /**
     * To check the username and password and
     * login the user and show messages when successful/ unsuccessful
     * @param username string username of the user
     * @param password string password of the user
     */

    @Override
    // method to find the user in the allUsers and change the status to logged in
    public void Login(String username, String password){
        List<User> allUser = AllUser.getAllUser();
        if (allUser.size() == 0){
            LoginOutputBound.LoginFailed();
        }
        else {
            for (User person : AllUser.getAllUser()) {
                if (Objects.equals(person.getUsername(), username) && Objects.equals(person.getPassword(), password)) {
                    this.loggedInUser = username;
                    LoginOutputBound.LoginSuccess();
                    return;
                }
            }
            LoginOutputBound.LoginFailed();
        }
    }


    /**
     * To check if user already followed this other user
     * and show error messages when the other user is already followed
     * @param username string username of the user
     * @param other string username of the other user
     */

    @Override
    public boolean CheckFollow(String username, String other){
        for(User person :AllUser.getAllUser()){
            if(Objects.equals(person.getUsername(), username)){
                if(!AllUser.contains(other)){
                    LoginOutputBound.FollowedFail();
                    return false;
                }else if (person.getFollowed().contains(AllUser.getUser(other))){
                    LoginOutputBound.FollowedFail();
                    return false;}
                }
            }return true;
        }

    /**
     * To follow the other user
     * and show success messages when followed
     * @param username string username of the user
     * @param other string username of the other user
     */
    @Override
    //a user want to follow another user
    // add other to user.followed
    //other.follower add user
    // method to find the user in the allUsers and add the other user in to the followed list(attribute of user),need to
    //check if the other user is already followed,also find the other user and add the user from the following list(attribute of user)
    public void follow(String username, String other) throws IOException {
        for(User person :AllUser.getAllUser()){
            if(Objects.equals(person.getUsername(), username)){
                person.addFollowed(AllUser.getUser(other));
                AllUser.getUser(other).addFollowers(person);
                urg.saveUser(AllUser);
                LoginOutputBound.FollowedSuccess();
            }
        }
    }

    /**
     * To check if user already unfollowed this other user
     * and show error messages when the other user is already unfollowed
     * @param username string username of the user
     * @param other string username of the other user
     */
    @Override
    // method to find the user in the allUsers and remove the other user in to the followed list(attribute of user),need to
    //check if the other user is already followed,also find the other user and remove the user from the following list(attribute of user)
    public boolean CheckUnFollow(String username, String other) {
        for (User person : AllUser.getAllUser()) {
            if (!AllUser.contains(other)) {
                LoginOutputBound.UnFollowedFail();
                return false;
            }
            if (Objects.equals(person.getUsername(), username)) {
                if (person.getFollowed().contains(AllUser.getUser(other))) {
                    return true;
                }
            }
        }
        LoginOutputBound.UnFollowedFail();
        return false;
    }
    /**
     * To unfollow the other user
     * and show success messages when unfollowed
     * @param username string username of the user
     * @param other string username of the other user
     */
    @Override
    // remove Other from user.followed
    //remove user from other.following
    public void Unfollow(String username, String other){
        for(User person :AllUser.getAllUser()){
            if(Objects.equals(person.getUsername(), username)){
                person.RemoveFollowed(AllUser.getUser(other));
                AllUser.getUser(other).RemoveFollowers(person);
                LoginOutputBound.UnFollowedSuccess();
            }
        }
    }
    /**
     * To get the username of the logging user
     * @return username of user who is currently logged in.
     */
    @Override
    public String getLoggedInUser(){
        return this.loggedInUser;
    }
}
