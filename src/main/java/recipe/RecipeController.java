package recipe;

import entities.Recipe;

import java.util.ArrayList;


public class RecipeController {
    /**
     * This is RecipeController, a class in Controller layer.
     */

    RecipeInputBoundary recipeInputBoundary;

    /**
     *
     * @param recipeInputBoundary An interface to get access of the RecipeInteractor. It is injected here to follow
     *                            the Dependency Rule.
     */
    public RecipeController(RecipeInputBoundary recipeInputBoundary) {
        this.recipeInputBoundary = recipeInputBoundary;
    }

    /**
     *
     * @param recipe_name The name of the recipe.
     * @param procedure The procedure of the recipe
     * @param cuisine The cuisine type of the recipe
     * @param ingredients The ingredients required for the recipe.
     * @param calories The total calories of the recipe.
     * @param time The time required in making the cuisine.
     * @param difficulty The difficulty of making the cuisine.
     * @param creator The creator of the recipe
     *
     * This method is used to combine the input of uses into an RecipeRequestModel to avoid Data Clump, and pass it
     * to the recipeInputBoundary.
     */
    public void performCreateRecipe(String recipe_name, String procedure, String cuisine, ArrayList<String> ingredients,
                                    int calories, int time, int difficulty, String creator) {
        RecipeRequestModel recipeRequestModel = new RecipeRequestModel(recipe_name, procedure, cuisine,
                ingredients, calories, time, difficulty, creator);
        recipeInputBoundary.createRecipe(recipeRequestModel);
    }

    /**
     *
     * @param recipeName The name of the recipe that the user want to read
     * This method is used to read the recipe by passing the name got from the UI to the recipeInputBoundary
     */
    public void performReadRecipe(String recipeName) {
        recipeInputBoundary.readRecipe(recipeName);
    }

    public String getReadingRecipe(){return recipeInputBoundary.getReadingRecipe();}
    public Recipe getRecipe(String name){
        return recipeInputBoundary.getRecipe(name);
    }
    public String getCreator(String recipe){return recipeInputBoundary.getCreator(recipe);}



}