package review;


public class ReviewController {

    ReviewInputBoundary reviewInputBoundary;

    /**
     * Constructs a new ReviewController
     * @param reviewInputBoundary An interface to get access of the ReviewInteractor.
     */

    public ReviewController(ReviewInputBoundary reviewInputBoundary) {
        this.reviewInputBoundary = reviewInputBoundary;
    }


    /**
     * Requests a ReviewInteractor class to create a new review,
     * with the given username, recipe name and rating (must
     * be between 1 and 5, inclusive).
     *
     * @param username the username of the User that created this review
     * @param recipeName the name of the recipe being reviewed
     * @param rating the review's rating.
     */

    public void performCreateReview(String username, String recipeName, int rating) {
        reviewInputBoundary.createReview(username, recipeName, rating);
    }

    /**
     * Requests a ReviewInteractor class to create a new review,
     * with the given username, recipe name, content and rating (must
     * be between 1 and 5, inclusive).
     *
     * @param username the username of the User that created this review
     * @param recipeName the name of the recipe being reviewed
     * @param content the content of the review
     * @param rating the review's rating.
     */


    public void performCreateReview(String username, String recipeName, String content, int rating) {
        reviewInputBoundary.createReview(username, recipeName, content, rating);
    }
}
