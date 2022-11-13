package Recipe;

import Entities.Recipe;
import Entities.RecipeList;

import java.io.IOException;
import java.util.List;
import java.util.Objects;
import java.util.Scanner;

public class RecipeInteractor {
    private RecipeRepoGateway srg = new RecipeRepoImpl();
    private RecipeList recipeList;


    public RecipeInteractor() {

        try {
            recipeList = srg.getRecipeList();
        } catch (IOException e) {
            recipeList = new RecipeList();
            System.out.println("Readfile failed.....");
        }
    }


    public void createRecipe (String recipe_name, String procedure, String cuisine, List<String> ingredients,
                              int calories, int time, int difficulty){
        Recipe recipe = new Recipe(recipe_name, procedure, cuisine, ingredients, calories, time, difficulty);
        recipeList.add_recipe(recipe);
        try {
            srg.saveRecipe(recipeList);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public String readRecipe(String recipeName){
        Recipe recipe = this.getRecipe(recipeName);
        String procedure = "Procedure: " + recipe.get_procedure() + "\n";
        String cuisine = "Cuisine: " + recipe.get_cuisine() + "\n";
        String ingredients = "Ingredients: " + recipe.get_ingredients().toString() + "\n";
        String calories = "Calories: " + recipe.get_calories() + "\n";
        String time = "Time Required: " + recipe.get_time() + " minutes \n";
        String difficulties = "Difficulty (out of 5): " + recipe.get_difficulty() + "\n";
        return procedure + cuisine + ingredients + calories + time + difficulties;

    }
     public Recipe getRecipe(String recipeName){
            return this.recipeList.get_recipe(recipeName);
        }

    public static void main(String[] args) {
        RecipeInteractor recipeInteractor = new RecipeInteractor();
        System.out.println(recipeInteractor.readRecipe("apple"));

    }
}




