package recipe;

import ui.CreateRecipeUI;
import ui.ViewRecipeUI;

public class RecipePresenter implements RecipeOutputBoundary{
    CreateRecipeUI createRecipeUI;
    ViewRecipeUI viewRecipeUI;

    public RecipePresenter(CreateRecipeUI createRecipeUI) {
        this.createRecipeUI = createRecipeUI;
    }

    public RecipePresenter(){}


    @Override
    public void createSuccessView() {
        createRecipeUI.success();
    }

    @Override
    public void createFailureView() {createRecipeUI.failure();}

    @Override
    public void readSuccessView(String result) {
        viewRecipeUI = new ViewRecipeUI(result);
    }

    @Override
    public void readFailureView() {
        System.out.println("Sorry, the recipe doesn't exist.");
    }
}
