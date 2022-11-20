package recipe;

/**
 *This is an interface between the view layer and the presenter layer. Related UI should implement this interface.
 */
public interface RecipeCreateBox {
    /**
     * Present the interface of success in creating recipe.
     */
    void success();
    void fail();

    void setV(boolean vision);
}
