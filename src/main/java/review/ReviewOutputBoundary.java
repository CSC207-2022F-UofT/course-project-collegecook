package review;

public interface ReviewOutputBoundary {

    void createReviewView();


    void readSuccessView(String reviews);

    void readFailureView();

    void setUI(ReviewCreateBox reviewCreateBox);

    void setUI(ReviewViewBox reviewViewBox);
}
