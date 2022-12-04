package review;

public class ReviewPresenter implements ReviewOutputBoundary {

    void CreateReviewView();

    void readSuccessView(String reviews);

    void readFailureView();

    void setUI(ReviewCreateBox reviewCreateBox);

    void setUI(ReviewViewBox reviewViewBox);

}
