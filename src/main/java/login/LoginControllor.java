package login;

import entities.UserList;

public class LoginControllor {
    UserManager userManager;

    public LoginControllor(UserManager userManager) {
        this.userManager = userManager;
    }

    public void PerformCreateAllUser(String username, String password){
        userManager.CheckAllUser(username,password);

    }
    public void PerformLogin(String username,String password){
        userManager.Login(username,password);
    }

    public void PerformLogout(String username){
        userManager.Logout(username);
    }


    public void PreformFollow(String username, String other){
        if (userManager.CheckFollow(username,other)){
            userManager.follow(username,other);
        }
    }

    public void PreformCheckUnFollow(String username, String other){
        userManager.CheckUnFollow(username,other);
    }

    public void PreformUnFollow(String username, String other){
        if(userManager.CheckUnFollow(username,other)){
            userManager.Unfollow(username,other);}
             }

    public String preformGetLoggedInUser(){
        return userManager.getLoggedInUser();
    }

    public static void main(String[] arg){
        UserGateWay userGateWay = UserRepoImpl.getUserRepoImpl();
        LoginOutputBound loginOutputBound = new LoginPresenter();
        UserManager userManager1 = new UserManager(loginOutputBound, userGateWay);
        LoginControllor loginControllor = new LoginControllor(userManager1);
        loginControllor.PerformLogin("Brenden", "12345");
    }
    }










