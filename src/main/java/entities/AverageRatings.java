package entities;

import java.util.HashMap;

public class AverageRatings {
    private static HashMap<String, Double> ratings = new HashMap<String, Double>();

    /**
     * Add the average rating of a User's reviews.
     * This method can also be used to update the average
     * rating of some User that already has an average rating
     *
     * @param username the username of the User who's average rating is being added.
     * @param rating the average rating of user's reviews
     */
    public static void addAverageRating(String username, Double rating){
        ratings.put(username, rating);
    }

    /**
     * Get the average rating a User's reviews.
     * If the User doesn't have an average rating, returns -1.
     *
     * @param username the User who's average rating is being fetched.
     */
    public static Double getAverageRating(String username){
        if (ratings.containsKey(username)) {
            return ratings.get(username);
        } else {
            return (double) -1;
        }
    }

}
