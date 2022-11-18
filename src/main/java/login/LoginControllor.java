package login;

import entities.UserList;

public class LoginControllor {
    UserManager userManager;

    public void PerformCheckAllUser(String username,String password){
        UserList.CreateAccount(username,password);

    }







}
