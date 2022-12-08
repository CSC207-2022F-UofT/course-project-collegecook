package login;


import recipe.RecipeViewBox;


public class UserPresenter implements UserOutputBound {

    UserSignInBox userSignInBox;
    SignUpBox signUpBox;
    RecipeViewBox recipeViewBox;

    @Override
    public void LoginSuccess() {
        userSignInBox.loginSuccess();
    }

    @Override
    public void LoginFailed() {
        userSignInBox.loginFailed();


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


    public void setUI(UserSignInBox userSignInBox){
        this.userSignInBox = userSignInBox;
    }
    public void setUI(SignUpBox signUpBox){
        this.signUpBox = signUpBox;
    }
    public void setUI(RecipeViewBox recipeViewBox){this.recipeViewBox = recipeViewBox;}
}
