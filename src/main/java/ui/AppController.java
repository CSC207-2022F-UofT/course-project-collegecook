package ui;

import login.LoginControllor;
import mealplan.MealplanController;
import profile.ProfileController;
import recipe.RecipeController;

public class AppController {
    private final RecipeController recipeController;
    private final LoginControllor loginControllor;
    private final ProfileController profileController;
    private final MealplanController mealplanController;

    public AppController(RecipeController recipeController, LoginControllor loginControllor, ProfileController profileController,
                         MealplanController mealplanController) {
        this.recipeController = recipeController;
        this.loginControllor = loginControllor;
        this.profileController = profileController;
        this.mealplanController = mealplanController;
    }

    public RecipeController getRecipeController() {
        return recipeController;
    }

    public LoginControllor getLoginControllor() {
        return loginControllor;
    }

    public ProfileController getProfileController() {
        return profileController;
    }

    public MealplanController getMealplanController() {
        return mealplanController;
    }
}