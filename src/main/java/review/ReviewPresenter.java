package review;




public class ReviewPresenter implements ReviewOutputBoundary {

    ReviewCreateBox reviewCreateBox;

    ReviewViewBox reviewViewBox;

    @Override
    public void createReviewView() {
        reviewCreateBox.success();
    }

    @Override
    public void readSuccessView(String reviews) {
        if (reviews.equals("")) {
            reviewViewBox.noReviews();
        } else {
            reviewViewBox.success(reviews);
        }
    }

    @Override
    public void readFailureView() {
        reviewViewBox.fail();
    }

    @Override
    public void setUI(ReviewCreateBox reviewCreateBox) {
        this.reviewCreateBox = reviewCreateBox;
    }

    @Override
    public void setUI(ReviewViewBox reviewViewBox) {
        this.reviewViewBox = reviewViewBox;
    }

}