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

    /**
     *
     * @param recipeOutputBoundary An interface of the presenter.
     * @param recipeRepoGateway An interface of the readWriter.
     */
    public RecipeInteractor(RecipeOutputBoundary recipeOutputBoundary, RecipeRepoGateway recipeRepoGateway) {
        this.recipeOutputBoundary = recipeOutputBoundary;
        this.rrg = recipeRepoGateway;
        try {
            recipeList = rrg.getRecipeList();
        } catch (IOException e) {
            recipeList = new RecipeList();
        }

        if (recipeList == null){
            recipeList = new RecipeList();
        }
    }

    /**
     *
     * @param recipeRequestModel A requestModel which includes all the user input. They are packed up to avoid data
     *                           clump.
     */
    @Override
    public void createRecipe (RecipeRequestModel recipeRequestModel){
        if (recipeList.contain(recipeRequestModel.getRecipeName())) {
            recipeOutputBoundary.createFailureView();
        }else {
            recipeList.addRecipe(recipeRequestModel.getRecipeName(), recipeRequestModel.getProcedure(),
                    recipeRequestModel.getCuisine(), recipeRequestModel.getIngredients(),
                    recipeRequestModel.getCalories(), recipeRequestModel.getTime(),
                    recipeRequestModel.getDifficulty(), recipeRequestModel.getCreator());
            rrg.saveRecipe(recipeList);
            recipeOutputBoundary.createSuccessView();
        }
    }

    /**
     *
     * @param recipeName The name of the recipe that the user wants to read.
     */
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

    /**
     *
     * @return Return the recipeList that is stored in "recipe.sav"
     */
    @Override
    public RecipeList getAll(){
        return this.recipeList;
    }

    /**
     *
     * @param recipeName A String, which is a name of the recipe.
     * @return Return a recipe which has the recipeName
     */
    @Override
     public Recipe getRecipe(String recipeName){
            return this.recipeList.getRecipe(recipeName);
        }
        @Override
        public String getReadingRecipe(){
        return this.readingRecipe;
    }

    @Override
    public String getCreator(String recipe) {
        return this.recipeList.getRecipe(recipe).getCreator();
    }


}




