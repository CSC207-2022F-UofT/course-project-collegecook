package login;


import java.io.IOException;

public class UserController {
    UserInputBound userInputBound;

    public UserController(UserInputBound userInputBound) {
        this.userInputBound = userInputBound;
    }

    /**
     *
     * @param username The username of the user.
     * @param password The password of the user.

     * This method is used to collect input and create the new user account
     */
    public void PerformCreateAllUser(String username, String password){
        userInputBound.CheckAllUser(username,password);
    }

    /**
     *
     * @param username The username of the user.
     * @param password The password of the user.

     * This method is used to collect input and login the user
     */
    public void PerformLogin(String username,String password){
        userInputBound.Login(username,password);
    }


    /**
     *
     * @param username The username of the user.
     * @param other The username of the other user the user want to follow.
     * This method is used to follow other user
     */
    public void PreformFollow(String username, String other) throws IOException {
        if (userInputBound.CheckFollow(username,other)){
            userInputBound.follow(username,other);
        }
    }


    /**
     *
     * @param username The username of the user.
     * @param other The username of the other user the user want to unfollow.
     * This method is used to unfollow other user
     */
    public void PreformUnFollow(String username, String other){
        if(userInputBound.CheckUnFollow(username,other)){
            userInputBound.Unfollow(username,other);}
             }

    /**
     * @return the user that is currently logged in
     * This method is used to return the user that is currently logged in
     */
    public String preformGetLoggedInUser(){
        return userInputBound.getLoggedInUser();
    }

    }










