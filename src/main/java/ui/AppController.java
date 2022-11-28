package ui;

import entities.Review;
import login.LoginControllor;
import mealplan.MealplanController;
import profile.ProfileController;
import recipe.RecipeController;
import review.ReviewController;
import search.SearchController;

public class AppController {
    private final RecipeController recipeController;
    private final LoginControllor loginControllor;
    private final ProfileController profileController;
    private final SearchController searchController;

    private final MealplanController mealplanController;

    private final ReviewController reviewController;

    public AppController(RecipeController recipeController, LoginControllor loginControllor, ProfileController profileController,
                         MealplanController mealplanController, SearchController searchController, ReviewController reviewController) {
        this.recipeController = recipeController;
        this.loginControllor = loginControllor;
        this.profileController = profileController;
        this.mealplanController = mealplanController;
        this.searchController = null;
        this.reviewController = reviewController;
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


    public SearchController getSearchController() {
        return searchController;
    }
    public MealplanController getMealplanController() {
        return mealplanController;

    }
    public ReviewController getReviewController() {
        return reviewController;
    }
}
