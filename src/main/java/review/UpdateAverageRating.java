package review;

import entities.*;

import java.util.ArrayList;

public class UpdateAverageRating {

    /**
     * Update the average rating in class AverageRatings of the given user.
     * If the user has no reviews, throws an error
     * @param username the username of the User that created this review

     */

    public static void updateAverage(String username, ReviewDatabase database){
        ArrayList<Review> reviews = database.getUserReviews(username);
        if (reviews.size() != 0) {
            int sum = 0;
            for (Review r : reviews) {
                sum += r.getRating();
            }
            Double average = (double) sum / reviews.size();
            AverageRatings.addAverageRating(username, average);
        }
    }
}
