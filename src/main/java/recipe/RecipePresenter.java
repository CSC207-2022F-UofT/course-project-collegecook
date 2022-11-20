package recipe;

public class RecipePresenter implements RecipeOutputBoundary{
    RecipeCreateBox recipeCreateBox;
    RecipeViewBox recipeViewBox;

    @Override
    public void createSuccessView() {
        recipeCreateBox.success();
    }

    @Override
    public void createFailureView() {
        recipeCreateBox.fail();
    }

    @Override
    public void readSuccessView(String result) {
        recipeViewBox.success(result);
    }

    @Override
    public void readFailureView(){
        recipeViewBox.failure();
    }

    @Override
    public void setUI(RecipeCreateBox recipeCreateBox){
        this.recipeCreateBox = recipeCreateBox;
    }
    @Override
    public void setUI(RecipeViewBox recipeViewBox){this.recipeViewBox = recipeViewBox;}
}
