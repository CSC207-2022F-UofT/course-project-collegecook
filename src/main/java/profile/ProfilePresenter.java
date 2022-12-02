package profile;

public class ProfilePresenter implements ProfileOutputBoundary{
    /**
     * This class connects the output boundary and three interface boxes that are for the UI layer.
     */
    ProfileBox profileBox;
    InfoViewBox infoViewBox;
    InfoSetBox infoSetBox;

    /**
     * A method that passes down the result and calls hasCreated method of the ProfileBox interface,
     * which will be implemented in the UI.
     * @param result A string of all created recipes of the user.
     */
    @Override
    public void viewCreated(String result) {
        profileBox.hasCreated(result);
    }

    /**
     * A method that calls noCreated method of the ProfileBox interface, which will implemented in the UI.
     * This method can only be called if the user contains no created recipes in the profile.
     */
    @Override
    public void noCreated() {
        profileBox.noCreated();
    }

    /**
     * A method that passes down the result and calls hasReviewed method of the ProfileBox interface,
     * which will be implemented in the UI.
     * @param result A string of all reviewed recipes of the user.
     */
    @Override
    public void viewReviewed(String result) {
        profileBox.hasReviewed(result);
    }

    /**
     * A method that calls noReviewed method of the ProfileBox interface, which will implemented in the UI.
     * This method can only be called if the user contains no reviewed recipes in the profile.
     */
    @Override
    public void noReviewed() {
        profileBox.noReviewed();
    }

    /**
     * A method that calls setInfoSuccess of the InfoSetBox interface when the user sets his/her information
     * in the profile.
     */
    @Override
    public void setInfoResult() {
        infoSetBox.setInfoSuccess();
    }

    /**
     * A method that passes down the result and calls viewInfoSuccess of the InfoViewBox interface, which
     * will be implemented in the UI.
     * @param result A string that contains all the information of the user.
     */
    @Override
    public void viewInfo(String result) {
        infoViewBox.viewInfoSuccess(result);
    }

    /**
     * Set up a ProfileBox interface, which will be implemented in the UI layer.
     * @param profileBox A InfoSetBox interface.
     */
    @Override
    public void setUI(ProfileBox profileBox) {
        this.profileBox = profileBox;
    }

    /**
     * Set up a InfoSetBox interface, which will be implemented in the UI layer.
     * @param infoSetBox A InfoSetBox interface.
     */
    @Override
    public void setUI(InfoSetBox infoSetBox) {
        this.infoSetBox = infoSetBox;
    }

    /**
     * Set up a InfoViewBox interface, which will be implemented in the UI layer.
     * @param infoViewBox A InfoViewBox interface.
     */
    @Override
    public void setUI(InfoViewBox infoViewBox) {
        this.infoViewBox = infoViewBox;
    }

}
