package recipe;

public interface RecipeOutputBoundary {
    void createSuccessView();
    void createFailureView();
    void readSuccessView(String result);
    void readFailureView();
}
