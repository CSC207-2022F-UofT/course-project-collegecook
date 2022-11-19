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
        String actual = r.get_procedure();
        assertEquals(expected, actual);
    }


    @Test
    void get_recipe_name() {
        String expected = "name";
        String actual = r.get_recipe_name();
        assertEquals(expected, actual);
    }

    @Test
    void get_cuisine() {
        String expected = "cuisine";
        String actual = r.get_cuisine();
        assertEquals(expected, actual);
    }

    @Test
    void get_calories() {
        int expected = 1;
        int actual = r.get_calories();
        assertEquals(expected, actual);
    }

    @Test
    void get_time() {
        int expected = 2;
        int actual = r.get_time();
        assertEquals(expected, actual);
    }

    @Test
    void get_difficulty() {
        int expected = 3;
        int actual = r.get_difficulty();
        assertEquals(expected, actual);
    }

    @Test
    void get_ingredients() {
        ArrayList<String> expected = new ArrayList<>();
        expected.add("food");
        ArrayList<String> actual = r.get_ingredients();
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
        assertEquals(Objects.hash(r.get_recipe_name()), r.hashCode());
    }
}