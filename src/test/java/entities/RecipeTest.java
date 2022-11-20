package entities;


import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import static org.junit.jupiter.api.Assertions.*;

class RecipeTest {
    Recipe r;
    @BeforeEach
    void setUp() {
        ArrayList<String> ingredients = new ArrayList<>();
        ingredients.add("food");
        r = new Recipe("name", "procedure",
                "cuisine", ingredients, 1, 2, 3, "Brenden");
    }

    @AfterEach
    void tearDown() {
        r = null;
    }

    @Test
    void get_procedure() {
        String expected = "procedure";
        String actual = r.getProcedure();
        assertEquals(expected, actual);
    }


    @Test
    void get_recipe_name() {
        String expected = "name";
        String actual = r.getRecipeName();
        assertEquals(expected, actual);
    }

    @Test
    void get_cuisine() {
        String expected = "cuisine";
        String actual = r.getCuisine();
        assertEquals(expected, actual);
    }

    @Test
    void get_calories() {
        int expected = 1;
        int actual = r.getCalories();
        assertEquals(expected, actual);
    }

    @Test
    void get_time() {
        int expected = 2;
        int actual = r.getTime();
        assertEquals(expected, actual);
    }

    @Test
    void get_difficulty() {
        int expected = 3;
        int actual = r.getDifficulty();
        assertEquals(expected, actual);
    }

    @Test
    void get_ingredients() {
        ArrayList<String> expected = new ArrayList<>();
        expected.add("food");
        ArrayList<String> actual = r.getIngredients();
        assertArrayEquals(expected.toArray(), actual.toArray());
    }

    @Test
    void testEquals() {
        ArrayList<String> ingredients = new ArrayList<>();
        ingredients.add("foods");
        Recipe r2 = new Recipe("name", "procedure2",
                "cuisine2", ingredients, 2, 2, 4, "Brenden");
        assertEquals(r, r2);


    }

    @Test
    void testHashCode() {
        assertEquals(Objects.hash(r.getRecipeName()), r.hashCode());
    }

    @Test
    void get_creator() {
        assertEquals("Brenden", r.getCreator());
    }

    @Test
    void testToString() {
        String expected = "Recipe: name\n"  +
                "Creator: Brenden\n" +
                "Procedure: procedure\n" +
                "Cuisine: cuisine\n" +
                "Ingredients: [food]\n" +
                "Calories: 1\n" +
                "Time Required: 2 minutes \n" +
                "Difficulty (out of 5): 3\n";
        assertEquals(expected, r.toString());
    }
}