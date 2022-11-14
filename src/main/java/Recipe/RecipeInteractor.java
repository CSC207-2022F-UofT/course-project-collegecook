package Recipe;

import Entities.Recipe;
import Entities.RecipeList;

import java.io.IOException;
import java.util.List;


public class RecipeInteractor implements RecipeInputBoundry {
    private final RecipeRepoGateway rrg = new RecipeRepoImpl();
    private RecipeList recipeList;
    final RecipeOutputBoundry recipeOutputBoundry;


    public RecipeInteractor(RecipeOutputBoundry recipeOutputBoundry) {
        this.recipeOutputBoundry = recipeOutputBoundry;

        try {
            recipeList = rrg.getRecipeList();
        } catch (IOException e) {
            recipeList = new RecipeList();
            System.out.println("Readfile failed.....");
        }
    }


    public void createRecipe (String recipe_name, String procedure, String cuisine, List<String> ingredients,
                              int calories, int time, int difficulty){
        if (recipeList.contain(recipe_name)) {
            recipeOutputBoundry.createFailureView();
        }else {
            recipeList.add_recipe(recipe_name, procedure, cuisine, ingredients, calories, time, difficulty);
            try {
                rrg.saveRecipe(recipeList);
                recipeOutputBoundry.createSuccessView();
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
            recipeOutputBoundry.readSuccessView(result);
        }else{
            recipeOutputBoundry.readFailureView();
        }
    }

    public String getAll(){
        return this.recipeList.get_all_name();
    }
     public Recipe getRecipe(String recipeName){
            return this.recipeList.get_recipe(recipeName);
        }


}




