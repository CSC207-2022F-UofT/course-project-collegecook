package entities;


import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import static org.junit.jupiter.api.Assertions.*;

class ReviewDatabaseTest {
    static ArrayList<Recipe> recipes = new ArrayList<>();
    static ArrayList<Review> reviews = new ArrayList<>();
    static ReviewDatabase database = new ReviewDatabase();

    @BeforeAll
    public static void setUp(){
        ArrayList<String> ingredients = new ArrayList<>();
        ingredients.add("pasta");
        ingredients.add("sauce");
        ingredients.add("meatball");
        Recipe recipe1 = new Recipe("spaghetti", "Just cook it",
                "italy", ingredients, 500, 10, 3, "Ben");
        recipes.add(recipe1);
        Review rev1 = new Review("bob", recipe1, "tasted terrible", 1);
        reviews.add(rev1);
        Recipe recipe2 = new Recipe( "spaghetti with meatballs",
                "put meatballs in spaghetti", "italy",
                ingredients, 700, 20, 4, "Ben");
        recipes.add(recipe2);
        Review rev2 = new Review( "Robert", recipe2, "tasted pretty good", 3);
        Review rev3 = new Review( "Robert", recipe1, "best thing I've ever eaten", 5);
        reviews.add(rev2);
        reviews.add(rev3);
        ArrayList<String> ingredients2 = new ArrayList<>();
        ingredients2.add("egg");
        ingredients2.add("cheese");
        ingredients2.add("butter");
        Recipe recipe3 = new Recipe("omelette", "put egg in pan", "America",
                ingredients2, 400, 5, 2, "Ben");
        recipes.add(recipe3);
        Review rev4 = new Review("Rob", recipe3, 5);
        reviews.add(rev4);
        Review rev5 = new Review ("Rob", recipe2, 4);
        reviews.add(rev5);
        database.addReview(rev1);
        database.addReview(rev2);
        database.addReview(rev3);
        database.addReview(rev4);
        database.addReview(rev5);
        }


    @Test
    public void TestGetUserReviews() {
        ArrayList<Review> expected1 = new ArrayList<>();
        expected1.add(reviews.get(0));
        ArrayList<Review> actual1 = database.getUserReviews("bob");
        assertEquals(expected1, actual1);

        ArrayList<Review> expected2 = new ArrayList<>();
        expected2.add(reviews.get(1));
        expected2.add(reviews.get(2));
        ArrayList<Review> actual2 = database.getUserReviews("Robert");
        assertEquals(expected2, actual2);

        ArrayList<Review> expected3 = new ArrayList<>();
        expected3.add(reviews.get(3));
        expected3.add(reviews.get(4));
        ArrayList<Review> actual3 = database.getUserReviews("Rob");
        assertEquals(expected3, actual3);

    }

    @Test
    public void TestGetRecipeReviews() {
        ArrayList<Review> expected1 = new ArrayList<>();
        expected1.add(reviews.get(0));
        expected1.add(reviews.get(2));
        ArrayList<Review> actual1 = database.getRecipeReviews(recipes.get(0));
        assertEquals(expected1, actual1);

        ArrayList<Review> expected2 = new ArrayList<>();
        expected2.add(reviews.get(1));
        expected2.add(reviews.get(4));
        ArrayList<Review> actual2 = database.getRecipeReviews(recipes.get(1));
        assertEquals(expected2, actual2);

        ArrayList<Review> expected3 = new ArrayList<>();
        expected3.add(reviews.get(3));
        ArrayList<Review> actual3 = database.getRecipeReviews(recipes.get(2));
        assertEquals(expected3, actual3);

    }


}