import login.*;
import mealplan.*;
import profile.*;
import recipe.*;
import search.*;
import ui.*;

import java.io.IOException;

public class CollegeCookApp {
    public static void main(String[] arg) throws IOException {
        // Interface adapter layer setup
        // login use case setup
        
        UserGateWay userGateWay = UserRepoImpl.getUserRepoImpl();
        LoginOutputBound loginOutputBound = new LoginPresenter();
        UserManager userManager = new UserManager(loginOutputBound, userGateWay);
        LoginControllor loginControllor = new LoginControllor(userManager);

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


        // UI

        MealplanOutputBoundary mealplanOutputBoundary= new MealplanPresenter();
        MealplanGateway mrg = MealplanGate.getInstance();
        MealplanInputBoundary mealplanInputBoundary = new MealplanInteractor(mealplanOutputBoundary,loginControllor.preformGetLoggedInUser(),mrg);
        MealplanController mealplanController = new MealplanController(mealplanInputBoundary,profileInputBoundary,recipeInputBoundary);

        AppController appController1 = new AppController(recipeController, loginControllor, profileController, mealplanController, searchController);

        RecipeCreateBox recipeCreateBox = new CreateRecipeUI(appController1);
        RecipeViewBox recipeViewBox = new ViewRecipeUI(appController1);
        WelcomeUI welcomeUI = new WelcomeUI(appController1);
        LoginBox loginBox = new LoginUI(appController1);
        SignUpBox signUpBox = new SignUpUI(appController1);
        ProfileBox profileBox = new ProfileRecipeUI(appController1);
        InfoSetBox infoSetBox = new ProfileInfoUI(appController1);
        InfoViewBox infoViewBox = new ProfileUI(appController1);

        // set corresponding view
        MealplanBox mealplanBox = new MealplanBoxUI(appController1);
        loginOutputBound.setUI(loginBox);
        loginOutputBound.setUI(signUpBox);
        loginOutputBound.setUI(recipeViewBox);
        recipeOutputBoundary.setUI(recipeCreateBox);
        recipeOutputBoundary.setUI(recipeViewBox);
        profileOutputBoundary.setUI(profileBox);
        profileOutputBoundary.setUI(infoSetBox);
        profileOutputBoundary.setUI(infoViewBox);

        ProfileUI profileUI = new ProfileUI(appController1);
        mealplanOutputBoundary.setUI(mealplanBox);
        welcomeUI.setVisible(true);
    }
}
