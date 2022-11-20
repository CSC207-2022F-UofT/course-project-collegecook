package entities;

import java.util.ArrayList;
import java.util.Objects;

public class ReviewDatabase {

    private boolean loaded = false;
    private static ArrayList<Review> reviews = new ArrayList<Review>();

    /**
     * Add the given review to the database.
     *
     * @param review the review to be added
     */
    public static void addReview(Review review) {
        reviews.add(review);
    }

    /**
     * Get all the Reviews made by the specified user
     *
     * @param username the username of the user who made the reviews to be fetched
     */

    public static ArrayList<Review> getUserReviews(String username) {
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

    public static ArrayList<Review> getRecipeReviews(Recipe recipe) {
        ArrayList<Review> answer = new ArrayList<>();
        for (Review review : reviews) {
            if (review.getRecipe().equals(recipe)) {
                answer.add(review);
            }
        }
        return answer;
    }
}