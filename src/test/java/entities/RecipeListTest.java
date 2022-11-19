package entities;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Iterator;

import static org.junit.jupiter.api.Assertions.*;

class RecipeListTest {
    RecipeList rl;
    @BeforeEach
    void setUp() {
        rl = new RecipeList();
        ArrayList<String> ingredients = new ArrayList<>();
        rl.add_recipe("name", "procedure",
                "cuisine", ingredients, 1, 2, 3, "Brenden");
    }

    @AfterEach
    void tearDown() {
        rl = null;
    }

    @Test
    void add_recipe() {
        ArrayList<String> ingredients = new ArrayList<>();
        rl.add_recipe("name2", "procedure",
                "cuisine", ingredients, 1, 2, 3, "Brenden");
        Boolean actual = rl.contain("name2");
        assertTrue(actual);

    }

    @Test
    void get_recipe() {
        ArrayList<String> ingredients = new ArrayList<>();
        Recipe actual = rl.get_recipe("name");
        Recipe expected = new Recipe("name", "procedure",
                "cuisine", ingredients, 1, 2, 3, "Brenden");
        assertEquals(expected, actual);
    }

    @Test
    void contain() {
        Boolean expected = rl.contain("name");
        assertTrue(expected);
    }


    @Test
    void iterator() {
        ArrayList<String> ingredients = new ArrayList<>();
        assertTrue(rl.iterator().hasNext());
        Recipe actual = rl.iterator().next();
        Recipe expected = new Recipe("name", "procedure",
                "cuisine", ingredients, 1, 2, 3, "Brenden");
        assertEquals(expected, actual);
    }
}