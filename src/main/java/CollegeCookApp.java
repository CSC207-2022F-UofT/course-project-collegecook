import login.*;
import profile.*;
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

        ProfileOutputBoundary profileOutputBoundary = new ProfilePresenter();
        ProfileInputBoundary profileInputBoundary = new ProfileInteractor(profileOutputBoundary);
        ProfileController profileController = new ProfileController(profileInputBoundary);

        AppController appController1 = new AppController(recipeController, loginControllor, profileController);
        RecipeCreateBox recipeCreateBox = new CreateRecipeUI(appController1);
        RecipeViewBox recipeViewBox = new ViewRecipeUI(appController1);
        WelcomeUI welcomeUI = new WelcomeUI(appController1);
        LoginBox loginBox = new LoginUI(appController1);
        SignUpBox signUpBox = new SignUpUI(appController1);
        ProfileBox profileBox = new ProfileViewRecipeUI(appController1);
        InfoSetBox infoSetBox = new ProfileInfoUI(appController1);
        InfoViewBox infoViewBox = new ProfileUI(appController1);
        loginOutputBound.setUI(loginBox);
        loginOutputBound.setUI(signUpBox);
        loginOutputBound.setUI(recipeViewBox);
        recipeOutputBoundary.setUI(recipeCreateBox);
        recipeOutputBoundary.setUI(recipeViewBox);
        profileOutputBoundary.setUI(profileBox);
        profileOutputBoundary.setUI(infoSetBox);
        profileOutputBoundary.setUI(infoViewBox);
        ProfileUI profileUI = new ProfileUI(appController1);
        welcomeUI.setVisible(true);
    }
}
