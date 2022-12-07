package review;




public class ReviewPresenter implements ReviewOutputBoundary {

    ReviewCreateBox reviewCreateBox;

    ReviewViewBox reviewViewBox;

    /**
     * Requests the reviewCreateBox to display that the review was
     * successfully created.
     *
     */
    @Override
    public void createReviewView() {
        reviewCreateBox.success();
    }

    /**
     * Requests the reviewCreateBox to display the given
     * string of reviews to the user.
     *
     * @param reviews a string containing the reviews to be displayed.
     *
     */
    @Override
    public void readSuccessView(String reviews) {
        if (reviews.equals("")) {
            reviewViewBox.noReviews();
        } else {
            reviewViewBox.success(reviews);
        }
    }
    /**
     * Requests the reviewCreateBox to display that the program was
     * unable to get the reviews for some recipe.
     *
     */
    @Override
    public void readFailureView() {
        reviewViewBox.fail();
    }

    /**
     * Sets the reviewCreateBox that this presenter gives
     * requests to relating to the creation of a review.
     *
     * @param reviewCreateBox the ReviewCreateBox that this presenter will give requests to.
     */
    @Override
    public void setUI(ReviewCreateBox reviewCreateBox) {
        this.reviewCreateBox = reviewCreateBox;
    }
    /**
     * Sets the reviewCreateBox that this presenter gives
     * requests to relating to the viewing of a recipe's reviews
     *
     * @param reviewViewBox the ReviewViewBox that this presenter will give requests to.
     */
    @Override
    public void setUI(ReviewViewBox reviewViewBox) {
        this.reviewViewBox = reviewViewBox;
    }

}
