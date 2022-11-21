package entities;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

class ProfileTest {
    Profile p;
    ArrayList<Recipe> created = new ArrayList<>();
    ArrayList<Review> reviewed;

    @BeforeEach
    void setUp() {
        ArrayList<String> ingredients = new ArrayList<>();
        ingredients.add("food");
        Recipe recipe = new Recipe("name", "procedure",
                "cuisine", ingredients, 1, 2, 3, "Brenden");
        created.add(recipe);
        Review review = new Review("Allison", recipe, "Taste good!", 5);
        reviewed.add(review);
        p = new Profile("Brenden");
        p.setCreated(created);
        p.setReviewed(reviewed);
    }

    @AfterEach
    void tearDown() {
        p = null;
    }

    @Test
    void testSoutReviewed() {
        String expected = "Reviewer: Allison" + "\n" + "Rating: 5/5" +
                "\n" + "Taste good!";
        String actual = p.soutReviewed();
        assertEquals(expected, actual);
    }

    @Test
    void testSoutCreated() {
        String expected = "Recipe: name" + "\n" +
                "Creator: Brenden" + "\n" +
                "Procedure: procedure" + "\n" +
                "Cuisine: cuisine" + "\n" +
                "Ingredients: food" + "\n" +
                "Calories: 1"+ "\n" +
                "Time Required: 2" + "\n" +
                "Difficulty (out of 5): 3" + "\n";
        String actual = p.soutCreated();
        assertEquals(expected, actual);
    }

    @Test
    void testGetReviewed(){
        assertEquals(reviewed, p.getReviewed());
    }

    @Test
    void testGetCreated(){
        assertEquals(created, p.getCreated());
    }

}