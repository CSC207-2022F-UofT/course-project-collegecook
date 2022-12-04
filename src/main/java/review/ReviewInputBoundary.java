package review;


public interface ReviewInputBoundary {

    void createReview(String username, String recipeName, int rating);

    void createReview(String username, String recipeName, String content, int rating);

    void readRecipeReviews(String recipeName);




}
