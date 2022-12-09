package profile;

/**
 * This RecipeOutputBoundary is created to follow the clean architecture.
 * ProfilePresenter should implement this interface.
 */
public interface ProfileOutputBoundary {

    /**
     * A method that passes the result of allReviewed from the interactor to the presenter,
     * This method can only be called If the user reviewed some recipes.
     * @param result A string of all reviewed recipes.
     */
    void viewReviewed(String result);

    /**
     * A method that passes the result of allReviewed from the interactor to presenter,
     * This method can only be called If the user doesn't review any recipe.
     */
    void noReviewed();

    /**
     * A method that passes the result of allCreated from the interactor to presenter,
     * This method can only be called If the user created some recipes.
     * @param result A string of all created recipes.
     */
    void viewCreated(String result);

    /**
     * A method that passes the result of allCreated from the interactor to presenter,
     * This method can only be called If the user doesn't create any recipe.
     */
    void noCreated();

    /**
     * A method that will be called in the presenter if a user sets up his/her information
     * in the profile.
     */
    void setInfoResult();

    /**
     * A method that will be called in the presenter if a user previously set up his/her information,
     * and needs to view the information.
     *
     */
    void viewInfo(String result);

    /**
     * Set up a ProfileBox interface.
     * @param profileReviewBox A ProfileReviewBox interface.
     */
    void setUI(ProfileReviewBox profileReviewBox);

    /**
     * Set up a ProfileBox interface.
     * @param profileCreateBox A ProfileCreateBox interface.
     */
    void setUI(ProfileCreateBox profileCreateBox);

    /**
     * Set up a InfoSetBox interface.
     * @param infoSetBox A InfoSetBox interface.
     */
    void setUI(InfoSetBox infoSetBox);

    /**
     * Set up a InfoViewBox interface.
     * @param infoViewBox A InfoViewBox interface.
     */
    void setUI(InfoViewBox infoViewBox);
}
