package recipe;

import java.util.ArrayList;


public class RecipeController {

    RecipeInputBoundary recipeInputBoundary;

    public RecipeController(RecipeInputBoundary recipeInputBoundary) {
        this.recipeInputBoundary = recipeInputBoundary;
    }


    public void performCreateRecipe(String recipe_name, String procedure, String cuisine, ArrayList<String> ingredients,
                                    int calories, int time, int difficulty, String creator) {
        RecipeRequestModel recipeRequestModel = new RecipeRequestModel(recipe_name, procedure, cuisine,
                ingredients, calories, time, difficulty, creator);
        recipeInputBoundary.createRecipe(recipeRequestModel);
    }

    public void performReadRecipe(String recipeName) {
        recipeInputBoundary.readRecipe(recipeName);
    }




}