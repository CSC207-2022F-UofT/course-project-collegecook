package ui;

import login.LoginControllor;
import mealplan.MealplanController;
import profile.ProfileController;
import rank.RankController;
import recipe.RecipeController;
import search.SearchController;

public class AppController {
    private final RecipeController recipeController;
    private final LoginControllor loginControllor;
    private final ProfileController profileController;
    private final ReviewController reviewController;
    private final SearchController searchController;
    private final RankController rankController;
    private final MealplanController mealplanController;

    public AppController(RecipeController recipeController, LoginControllor loginControllor, ProfileController profileController,
                         MealplanController mealplanController, SearchController searchController, RankController rankController) {
        this.recipeController = recipeController;
        this.loginControllor = loginControllor;
        this.profileController = profileController;
        this.mealplanController = mealplanController;
        this.searchController = searchController;
        this.reviewController = reviewController;
        this.rankController = rankController;

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
    public RankController getRankController() {
        return rankController;
    }
    public SearchController getSearchController() {
        return searchController;

    }
}
