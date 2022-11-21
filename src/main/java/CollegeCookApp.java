import login.*;
import recipe.*;
import ui.*;

public class CollegeCookApp {
    public static void main(String[] arg){
        UserGateWay userGateWay = UserRepoImpl.getUserRepoImpl();
        LoginOutputBound loginOutputBound = new LoginPresenter();
        UserManager userManager = new UserManager(loginOutputBound, userGateWay);
        LoginControllor loginControllor = new LoginControllor(userManager);

        RecipeOutputBoundary recipeOutputBoundary = new RecipePresenter();
        RecipeRepoGateway recipeRepoGateway = RecipeReadWriter.getRecipeRepo();
        RecipeInputBoundary recipeInputBoundary = new RecipeInteractor(recipeOutputBoundary, recipeRepoGateway);
        RecipeController recipeController = new RecipeController(recipeInputBoundary);

        AppController appController1 = new AppController(recipeController, loginControllor);
        RecipeCreateBox recipeCreateBox = new CreateRecipeUI(appController1);
        RecipeViewBox recipeViewBox = new ViewRecipeUI(appController1);
        WelcomeUI welcomeUI = new WelcomeUI(appController1);
        LoginBox loginBox = new LoginUI(appController1);
        SignUpBox signUpBox = new SignUpUI(appController1);
        loginOutputBound.setUI(loginBox);
        loginOutputBound.setUI(signUpBox);
        loginOutputBound.setUI(recipeViewBox);
        recipeOutputBoundary.setUI(recipeCreateBox);
        recipeOutputBoundary.setUI(recipeViewBox);
        welcomeUI.setVisible(true);
    }
}
