package review;

import entities.*;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import recipe.RecipeReadWriter;

import java.io.IOException;
import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

class UpdateAverageRatingTest {

    ReviewDatabaseReadWriter reviewReadWriter;
    ReviewDatabase currentReviews;
    ReviewInteractor interactor;

    RecipeList temp;
    RecipeReadWriter recipeReadWriter;

    AverageRatingReadWriter readWriter;

    AverageRatings current;

    @BeforeEach
    void setUp() throws IOException, ClassNotFoundException {
        reviewReadWriter = ReviewDatabaseReadWriter.getReviewRepo();
        currentReviews = reviewReadWriter.readFromFile("reviews.sav");
        ReviewDatabase empty = new ReviewDatabase();
        reviewReadWriter.saveToFile("reviews.sav", empty);

        recipeReadWriter = RecipeReadWriter.getRecipeRepo();
        temp = recipeReadWriter.getRecipeList();
        RecipeList list = recipeReadWriter.getRecipeList();
        ArrayList<String> ingredients = new ArrayList<>();
        ingredients.add("pasta");
        ingredients.add("sauce");
        list.addRecipe("spaghetti", "Just cook it",
                "italy", ingredients, 500, 10, 3, "Ben");
        recipeReadWriter.saveRecipe(list);

        interactor = new ReviewInteractor();

        readWriter = new AverageRatingReadWriter();
        current = readWriter.readFromFile("ratings.sav");
        AverageRatings ratingsList = new AverageRatings();
        ratingsList.addAverageRating("Ben", 3.0);
        readWriter.saveToFile("ratings.sav", ratingsList);
    }

    @AfterEach
    void tearDown() throws IOException {
        reviewReadWriter.saveToFile("reviews.sav", currentReviews);
        recipeReadWriter.saveRecipe(temp);
        readWriter.saveToFile("ratings.sav", current);
        reviewReadWriter = null;
        currentReviews = null;
        interactor = null;
        recipeReadWriter = null;
        temp = null;
        readWriter = null;
        current = null;
    }

    @Test
    void TestloadRatingDatabase() {

        Double actual = UpdateAverageRating.loadRatingDatabase().getAverageRating("Ben");
        Double expected = 3.0;
        assertEquals(actual, expected);
    }

    @Test
    void TestupdateAverage() throws IOException, ClassNotFoundException {
        ArrayList<String> ingredients = new ArrayList<>();
        ingredients.add("onion");
        Recipe recipe2 = new Recipe("quarter of an onion", "quarter an onion", "italy",
                ingredients, 100, 10, 5, "Ben");
        Review review2 = new Review("bob", recipe2, "I like onions", 4);
        ReviewDatabase database = new ReviewDatabase();
        database.addReview(ReviewSimpleFactory.createReview());
        database.addReview(review2);
        UpdateAverageRating.updateAverage("bob", database);
        AverageRatings averageRatings = readWriter.readFromFile("ratings.sav");
        Double actual = averageRatings.getAverageRating("bob");
        Double expected = 2.5;
        assertEquals(expected, actual);

    }

}