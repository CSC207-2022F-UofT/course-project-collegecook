package Login;

import Entities.Profile;
import Entities.User;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class UserManager {
    private List<User> AllUser;

    final LoginOutputBound LoginOutputBound;

    public UserManager(LoginOutputBound loginOutputBound) {
        this.LoginOutputBound = loginOutputBound;
    }

    public List<User> getAllUser() {
        return AllUser;
    }

    //Used refactoring (design pattern) to factor out check method to make sure no users has same username when creating new account
    public boolean CheckAllUser(String username) {
        for (User person : AllUser) {
            if (Objects.equals(person.getUsername(), username)) {
                LoginOutputBound.CreatAccountFail();
                return false;
            }
        }return true;
    }

    // method to add user to the allUsers when user created the account,need to check if the username already in the list
    public void AddAllUser(String username, String password) {

        User CollegeCook = new User(username, password);
        AllUser.add(CollegeCook);
        LoginOutputBound.CreatAccountSuccess();
    }



    // method to find the user in the allUsers and change the status to logged in
    public void Login(String username, String password){
        for(User person :AllUser){
            if(Objects.equals(person.getUsername(), username) && Objects.equals(person.getPassword(), password)){
                person.setLoginStatus(true);
                LoginOutputBound.LoginSuccess();
            }else{
                LoginOutputBound.LoginFailed();
                }

            }
        }


    // method to find the user in the allUsers and change the status to logged out
    public void Logout(String username){
        for(User person :AllUser){
            if(Objects.equals(person.getUsername(), username)){
                person.setLoginStatus(false);
            }else{LoginOutputBound.LogoutFail();}

        }


    }
    // method to find the user in the allUsers and add profile

    public void AddProfile(String username, Profile profile){
        for(User person :AllUser){
            if(Objects.equals(person.getUsername(), username)){
                person.setProfile(profile);}else{LoginOutputBound.AddProfile();}

        }

    }

    //Check if user already followed this other user(refactoring)
    public boolean CheckFollow(String username, User other){
        for(User person :AllUser){
            if(Objects.equals(person.getUsername(), username)){
                if (person.getFollowed().contains(other)){
                    LoginOutputBound.FollowedFail();
                    return false;
                }
            }
            }return true;

        }

    //a user want to follow another user
    // add other to user.followed
    //other.follower add user
    // method to find the user in the allUsers and add the other user in to the followed list(attribute of user),need to
    //check if the other user is already followed,also find the other user and add the user from the following list(attribute of user)
    public void follow(String username, User other){
        for(User person :AllUser){
            if(Objects.equals(person.getUsername(), username)){
                person.addFollowed(other);
                other.addFollowers(person);
                LoginOutputBound.FollowedSuccess();
            }

        }


    }

    // method to find the user in the allUsers and remove the other user in to the followed list(attribute of user),need to
    //check if the other user is already followed,also find the other user and remove the user from the following list(attribute of user)
    public boolean CheckUnFollow(String username, User other){
        for(User person :AllUser){
            if(Objects.equals(person.getUsername(), username)){
                if (person.getFollowed().contains(other)){
                    return true;
                }
            }
        }
        LoginOutputBound.UnFollowedFail();
        return false;

    }

    // remove Other from user.followed
    //remove user from other.following
    public void Unfollow(String username, User other){
        for(User person :AllUser){
            if(Objects.equals(person.getUsername(), username)){
                person.RemoveFollowed(other);
                other.RemoveFollowers(person);
                LoginOutputBound.UnFollowedSuccess();
            }

        }


    }


}
