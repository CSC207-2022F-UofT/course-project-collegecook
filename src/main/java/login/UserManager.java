package login;

import entities.*;

import java.io.IOException;
import java.util.Objects;

public class UserManager {
    private UserList AllUser;

    private final UserGateWay rrg = UserRepoImpl.getUserRepoImpl();

    final login.LoginOutputBound LoginOutputBound;
    private String loggedInUser;

    public UserManager(login.LoginOutputBound loginOutputBound) {

        this.LoginOutputBound = loginOutputBound;
        try {
            AllUser = rrg.getAllUser();
        } catch (IOException e) {
            AllUser = new UserList();
        }
    }


    //create Account
    public void CheckAllUser(String username,String password){
        if (AllUser.CheckAllUser(username)){
            AllUser.AddAllUser(username,password);
            try {
                rrg.saveUser(AllUser);
                LoginOutputBound.CreatAccountSuccess();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }else{LoginOutputBound.CreatAccountFail();}
    }


    // method to find the user in the allUsers and change the status to logged in
    public void Login(String username, String password){
        for(User person :AllUser.getAllUser()){
            if(Objects.equals(person.getUsername(), username) && Objects.equals(person.getPassword(), password)){
                person.setLoginStatus(true);
                this.loggedInUser = username;
                LoginOutputBound.LoginSuccess();
            }else{
                LoginOutputBound.LoginFailed();
                }

            }
        }


    // method to find the user in the allUsers and change the status to logged out
    public void Logout(String username){
        for(User person :AllUser.getAllUser()){
            if(Objects.equals(person.getUsername(), username)){
                person.setLoginStatus(false);
            }else{LoginOutputBound.LogoutFail();}

        }


    }

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


    //a user want to follow another user
    // add other to user.followed
    //other.follower add user
    // method to find the user in the allUsers and add the other user in to the followed list(attribute of user),need to
    //check if the other user is already followed,also find the other user and add the user from the following list(attribute of user)
    public void follow(String username, String other){
        for(User person :AllUser.getAllUser()){
            if(Objects.equals(person.getUsername(), username)){
                person.addFollowed(AllUser.getUser(other));
                AllUser.getUser(other).addFollowers(person);
                LoginOutputBound.FollowedSuccess();
            }
        }
    }

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

    public String getLoggedInUser(){
        return this.loggedInUser;
    }
}
