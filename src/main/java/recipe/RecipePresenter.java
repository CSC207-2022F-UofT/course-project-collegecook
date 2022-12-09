package recipe;

public class RecipePresenter implements RecipeOutputBoundary{
    /**
     * This is RecipePresenter, which is in the presenter layer.
     */
    RecipeCreateBox recipeCreateBox;
    RecipeViewBox recipeViewBox;

    /**
     * Present the success view of creating a recipe.
     */
    @Override
    public void createSuccessView() {
        recipeCreateBox.success();
    }

    /**
     * Present the failure view of creating a recipe.
     */
    @Override
    public void createFailureView() {
        recipeCreateBox.fail();
    }

    /**
     * Present all the information of the recipe.
     * @param result All the information the reading recipe.
     */
    @Override
    public void readSuccessView(String result) {
        recipeViewBox.success(result);
    }

    /**
     * Present the failure view of reading a recipe
     */
    @Override
    public void readFailureView(){
        recipeViewBox.failure();
    }

    /**
     * Connect the presenter to the view model.
     * @param recipeCreateBox A view model of CreateRecipeUI.
     */
    @Override
    public void setUI(RecipeCreateBox recipeCreateBox){
        this.recipeCreateBox = recipeCreateBox;
    }

    /**
     * Connect the presenter to the view model.
     * @param recipeViewBox A view model of ViewRecipeUI.
     */
    @Override
    public void setUI(RecipeViewBox recipeViewBox){this.recipeViewBox = recipeViewBox;}


}
