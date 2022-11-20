package recipe;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

class RecipeRequestModelTest {
    RecipeRequestModel recipeRequestModel;
    @BeforeEach
    void setUp() {
        ArrayList<String> ingredients = new ArrayList<>();
        recipeRequestModel = new RecipeRequestModel("name", "procedure", "cuisine",
                ingredients, 1, 2, 3, "Creator");
    }

    @AfterEach
    void tearDown() {
        recipeRequestModel = null;
    }

    @Test
    void get_procedure() {
        assertEquals("name", recipeRequestModel.get_recipe_name());
    }

    @Test
    void get_recipe_name() {
        assertEquals("procedure", recipeRequestModel.get_procedure());
    }

    @Test
    void get_cuisine() {
        assertEquals("cuisine", recipeRequestModel.get_cuisine());
    }

    @Test
    void get_calories() {
        assertEquals(1, recipeRequestModel.get_calories());
    }

    @Test
    void get_time() {
        assertEquals(2, recipeRequestModel.get_time());
    }

    @Test
    void get_difficulty() {
        assertEquals(3, recipeRequestModel.get_difficulty());
    }

    @Test
    void get_ingredients() {
        ArrayList<String> test = new ArrayList<>();
        assertEquals(test, recipeRequestModel.get_ingredients());
    }

    @Test
    void get_creator() {
        assertEquals("Creator", recipeRequestModel.get_creator());
    }
}