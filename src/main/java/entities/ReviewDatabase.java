package entities;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Objects;

public class ReviewDatabase implements Serializable {

    private static final long serialVersionUID = -8459197638434162084L;
    private ArrayList<Review> reviews = new ArrayList<>();

    /**
     * Add the given review to the database.
     *
     * @param review the review to be added
     */
    public void addReview(Review review) {
        reviews.add(review);
    }

    /**
     * Get all the Reviews made by the specified user
     *
     * @param username the username of the user who made the reviews to be fetched
     */

    public ArrayList<Review> getUserReviews(String username) {
        ArrayList<Review> answer = new ArrayList<>();
        for (Review review : reviews) {
            if (Objects.equals(review.getUser(), username)) {
                answer.add(review);
            }
        }
        return answer;
    }

    /**
     * Get all the Reviews made for the specified recipe
     *
     * @param recipe the recipe that the reviews are fetched from
     */

    public ArrayList<Review> getRecipeReviews(Recipe recipe) {
        ArrayList<Review> answer = new ArrayList<>();
        for (Review review : reviews) {
            if (review.getRecipe().equals(recipe)) {
                answer.add(review);
            }
        }
        return answer;
    }
}