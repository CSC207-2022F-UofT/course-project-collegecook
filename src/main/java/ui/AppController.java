package ui;

import login.UserController;
import mealplan.MealplanController;
import profile.ProfileController;
import rank.RankController;
import recipe.RecipeController;
import review.ReviewController;
import search.SearchController;

public class AppController {
    private final RecipeController recipeController;
    private final UserController userController;
    private final ProfileController profileController;
    private final SearchController searchController;
    private final RankController rankController;
    private final MealplanController mealplanController;
    private final ReviewController reviewController;

    public AppController(RecipeController recipeController, UserController userController, ProfileController profileController,
                         MealplanController mealplanController,
                         SearchController searchController, RankController rankController, ReviewController reviewController) {
        this.recipeController = recipeController;
        this.userController = userController;
        this.profileController = profileController;
        this.mealplanController = mealplanController;
        this.searchController = searchController;
        this.rankController = rankController;
        this.reviewController = reviewController;
    }

    public RecipeController getRecipeController() {
        return recipeController;
    }

    public UserController getLoginControllor() {
        return userController;
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
