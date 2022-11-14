package Recipe;

public interface RecipeOutputBoundry {
    void createSuccessView();
    void createFailureView();
    void readSuccessView(String result);
    void readFailureView();
}
