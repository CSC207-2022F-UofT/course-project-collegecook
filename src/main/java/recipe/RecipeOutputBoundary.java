package recipe;

public interface RecipeOutputBoundary {
    /**
     * This RecipeOutputBoundary is created to follow the clean architecture. RecipePresenter should implement this
     * interface.
     */
    void createSuccessView();
    void createFailureView();

    void readSuccessView(String result);
    void readFailureView();
    void setUI(RecipeCreateBox recipeCreateBox);

    void setUI(RecipeViewBox recipeViewBox);

}
