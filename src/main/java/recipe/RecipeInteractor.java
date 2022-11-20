package recipe;

import entities.Recipe;
import entities.RecipeList;

import java.io.IOException;


public class RecipeInteractor implements RecipeInputBoundary {
<<<<<<< HEAD:src/main/java/recipe/RecipeInteractor.java
    private final RecipeRepoGateway rrg = RecipeRepoImpl.getRecipeRepoImpl();
=======
    private final RecipeRepoGateway rrg;
>>>>>>> view-recipes-3:src/main/java/recipe/RecipeInterActor.java
    private RecipeList recipeList;
    final RecipeOutputBoundary recipeOutputBoundary;


<<<<<<< HEAD:src/main/java/recipe/RecipeInteractor.java
    public RecipeInteractor(RecipeOutputBoundary recipeOutputBoundary) {
=======
    public RecipeInteractor(RecipeOutputBoundary recipeOutputBoundary, RecipeRepoGateway recipeRepoGateway) {
>>>>>>> view-recipes-3:src/main/java/recipe/RecipeInterActor.java
        this.recipeOutputBoundary = recipeOutputBoundary;
        this.rrg = recipeRepoGateway;
        try {
            recipeList = rrg.getRecipeList();
        } catch (IOException e) {
            recipeList = new RecipeList();
        }
    }


    public void createRecipe (RecipeRequestModel recipeRequestModel){
        if (recipeList.contain(recipeRequestModel.getRecipeName())) {
            recipeOutputBoundary.createFailureView();
        }else {
            recipeList.add_recipe(recipeRequestModel.getRecipeName(), recipeRequestModel.getProcedure(),
                    recipeRequestModel.getCuisine(), recipeRequestModel.getIngredients(),
                    recipeRequestModel.getCalories(), recipeRequestModel.getTime(),
                    recipeRequestModel.getDifficulty(), recipeRequestModel.getCreator());
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




