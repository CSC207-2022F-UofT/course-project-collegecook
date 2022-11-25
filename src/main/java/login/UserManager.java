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

    @Override
    // method to find the user in the allUsers and change the status to logged out
    public void Logout(String username){
        for(User person :AllUser.getAllUser()){
            if(Objects.equals(person.getUsername(), username)){
            }else{LoginOutputBound.LogoutFail();}

        }


    }

    @Override
    //Check if user already followed this other user(refactoring)
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
    @Override
    public String getLoggedInUser(){
        return this.loggedInUser;
    }
}
