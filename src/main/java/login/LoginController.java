package login;


import java.io.IOException;

public class LoginController {
    LoginInputBound loginInputBound;

    public LoginController(LoginInputBound loginInputBound) {
        this.loginInputBound = loginInputBound;
    }

    /**
     *
     * @param username The username of the user.
     * @param password The password of the user.

     * This method is used to collect input and create the new user account
     */
    public void PerformCreateAllUser(String username, String password){
        loginInputBound.CheckAllUser(username,password);
    }

    /**
     *
     * @param username The username of the user.
     * @param password The password of the user.

     * This method is used to collect input and login the user
     */
    public void PerformLogin(String username,String password){
        loginInputBound.Login(username,password);
    }


    /**
     *
     * @param username The username of the user.
     * @param other The username of the other user the user want to follow.
     * This method is used to follow other user
     */
    public void PreformFollow(String username, String other) throws IOException {
        if (loginInputBound.CheckFollow(username,other)){
            loginInputBound.follow(username,other);
        }
    }


    /**
     *
     * @param username The username of the user.
     * @param other The username of the other user the user want to unfollow.
     * This method is used to unfollow other user
     */
    public void PreformUnFollow(String username, String other){
        if(loginInputBound.CheckUnFollow(username,other)){
            loginInputBound.Unfollow(username,other);}
             }

    /**
     * @return the user that is currently logged in
     * This method is used to return the user that is currently logged in
     */
    public String preformGetLoggedInUser(){
        return loginInputBound.getLoggedInUser();
    }

/*    public static void main(String[] arg){
        UserGateWay userGateWay = UserRepoImpl.getUserRepoImpl();
        LoginOutputBound loginOutputBound = new LoginPresenter();
        LoginInputBound loginInputBound1 = new UserManager(loginOutputBound, userGateWay);
        LoginControllor loginControllor = new LoginControllor(loginInputBound1);
        loginControllor.PerformLogin("Brenden", "12345");
    }*/
    }










