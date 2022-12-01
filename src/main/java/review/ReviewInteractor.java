package review;

import entities.*;
import recipe.RecipeReadWriter;
import recipe.RecipeRepoGateway;

import java.io.IOException;

public class ReviewInteractor {

    private RecipeList recipeList;
    private ReviewDatabase reviewDatabase;
    private static final ReviewDatabaseReadWriter databaseReadWriter = ReviewDatabaseReadWriter.getRecipeRepo();


    /**
     * Construct a ReviewInteractor.
     */
    public ReviewInteractor() {
        try {

            RecipeRepoGateway rrg = RecipeReadWriter.getRecipeRepo();
            recipeList = rrg.getRecipeList();
        } catch (IOException e) {
            recipeList = new RecipeList();
            System.out.println("Read file failed.....");
        }
        this.reviewDatabase = loadReviewDatabase();
    }

    /**
     * Load a ReviewDatabase class from the serialized file.
     *
     */

    public static ReviewDatabase loadReviewDatabase() {
        ReviewDatabase database;
        try {
            database = databaseReadWriter.readFromFile("reviews.sav");
        } catch (IOException e) {
            database = new ReviewDatabase();
            System.out.println("Read reviews.sav failed.....");
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
        if (database == null) {
            database = new ReviewDatabase();
        }
        return database;
    }

    /**
     * Create a new review entity, with the
     * given username, recipe name, and rating.
     * The rating must be between 0 and 5, inclusive.
     *
     * @param username the username of the User that created this review
     * @param recipeName the name of the recipe being reviewed
     * @param rating the review's rating.
     */
    public void createReview(String username, String recipeName, int rating) {
        Recipe recipe = recipeList.get_recipe(recipeName);
        Review review = new Review(username, recipe, rating);
        createHelper(username, review);
    }

    /**
     * Create a new review entity, with the
     * given username, recipe name, content and rating.
     * The rating must be between 0 and 5, inclusive.
     *
     * @param username the username of the User that created this review
     * @param recipeName the name of the recipe being reviewed
     * @param content the content of the review
     * @param rating the review's rating.
     */
    public void createReview(String username, String recipeName, String content, int rating) {
        Recipe recipe = recipeList.get_recipe(recipeName);
        Review review = new Review(username, recipe, content, rating);
        createHelper(username, review);
    }

    private void createHelper(String username, Review review) {
        reviewDatabase.addReview(review);
        try {
            databaseReadWriter.saveToFile("reviews.sav", reviewDatabase);
        } catch (IOException e) {
            e.printStackTrace();
        }
        UpdateAverageRating.updateAverage(username, reviewDatabase);
    }
}
