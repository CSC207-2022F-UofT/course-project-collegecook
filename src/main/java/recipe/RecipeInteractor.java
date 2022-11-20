package recipe;

import entities.Recipe;
import entities.RecipeList;

import java.io.IOException;


public class RecipeInteractor implements RecipeInputBoundary {
    private final RecipeRepoGateway rrg = RecipeRepoImpl.getRecipeRepoImpl();
    private RecipeList recipeList;
    final RecipeOutputBoundary recipeOutputBoundary;


    public RecipeInteractor(RecipeOutputBoundary recipeOutputBoundary) {
        this.recipeOutputBoundary = recipeOutputBoundary;

        try {
            recipeList = rrg.getRecipeList();
        } catch (IOException e) {
            recipeList = new RecipeList();
        }
    }


    public void createRecipe (RecipeRequestModel recipeRequestModel){
        if (recipeList.contain(recipeRequestModel.get_recipe_name())) {
            recipeOutputBoundary.createFailureView();
        }else {
            recipeList.add_recipe(recipeRequestModel.get_recipe_name(), recipeRequestModel.get_procedure(),
                    recipeRequestModel.get_cuisine(), recipeRequestModel.get_ingredients(),
                    recipeRequestModel.get_calories(), recipeRequestModel.get_time(),
                    recipeRequestModel.get_difficulty(), recipeRequestModel.get_creator());
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
            recipeOutputBoundary.readSuccessView(recipe.toString());
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




