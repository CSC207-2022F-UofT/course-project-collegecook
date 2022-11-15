package entities;

import java.util.HashMap;

public class AverageRatings {
    private static HashMap<User, Double> ratings = new HashMap<User, Double>();

    /**
     * Add the average rating of a User's reviews.
     * This method can also be used to update the average
     * rating of some User that already has an average rating
     *
     * @param user the User who's average rating is being added.
     * @param rating the average rating of user's reviews
     */
    public static void addAverageRating(User user, Double rating){
        ratings.put(user, rating);
    }

    /**
     * Get the average rating a User's reviews.
     * If the User doesn't have an average rating, returns -1.
     *
     * @param user the User who's average rating is being fetched.
     */
    public static Double getAverageRating(User user){
        if (ratings.containsKey(user)) {
            return ratings.get(user);
        } else {
            return Double.valueOf(-1);
        }
    }
}
