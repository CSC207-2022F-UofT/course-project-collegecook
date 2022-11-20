package login;

import recipe.RecipeCreateBox;
import recipe.RecipeViewBox;
import ui.SignUpUI;

public class LoginPresenter implements LoginOutputBound{

    LoginBox loginBox;
    SignUpBox signUpBox;
    RecipeViewBox recipeViewBox;

    @Override
    public void LoginSuccess() {
        loginBox.loginSuccess();
    }

    @Override
    public void LoginFailed() {
        loginBox.loginFailed();


    }

    @Override
    public void CreatAccountSuccess() {
        signUpBox.createSuccess();

    }

    @Override
    public void CreatAccountFail() {
        signUpBox.createFailed();

    }


    @Override
    public void LogoutFail() {
        System.out.println("You have logged out");

    }

    @Override
    public void FollowedSuccess() {
        recipeViewBox.followSuccess();

    }

    @Override
    public void FollowedFail() {
        recipeViewBox.followFailure();

    }

    @Override
    public void UnFollowedSuccess() {
        System.out.println("Unfollowed successfully");

    }

    @Override
    public void UnFollowedFail() {
        System.out.println("Unfollow fail,You did not follow this user");

    }

    @Override
    public void AddProfile() {
        System.out.println("Please Check Username");

    }

    public void setUI(LoginBox loginBox){
        this.loginBox = loginBox;
    }
    public void setUI(SignUpBox signUpBox){
        this.signUpBox = signUpBox;
    }
    public void setUI(RecipeViewBox recipeViewBox){this.recipeViewBox = recipeViewBox;}
}
