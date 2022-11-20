package recipe;

/**
 *This is an interface between the view layer and the presenter layer. Related UI should implement this interface.
 */
public interface RecipeCreateBox {
    /**
     * Present the interface of success in creating recipe.
     */
    void success();

    /**
     * Present the failure interface of creating a recipe
     */
    void fail();

    /**
     *
     * @param vision Whether to set the UI visible or not
     */
    void setV(boolean vision);
}
