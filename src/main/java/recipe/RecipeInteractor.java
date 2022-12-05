package recipe;

import entities.Recipe;
import entities.RecipeList;




public class RecipeInteractor implements RecipeInputBoundary {
    /**
     * This is RecipeInteractor, which is in the Use Case layer.
     */
    private final RecipeRepoGateway rrg;
    private final RecipeList recipeList;
    final RecipeOutputBoundary recipeOutputBoundary;
    private String readingRecipe = null;

    /**
     * Construct the RecipeInteractor
     * @param recipeOutputBoundary An interface of the presenter.
     * @param recipeRepoGateway An interface of the readWriter.
     */
    public RecipeInteractor(RecipeOutputBoundary recipeOutputBoundary, RecipeRepoGateway recipeRepoGateway) {
        this.recipeOutputBoundary = recipeOutputBoundary;
        this.rrg = recipeRepoGateway;
        recipeList = rrg.getRecipeList();

    }

    /**
     * Create a new recipe and store it in the database.
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
     * Call the presenter to read the recipe.
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
     * Get a RecipeList that includes all the
     * @return Return the recipeList that is stored in "recipe.sav"
     */
    @Override
    public RecipeList getAll(){
        return this.recipeList;
    }

    /**
     * Get the recipe according to the given name.
     * @param recipeName A String, which is a name of the recipe.
     * @return Return a recipe which has the recipeName
     */
    @Override
     public Recipe getRecipe(String recipeName){
            return this.recipeList.getRecipe(recipeName);
        }

    /**
     * Return all the information of the recipe.
     * @return The name of the recipe that the user is reading.
     */
    @Override
        public String getReadingRecipe(){
        return this.readingRecipe;
        }

    /**
     * Get the creator of the given recipe.
     * @param recipe The name of the recipe.
     * @return The creator of the recipe.
     */
    @Override
    public String getCreator(String recipe) {
        return this.recipeList.getRecipe(recipe).getCreator();
    }


}




