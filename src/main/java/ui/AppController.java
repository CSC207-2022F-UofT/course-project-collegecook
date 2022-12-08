package ui;

import login.LoginController;
import mealplan.MealplanController;
import profile.ProfileController;
import rank.RankController;
import recipe.RecipeController;
import review.ReviewController;
import search.SearchController;

public class AppController {
    private final RecipeController recipeController;
    private final LoginController loginController;
    private final ProfileController profileController;
    private final SearchController searchController;
    private final RankController rankController;
    private final MealplanController mealplanController;
    private final ReviewController reviewController;

    public AppController(RecipeController recipeController, LoginController loginController, ProfileController profileController,
                         MealplanController mealplanController,
                         SearchController searchController, RankController rankController, ReviewController reviewController) {
        this.recipeController = recipeController;
        this.loginController = loginController;
        this.profileController = profileController;
        this.mealplanController = mealplanController;
        this.searchController = searchController;
        this.rankController = rankController;
        this.reviewController = reviewController;
    }

    public RecipeController getRecipeController() {
        return recipeController;
    }

    public LoginController getLoginControllor() {
        return loginController;
    }

    public ProfileController getProfileController() {
        return profileController;
    }

    public RankController getRankController() {
        return rankController;
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
