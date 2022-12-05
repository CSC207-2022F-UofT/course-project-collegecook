package recipe;

public interface RecipeViewBox {
    /**
     * This is a view model. ViewRecipeUI should implement this.
     */
    void success(String result);

    void failure();

    void followSuccess();

    void followFailure();

}
