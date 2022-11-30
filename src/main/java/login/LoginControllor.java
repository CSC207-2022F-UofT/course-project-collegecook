package login;

import entities.UserList;

import java.io.IOException;

public class LoginControllor {
    LoginInputBound loginInputBound;

    public LoginControllor(LoginInputBound loginInputBound) {
        this.loginInputBound = loginInputBound;
    }

    public void PerformCreateAllUser(String username, String password){
        loginInputBound.CheckAllUser(username,password);

    }
    public void PerformLogin(String username,String password){
        loginInputBound.Login(username,password);
    }



    public void PreformFollow(String username, String other) throws IOException {
        if (loginInputBound.CheckFollow(username,other)){
            loginInputBound.follow(username,other);
        }
    }



    public void PreformUnFollow(String username, String other){
        if(loginInputBound.CheckUnFollow(username,other)){
            loginInputBound.Unfollow(username,other);}
             }

    public String preformGetLoggedInUser(){
        return loginInputBound.getLoggedInUser();
    }

    public static void main(String[] arg){
        UserGateWay userGateWay = UserRepoImpl.getUserRepoImpl();
        LoginOutputBound loginOutputBound = new LoginPresenter();
        LoginInputBound loginInputBound1 = new UserManager(loginOutputBound, userGateWay);
        LoginControllor loginControllor = new LoginControllor(loginInputBound1);
        loginControllor.PerformLogin("Brenden", "12345");
    }
    }










