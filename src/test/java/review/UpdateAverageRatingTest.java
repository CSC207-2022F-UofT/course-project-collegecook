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
        list.add_recipe("spaghetti", "Just cook it",
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
    void TestloadRatingDatabase() throws IOException {

        Double actual = UpdateAverageRating.loadRatingDatabase().getAverageRating("Ben");
        Double expected = 3.0;
        assertEquals(actual, expected);
    }

    @Test
    void TestupdateAverage() throws IOException, ClassNotFoundException {
        Recipe recipe = ReviewSimpleFactory.createReview().getRecipe();
        // review2 = new Review("Mike", recipe, 1, )
        ArrayList<Review> actual = reviewReadWriter.readFromFile("reviews.sav").getUserReviews("bob");
        Review review = ReviewSimpleFactory.createReview();
        assertTrue(actual.contains(review));

    }

}