package ui;

import recipe.RecipeController;

public class AppController {
    private final RecipeController recipeController;


    public AppController(RecipeController recipeController) {
        this.recipeController = recipeController;
    }

    public RecipeController getRecipeController() {
        return recipeController;
    }
}
