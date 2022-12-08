package profile;
/**
 * This is an interface between the view layer and the presenter layer. Related UI should implement this interface.
 */
public interface ProfileReviewBox {
    /**
     * Present the interface of noReviewed when the user doesn't review any recipe.
     */
    void noReviewed();

    /**
     * Present the interface of hasReviewed when the user has reviewed recipes.
     */
    void hasReviewed(String result);
}
