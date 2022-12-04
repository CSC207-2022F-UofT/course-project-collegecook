package review;

import java.util.ArrayList;

public interface ReviewOutputBoundary {

    void createReviewView();


    void readSuccessView(ArrayList<String> reviews);

    void readFailureView();

    void setUI(ReviewCreateBox reviewCreateBox);

    void setUI(ReviewViewBox reviewViewBox);
}
