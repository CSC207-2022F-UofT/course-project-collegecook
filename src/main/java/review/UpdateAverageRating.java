package review;

import entities.*;

import java.io.IOException;
import java.util.ArrayList;

public class UpdateAverageRating {

    /**
     * Update the average rating in class AverageRatings of the given user.
     * If the user has no reviews, throws an error
     * @param username the username of the User that created this review

     */

    public static void updateAverage(String username, ReviewDatabase database){
        ArrayList<Review> reviews = database.getUserReviews(username);
        AverageRatingReadWriter arrw = new AverageRatingReadWriter();
        AverageRatings averageRating = new AverageRatings();
        try {
            AverageRatingReadWriter rdrw = new AverageRatingReadWriter();
            averageRating = rdrw.readFromFile("ratings.sav");
        } catch (IOException e) {
            averageRating = new AverageRatings();
            System.out.println("Read file failed.....");
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
        if (reviews.size() != 0) {
            int sum = 0;
            for (Review r : reviews) {
                sum += r.getRating();
            }
            Double average = (double) sum / reviews.size();
            averageRating.addAverageRating(username, average);
            try {
                arrw.saveToFile("ratings.sav", averageRating);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
