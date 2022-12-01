package review;

import entities.Recipe;
import entities.RecipeList;
import entities.Review;
import entities.ReviewDatabase;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import recipe.RecipeReadWriter;

import java.io.IOException;
import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

class ReviewInteractorTest {

    ReviewDatabaseReadWriter readWriter;
    ReviewDatabase current;
    ReviewInteractor interactor;

    RecipeList temp;
    RecipeReadWriter recipeReadWriter;

    @BeforeEach
    void setUp() throws IOException, ClassNotFoundException {
        readWriter = ReviewDatabaseReadWriter.getReviewRepo();
        current = readWriter.readFromFile("reviews.sav");
        ReviewDatabase empty = new ReviewDatabase();
        readWriter.saveToFile("reviews.sav", empty);

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
    }

    @AfterEach
    void tearDown() throws IOException {
        readWriter.saveToFile("reviews.sav", current);
        recipeReadWriter.saveRecipe(temp);
        readWriter = null;
        current = null;
        interactor = null;
        recipeReadWriter = null;
        temp = null;
    }

    @Test
    void TestloadReviewDatabase() throws IOException {
        ReviewDatabase database = new ReviewDatabase();
        Review review = ReviewSimpleFactory.createReview();
        database.addReview(review);
        readWriter.saveToFile("reviews.sav", database);
        ArrayList<Review> actual = ReviewInteractor.loadReviewDatabase().getRecipeReviews(review.getRecipe());
        assertTrue(actual.contains(review));
    }

    @Test
    void TestcreateReview() throws IOException, ClassNotFoundException {
        interactor.createReview("bob", "spaghetti", "tasted terrible", 1);
        ArrayList<Review> actual = readWriter.readFromFile("reviews.sav").getUserReviews("bob");
        Review review = ReviewSimpleFactory.createReview();
        assertTrue(actual.contains(review));

    }

}