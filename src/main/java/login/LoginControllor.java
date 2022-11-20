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

    public void PerformCheckFollow(String username){
        userManager.Logout(username);
    }









}
