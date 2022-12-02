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

    RecipeRepoGateway recipeRepoGateway;
    RecipeList temp;
    String failName;
    @BeforeEach
    void setUp() throws IOException {
        recipeRepoGateway = RecipeReadWriter.getRecipeRepo();
        temp = recipeRepoGateway.getRecipeList();

    }

    @AfterEach
    void tearDown() throws IOException {
        recipeRepoGateway.saveRecipe(temp);
        recipeRepoGateway = null;

    }

    @Test
    void createRecipe(){
        RecipeOutputBoundary recipeOutputBoundary = new RecipeOutputBoundary() {
            @Override
            public void createSuccessView(){
                RecipeList recipeList = null;
                recipeList = recipeRepoGateway.getRecipeList();

                assertTrue(recipeList.contain("Test3"));
            }

            @Override
            public void createFailureView(){
                RecipeList recipeList = null;
                    recipeList = recipeRepoGateway.getRecipeList();

                assertTrue(recipeList.contain("Test3"));
            }

            @Override
            public void readSuccessView(String result) {
            }

            @Override
            public void readFailureView() {
            }

            @Override
            public void setUI(RecipeCreateBox recipeCreateBox) {

            }

            @Override
            public void setUI(RecipeViewBox recipeViewBox) {

            }
        };
        ArrayList<String> ta = new ArrayList<>();
        RecipeRequestModel recipeRequestModel = new RecipeRequestModel("Test3", "Procedure",
                "cuisine", ta, 1, 2, 3, "Tester");
        RecipeInteractor recipeInteractor = new RecipeInteractor(recipeOutputBoundary, recipeRepoGateway);
        recipeInteractor.createRecipe(recipeRequestModel);
        recipeInteractor.createRecipe(recipeRequestModel);

    }


    @Test
    void readRecipe() {
        RecipeOutputBoundary recipeOutputBoundary = new RecipeOutputBoundary() {
            @Override
            public void createSuccessView() {

            }

            @Override
            public void createFailureView() {

            }

            @Override
            public void readSuccessView(String result) {
                String expected = "Recipe: Test4" + "\n"  +
                        "Creator: Tester" + "\n" +
                        "Procedure: Procedure" + "\n" +
                        "Cuisine: cuisine" + "\n" +
                        "Ingredients: []" + "\n" +
                        "Calories: 1" + "\n" +
                        "Time Required: 2" + " minutes \n" +
                        "Difficulty (out of 5): 3" + "\n";
                assertEquals(expected, result);
            }

            @Override
            public void readFailureView() {

                    assertFalse(recipeRepoGateway.getRecipeList().contain(failName));

            }

            @Override
            public void setUI(RecipeCreateBox recipeCreateBox) {

            }

            @Override
            public void setUI(RecipeViewBox recipeViewBox) {

            }
        };
        ArrayList<String> ta = new ArrayList<>();
        RecipeRequestModel recipeRequestModel = new RecipeRequestModel("Test4", "Procedure",
                "cuisine", ta, 1, 2, 3, "Tester");
        RecipeInteractor recipeInteractor = new RecipeInteractor(recipeOutputBoundary, recipeRepoGateway);
        recipeInteractor.createRecipe(recipeRequestModel);
        recipeInteractor.readRecipe("Test4");
        failName = "Test5";
        recipeInteractor.readRecipe(failName);

    }

    @Test
    void getAll() {
        RecipeOutputBoundary recipeOutputBoundary = new RecipeOutputBoundary() {
            @Override
            public void createSuccessView() {

            }

            @Override
            public void createFailureView() {

            }

            @Override
            public void readSuccessView(String result) {

            }

            @Override
            public void readFailureView() {

            }

            @Override
            public void setUI(RecipeCreateBox recipeCreateBox) {

            }

            @Override
            public void setUI(RecipeViewBox recipeViewBox) {

            }
        };
        RecipeInteractor recipeInteractor = new RecipeInteractor(recipeOutputBoundary, recipeRepoGateway);
        for (Recipe r : recipeInteractor.getAll()){
            assertTrue(temp.contain(r.getRecipeName()));
        }

    }

    @Test
    void getRecipe() {
        RecipeOutputBoundary recipeOutputBoundary = new RecipeOutputBoundary() {
            @Override
            public void createSuccessView() {

            }

            @Override
            public void createFailureView() {

            }

            @Override
            public void readSuccessView(String result) {

            }

            @Override
            public void readFailureView() {

            }

            @Override
            public void setUI(RecipeCreateBox recipeCreateBox) {

            }

            @Override
            public void setUI(RecipeViewBox recipeViewBox) {

            }
        };
        RecipeInteractor recipeInteractor = new RecipeInteractor(recipeOutputBoundary, recipeRepoGateway);
        ArrayList<String> ta = new ArrayList<>();
        RecipeRequestModel recipeRequestModel = new RecipeRequestModel("Test3", "Procedure",
                "cuisine", ta, 1, 2, 3, "Tester");
        recipeInteractor.createRecipe(recipeRequestModel);
        recipeInteractor.readRecipe("Test3");
        assertEquals("Test3", recipeInteractor.getReadingRecipe());
    }

    @Test
    void getCreator() {
        RecipeOutputBoundary recipeOutputBoundary = new RecipeOutputBoundary() {
            @Override
            public void createSuccessView() {

            }

            @Override
            public void createFailureView() {

            }

            @Override
            public void readSuccessView(String result) {

            }

            @Override
            public void readFailureView() {

            }

            @Override
            public void setUI(RecipeCreateBox recipeCreateBox) {

            }

            @Override
            public void setUI(RecipeViewBox recipeViewBox) {

            }
        };
        RecipeInteractor recipeInteractor = new RecipeInteractor(recipeOutputBoundary, recipeRepoGateway);
        ArrayList<String> ta = new ArrayList<>();
        RecipeRequestModel recipeRequestModel = new RecipeRequestModel("Test3", "Procedure",
                "cuisine", ta, 1, 2, 3, "Tester");
        recipeInteractor.createRecipe(recipeRequestModel);
        assertEquals("Tester", recipeInteractor.getCreator("Test3"));
    }


}