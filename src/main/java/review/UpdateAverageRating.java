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
        AverageRatingReadWriter ratingReadWriter = new AverageRatingReadWriter();
        AverageRatings averageRating = loadRatingDatabase();
        if (reviews.size() != 0) {
            int sum = 0;
            for (Review r : reviews) {
                sum += r.getRating();
            }
            Double average = (double) sum / reviews.size();
            averageRating.addAverageRating(username, average);
            try {
                ratingReadWriter.saveToFile("ratings.sav", averageRating);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    /**
     * Load an AverageRatings class from the serialized file.
     *
     */

    public static AverageRatings loadRatingDatabase() {
        AverageRatings database;
        AverageRatingReadWriter ratingReadWriter = new AverageRatingReadWriter();
        try {
            database = ratingReadWriter.readFromFile("ratings.sav");
        } catch (IOException e) {
            database = new AverageRatings();
            System.out.println("Read ratings.sav failed.....");
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
        return database;
    }
}
