package recipe;

import entities.Recipe;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

class RecipeControllerTest {
    RecipeController recipeController;
    RecipeInputBoundary recipeInputBoundary;

    @BeforeEach
    void setUp() {
        RecipeOutputBoundary recipeOutputBoundary = new RecipePresenter();
        recipeInputBoundary = new RecipeInterActor(recipeOutputBoundary);
        recipeController = new RecipeController(recipeInputBoundary);
    }

    @AfterEach
    void tearDown() {
        recipeController = null;
    }

    @Test
    void performCreateRecipe() {
        ArrayList<String> ingredients = new ArrayList<>();
        ingredients.add("food");
        recipeController.performCreateRecipe("createTest", "createTest", "createTest",
                ingredients, 1, 1, 1);
        Recipe expected = new Recipe("createTest", "createTest", "createTest",
                ingredients, 1, 1, 1);
        recipeInputBoundary.getRecipe("createTest");
    }

    @Test
    void performReadRecipe() {
    }
}