package ui;

import login.LoginControllor;
import recipe.RecipeController;

public class AppController {
    private final RecipeController recipeController;
    private final LoginControllor loginControllor;

    public AppController(RecipeController recipeController, LoginControllor loginControllor) {
        this.recipeController = recipeController;
        this.loginControllor = loginControllor;
    }

    public RecipeController getRecipeController() {
        return recipeController;
    }

    public LoginControllor getLoginControllor() {
        return loginControllor;
    }
}
