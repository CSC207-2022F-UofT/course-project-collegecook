package entities;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

class ProfileTest {
    /**
     * This test covers 100% profile class in the entity package,
     * 100% methods, and 100% lines.
     */

    Profile p;
    ArrayList<Recipe> created = new ArrayList<>();
    ArrayList<Review> reviewed = new ArrayList<>();

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
        p.setAge(20);
        p.setHeight(163);
        p.setWeight(45);
        p.setGender("Female");
    }

    @AfterEach
    void tearDown() {
        p = null;
    }

    @Test
    void testSoutReviewed() {
        String expected = "Reviewer: Allison" + System.lineSeparator() + "Recipe: name" + System.lineSeparator() +
                "Rating: 5/5" + System.lineSeparator() + "\"" + "Taste good!" + "\"" + "\n";
        String actual = p.soutReviewed();
        assertEquals(expected, actual);
    }

    @Test
    void testSoutCreated() {
        String expected = "Recipe: name\n"  +
                "Creator: Brenden\n" +
                "Procedure: procedure\n" +
                "Cuisine: cuisine\n" +
                "Ingredients: [food]\n" +
                "Calories: 1\n" +
                "Time Required: 2 minutes \n" +
                "Difficulty (out of 5): 3\n";
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

    @Test
    void testGetAge() {
        assertEquals(20, p.getAge());
    }

    @Test
    void testGetHeight() {
        assertEquals(163, p.getHeight());
    }
    @Test
    void testGetWeight() {
        assertEquals(45, p.getWeight());
    }
    @Test
    void testGetGender() {
        assertEquals("Female", p.getGender());
    }

    @Test
    void testGetUsername(){
        assertEquals("Brenden", p.getUsername());
    }

    @Test
    void testSoutInfo(){
        String expected = "Age: 20" + "\n" + "Height: " + 163.0 + "cm \n" + "Weight: " + 45.0 + "kg \n" +
                "Gender: Female" + "\n";
        assertEquals(expected, p.soutInfo());
    }

}