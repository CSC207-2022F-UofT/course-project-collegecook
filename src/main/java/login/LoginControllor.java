package login;

import entities.UserList;

public class LoginControllor {
    UserManager userManager;

    public void PerformCreateAllUser(String username,String password){
        userManager.CheckAllUser(username,password);

    }
    public void PerformLogin(String username,String password){
        userManager.Login(username,password);
    }

    public void PerformLogout(String username){
        userManager.Logout(username);
    }

    public void PerformCheckFollow(String username, String other){
        userManager.CheckFollow(username,other);
    }

    public void PreformFollow(String username, String other){
        userManager.follow(username,other);
    }

    public void PreformCheckUnFollow(String username, String other){
        userManager.CheckUnFollow(username,other);
    }

    public void PreformUnFollow(String username, String other){
        userManager.Unfollow(username,other);
    }

    public String preformGetLoggedInUser(){
        return userManager.getLoggedInUser();
    }
    }








