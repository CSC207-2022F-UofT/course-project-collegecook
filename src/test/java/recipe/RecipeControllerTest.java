package recipe;

import entities.Recipe;
import entities.RecipeList;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

class RecipeControllerTest {
    RecipeController recipeController;
    @BeforeEach
    void setUp() {
        RecipeInputBoundary recipeInputBoundary = new RecipeInputBoundary(){
            @Override
            public void createRecipe(RecipeRequestModel recipeRequestModel) {
                assertTrue(true);
            }

            @Override
            public void readRecipe(String recipeName) {
                assertTrue(true);
            }

            @Override
            public RecipeList getAll() {
                return null;
            }

            @Override
            public Recipe getRecipe(String recipeName) {
                return null;
            }

            @Override
            public String getReadingRecipe() {
                return null;
            }

            @Override
            public String getCreator(String readRecipe) {
                return null;
            }
        };
        recipeController = new RecipeController(recipeInputBoundary);
    }

    @AfterEach
    void tearDown() {
    }

    @Test
    void performCreateRecipe() {
        ArrayList<String> ingredients = new ArrayList<>();
        recipeController.performCreateRecipe("Test", "procedure", "cuisine", ingredients,
                1, 2, 3, "Tester");
    }

    @Test
    void performReadRecipe() {
        recipeController.performReadRecipe("Test");
    }

    @Test
    void getReadingRecipe() {
        assertNull(recipeController.getReadingRecipe());
    }

    @Test
    void getRecipe() {
        assertNull(recipeController.getRecipe("Test"));
    }

    @Test
    void getCreator(){assertNull(recipeController.getCreator("Test"));}
}