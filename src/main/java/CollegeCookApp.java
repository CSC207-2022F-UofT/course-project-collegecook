import login.*;
import mealplan.*;
import profile.*;
import rank.*;
import recipe.*;
import review.*;
import search.*;
import ui.*;

public class CollegeCookApp {
    public static void main(String[] arg){
        // Interface adapter layer setup
        // login use case setup
        
        UserGateWay userGateWay = UserRepoImpl.getUserRepoImpl();
        UserOutputBound userOutputBound = new UserPresenter();
        UserInputBound userInputBound = new UserManager(userOutputBound, userGateWay);
        UserController userController = new UserController(userInputBound);

        // recipe use case setup
        RecipeOutputBoundary recipeOutputBoundary = new RecipePresenter();
        RecipeRepoGateway recipeRepoGateway = RecipeReadWriter.getRecipeRepo();
        RecipeInputBoundary recipeInputBoundary = new RecipeInteractor(recipeOutputBoundary, recipeRepoGateway);
        RecipeController recipeController = new RecipeController(recipeInputBoundary);

        // profile use case setup
        ProfileOutputBoundary profileOutputBoundary = new ProfilePresenter();
        ProfileInputBoundary profileInputBoundary = new ProfileInteractor(profileOutputBoundary);
        ProfileController profileController = new ProfileController(profileInputBoundary);

        // search & sort use case setup
        SearchOutputBoundary searchOutputBoundary = new SearchPresenter();
        SearchInputBoundary searchInputBoundary = new SearchInteractor(searchOutputBoundary, recipeRepoGateway);
        SearchController searchController = new SearchController(searchInputBoundary);

        // rank use case setup
        RankOutputBoundary rankOutputBoundary = new RankPresenter();
        RankInputBoundary rankInputBoundary = new RankInteractor(rankOutputBoundary);
        RankController rankController = new RankController(rankInputBoundary);

        // review use case setup
        ReviewOutputBoundary reviewOutputBoundary = new ReviewPresenter();
        ReviewDatabaseReadWriter reviewDatabaseReadWriter = ReviewDatabaseReadWriter.getReviewRepo();
        ReviewInputBoundary reviewInputBoundary = new ReviewInteractor(reviewOutputBoundary, reviewDatabaseReadWriter);
        ReviewController reviewController = new ReviewController(reviewInputBoundary);

        // UI
        
        MealplanOutputBoundary mealplanOutputBoundary= new MealplanPresenter();
        MealplanGateway mrg = MealplanGate.getInstance();
        MealplanInputBoundary mealplanInputBoundary = new MealplanInteractor(mealplanOutputBoundary, userController.preformGetLoggedInUser(),mrg);
        MealplanController mealplanController = new MealplanController(mealplanInputBoundary,profileInputBoundary,recipeInputBoundary);

        AppController appController1 = new AppController(recipeController, userController,
                profileController, mealplanController, searchController, rankController, reviewController);

        // UI
        RecipeCreateBox recipeCreateBox = new CreateRecipeUI(appController1);
        RecipeViewBox recipeViewBox = new ViewRecipeUI(appController1);
        WelcomeUI welcomeUI = new WelcomeUI(appController1);
        UserSignInBox userSignInBox = new UserUI(appController1);
        SignUpBox signUpBox = new SignUpUI(appController1);
        ProfileCreateBox profileCreateBox = new ProfileCreatedUI(appController1);
        ProfileReviewBox profileReviewBox = new ProfileReviewUI(appController1);
        InfoSetBox infoSetBox = new ProfileInfoUI(appController1);
        InfoViewBox infoViewBox = new ProfileUI(appController1);
        SearchResultsBox searchResultsBox = new SearchSortRecipesResultsUI(appController1);
        RankResultBox rankResultBox = new RankingUI(appController1);
        ReviewCreateBox reviewCreateBox = new CreateReviewUI(appController1);
        ReviewViewBox reviewViewBox = new ViewReviewUI(appController1);

        // set corresponding view
        MealplanBox mealplanBox = new MealplanBoxUI(appController1);
        userOutputBound.setUI(userSignInBox);
        userOutputBound.setUI(signUpBox);
        userOutputBound.setUI(recipeViewBox);
        recipeOutputBoundary.setUI(recipeCreateBox);
        recipeOutputBoundary.setUI(recipeViewBox);
        profileOutputBoundary.setUI(profileCreateBox);
        profileOutputBoundary.setUI(profileReviewBox);
        profileOutputBoundary.setUI(infoSetBox);
        profileOutputBoundary.setUI(infoViewBox);
        rankOutputBoundary.setUI(rankResultBox);
        reviewOutputBoundary.setUI(reviewCreateBox);
        reviewOutputBoundary.setUI(reviewViewBox);
        mealplanOutputBoundary.setUI(mealplanBox);
        searchOutputBoundary.setUI(searchResultsBox);

        welcomeUI.setVisible(true);
    }
}
