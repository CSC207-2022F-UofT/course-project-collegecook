package recipe;

import entities.Recipe;
import entities.RecipeList;

import java.io.IOException;


public class RecipeInteractor implements RecipeInputBoundary {
    /**
     * This is RecipeInteractor, which is in the Use Case layer.
     */
    private final RecipeRepoGateway rrg;
    private RecipeList recipeList;
    final RecipeOutputBoundary recipeOutputBoundary;
    private String readingRecipe = null;


    public RecipeInteractor(RecipeOutputBoundary recipeOutputBoundary, RecipeRepoGateway recipeRepoGateway) {
        this.recipeOutputBoundary = recipeOutputBoundary;
        this.rrg = recipeRepoGateway;
        try {
            recipeList = rrg.getRecipeList();
        } catch (IOException e) {
            recipeList = new RecipeList();
        }
    }

    /**
     *
     * @param recipeRequestModel
     */
    @Override
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
    @Override
    public void readRecipe(String recipeName){
        if (this.recipeList.contain(recipeName)){
            Recipe recipe = this.getRecipe(recipeName);
            this.readingRecipe = recipeName;
            recipeOutputBoundary.readSuccessView(recipe.toString());
        }else{
            recipeOutputBoundary.readFailureView();
        }
    }
    @Override
    public RecipeList getAll(){
        return this.recipeList;
    }

    @Override
     public Recipe getRecipe(String recipeName){
            return this.recipeList.get_recipe(recipeName);
        }
        @Override
        public String getReadingRecipe(){
        return this.readingRecipe;
        }


}




