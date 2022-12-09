package login;

import recipe.RecipeViewBox;

public interface UserOutputBound {
    void LoginSuccess();
    void LoginFailed();
    void CreatAccountSuccess();
    void CreatAccountFail();

    void FollowedSuccess();
    void FollowedFail();

    void UnFollowedSuccess();
    void UnFollowedFail();
    void setUI(UserSignInBox userSignInBox);
    void setUI(SignUpBox signUpBox);
    void setUI(RecipeViewBox recipeViewBox);

}
