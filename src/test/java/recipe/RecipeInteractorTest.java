package recipe;

import entities.RecipeList;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
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
        RecipeCreateBox createBox = new CreateRecipeUI(recipeController, recipeOutputBoundary);
        recipeOutputBoundary.setUI(createBox);
        RecipeViewBox recipeViewBox = new ViewRecipeUI();
        recipeOutputBoundary.setUI(recipeViewBox);
        temp = recipeRepoGateway.getRecipeList();
        ArrayList<String> ta = new ArrayList<>();
        RecipeRequestModel recipeRequestModel = new RecipeRequestModel("Test2", "Procedure",
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
        RecipeRequestModel recipeRequestModel = new RecipeRequestModel("Test2", "Procedure",
                "cuisine", ta, 1, 2, 3, "Tester");
        recipeInteractor.createRecipe(recipeRequestModel);
        assertTrue(recipeRepoGateway.getRecipeList().contain("Test2"));
    }

    @Test
    void readRecipe() {
    }

    @Test
    void getAll() {
    }

    @Test
    void getRecipe() {
    }
}