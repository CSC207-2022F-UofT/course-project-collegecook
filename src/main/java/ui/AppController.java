package ui;

import login.LoginControllor;
import mealplan.MealplanController;
import profile.ProfileController;
import recipe.RecipeController;
import search.SearchController;

public class AppController {
    private final RecipeController recipeController;
    private final LoginControllor loginControllor;
    private final ProfileController profileController;
    private final MealplanController mealplanController;

    private final SearchController searchController;
    public AppController(RecipeController recipeController, LoginControllor loginControllor, ProfileController profileController,
                         MealplanController mealplanController, SearchController searchController) {
        this.recipeController = recipeController;
        this.loginControllor = loginControllor;
        this.profileController = profileController;
        this.mealplanController = mealplanController;
        this.searchController = searchController;
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

    public SearchController getSearchController() {
        return searchController;

    }
}
