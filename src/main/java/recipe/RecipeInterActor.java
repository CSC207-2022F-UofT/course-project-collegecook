package recipe;

import entities.Recipe;
import entities.RecipeList;

import java.io.IOException;
import java.util.ArrayList;


public class RecipeInterActor implements RecipeInputBoundary {
    private final RecipeRepoGateway rrg = new RecipeRepoImpl();
    private RecipeList recipeList;
    final RecipeOutputBoundary recipeOutputBoundary;


    public RecipeInterActor(RecipeOutputBoundary recipeOutputBoundary) {
        this.recipeOutputBoundary = recipeOutputBoundary;

        try {
            recipeList = rrg.getRecipeList();
        } catch (IOException e) {
            recipeList = new RecipeList();
            System.out.println("Read file failed.....");
        }
    }


    public void createRecipe (String recipe_name, String procedure, String cuisine, ArrayList<String> ingredients,
                              int calories, int time, int difficulty){
        if (recipeList.contain(recipe_name)) {
            recipeOutputBoundary.createFailureView();
        }else {
            recipeList.add_recipe(recipe_name, procedure, cuisine, ingredients, calories, time, difficulty);
            try {
                rrg.saveRecipe(recipeList);
                recipeOutputBoundary.createSuccessView();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    public void readRecipe(String recipeName){
        if (this.recipeList.contain(recipeName)){
            Recipe recipe = this.getRecipe(recipeName);
            String name = "Recipe: " + recipe.get_recipe_name() + "\n";
            String procedure = "Procedure: " + recipe.get_procedure() + "\n";
            String cuisine = "Cuisine: " + recipe.get_cuisine() + "\n";
            String ingredients = "Ingredients: " + recipe.get_ingredients().toString() + "\n";
            String calories = "Calories: " + recipe.get_calories() + "\n";
            String time = "Time Required: " + recipe.get_time() + " minutes \n";
            String difficulties = "Difficulty (out of 5): " + recipe.get_difficulty() + "\n";
            String result = name + procedure + cuisine + ingredients + calories + time + difficulties;
            recipeOutputBoundary.readSuccessView(result);
        }else{
            recipeOutputBoundary.readFailureView();
        }
    }

    public RecipeList getAll(){
        return this.recipeList;
    }
     public Recipe getRecipe(String recipeName){
            return this.recipeList.get_recipe(recipeName);
        }


}




