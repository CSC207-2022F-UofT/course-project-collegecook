package recipe;

import entities.Recipe;
import entities.RecipeList;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import ui.AppController;
import ui.CreateRecipeUI;
import ui.ViewRecipeUI;

import java.io.IOException;
import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

class RecipeInteractorTest {
    RecipeInteractor recipeInteractor;
    RecipeRepoGateway recipeRepoGateway;
    RecipeList temp;
    @BeforeEach
    void setUp() throws IOException {
        RecipeOutputBoundary recipeOutputBoundary= new RecipePresenter();
        recipeRepoGateway = RecipeReadWriter.getRecipeRepo();
        recipeInteractor = new RecipeInteractor(recipeOutputBoundary, recipeRepoGateway);
        RecipeController recipeController = new RecipeController(recipeInteractor);
        AppController appController = new AppController(recipeController);
        RecipeCreateBox createBox = new CreateRecipeUI(appController);
        recipeOutputBoundary.setUI(createBox);
        RecipeViewBox recipeViewBox = new ViewRecipeUI(appController);
        recipeOutputBoundary.setUI(recipeViewBox);
        temp = recipeRepoGateway.getRecipeList();
        ArrayList<String> ta = new ArrayList<>();
        RecipeRequestModel recipeRequestModel = new RecipeRequestModel("Test3", "Procedure",
                "cuisine", ta, 1, 2, 3, "Tester");
        recipeInteractor.createRecipe(recipeRequestModel);
    }

    @AfterEach
    void tearDown() throws IOException {
        recipeRepoGateway.saveRecipe(temp);
        recipeRepoGateway = null;
        recipeInteractor = null;
    }

    @Test
    void createRecipe() throws IOException {
        ArrayList<String> ta = new ArrayList<>();
        RecipeRequestModel recipeRequestModel = new RecipeRequestModel("Test4", "Procedure",
                "cuisine", ta, 1, 2, 3, "Tester");
        recipeInteractor.createRecipe(recipeRequestModel);
        assertTrue(recipeRepoGateway.getRecipeList().contain("Test2"));
    }

    @Test
    void readRecipe() {

    }

    @Test
    void getAll() {
        assertTrue(recipeInteractor.getAll().contain("Test3"));
        for (Recipe r : temp){
            assertTrue(recipeInteractor.getAll().contain(r.getRecipeName()));
        }
    }

    @Test
    void getRecipe() {
        Recipe actual = recipeInteractor.getRecipe("Test3");
        ArrayList<String> ta = new ArrayList<>();
        Recipe expected = new Recipe("Test3", "Procedure",
                "cuisine", ta, 1, 2, 3, "Tester");
        assertEquals(expected, actual);

    }
}