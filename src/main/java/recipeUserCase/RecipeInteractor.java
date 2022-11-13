package recipeUserCase;

import Entities.Recipe;
import Entities.RecipeList;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

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
        return this.recipeList.get_recipe(recipeName).get_procedure();
    }

    public Recipe getRecipe(String recipeName){
        return this.recipeList.get_recipe(recipeName);
    }



}
