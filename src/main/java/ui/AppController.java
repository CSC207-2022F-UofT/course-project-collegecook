package ui;

import login.LoginControllor;
import mealplan.MealplanController;
import profile.ProfileController;
import rank.RankController;
import recipe.RecipeController;

public class AppController {
    private final RecipeController recipeController;
    private final LoginControllor loginControllor;
    private final ProfileController profileController;
    private final MealplanController mealplanController;
    private final RankController rankController;

    public AppController(RecipeController recipeController, LoginControllor loginControllor, ProfileController profileController,
                         MealplanController mealplanController, RankController rankController) {
        this.recipeController = recipeController;
        this.loginControllor = loginControllor;
        this.profileController = profileController;
        this.mealplanController = mealplanController;
        this.rankController = rankController;
    }

    public RecipeController getRecipeController() {
        return recipeController;
    }

    public RankController getRankController() {
        return rankController;
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
