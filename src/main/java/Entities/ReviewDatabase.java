package Entities;

import java.util.ArrayList;

public class ReviewDatabase {
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
     * @param user the user who made the reviews to be fetched
     */

    public static ArrayList<Review> getUserReviews(User user) {
        ArrayList<Review> answer = new ArrayList<>();
        for (Review review : reviews) {
            if (review.getUser().equals(user)) {
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