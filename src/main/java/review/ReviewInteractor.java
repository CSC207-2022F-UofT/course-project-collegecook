package review;

import entities.*;
import recipe.RecipeRepoGateway;
import recipe.RecipeRepoImpl;

import java.io.IOException;

public class ReviewInteractor {

    private RecipeList recipeList;
    private ReviewDatabase reviewDatabase;


    /**
     * Construct a ReviewInteractor.
     */
    public ReviewInteractor() {
        try {
            RecipeRepoGateway rrg = new RecipeRepoImpl();
            recipeList = rrg.getRecipeList();
        } catch (IOException e) {
            recipeList = new RecipeList();
            System.out.println("Read file failed.....");
        }

        try {
            ReviewDatabaseReadWriter rdrw = new ReviewDatabaseReadWriter();
            reviewDatabase = rdrw.readFromFile("reviews.sav");
        } catch (IOException e) {
            reviewDatabase = new ReviewDatabase();
            System.out.println("Read file failed.....");
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
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
    public String createReview(String username, String recipeName, int rating) {
        Recipe recipe = recipeList.get_recipe(recipeName);
        Review review = new Review(username, recipe, rating);
        createHelper(username, review);
        return review.toString();
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
    public String createReview(String username, String recipeName, String content, int rating) {
        Recipe recipe = recipeList.get_recipe(recipeName);
        Review review = new Review(username, recipe, content, rating);
        createHelper(username, review);
        return review.toString();
    }

    private void createHelper(String username, Review review) {
        reviewDatabase.addReview(review);
        UpdateAverageRating.updateAverage(username, reviewDatabase);
    }
}
