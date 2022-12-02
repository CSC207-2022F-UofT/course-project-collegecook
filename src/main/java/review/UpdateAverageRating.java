package review;

import entities.*;
import recipe.RecipeInteractor;
import recipe.RecipeReadWriter;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Objects;

public class UpdateAverageRating {

    /**
     * Update the average rating in class AverageRatings of the given user.
     * If the user has no reviews, throws an error
     * @param username the username of the User that created this review

     */

    public static void updateAverage(String username, ReviewDatabase database){
        ArrayList<Review> reviews = getUserReviews(username, database);
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

    private static ArrayList<Review> getUserReviews(String username,  ReviewDatabase database) {
        RecipeList recipeList;
        RecipeReadWriter rrg = RecipeReadWriter.getRecipeRepo();
        ArrayList<Recipe> usersRecipe = new ArrayList<>();
        try {
            recipeList = rrg.getRecipeList();
        } catch (IOException e) {
            recipeList = new RecipeList();
        }
        for (Recipe r : recipeList) {
            if (username.equals(r.getCreator())) {
                usersRecipe.add(r);
            }
        }
        ArrayList<Review> answer = new ArrayList<>();
        for (Recipe r : usersRecipe) {
            answer.addAll(database.getRecipeReviews(r));
        }
        return answer;
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
        if (database == null) {
            database = new AverageRatings();
        }
        return database;
    }
}
