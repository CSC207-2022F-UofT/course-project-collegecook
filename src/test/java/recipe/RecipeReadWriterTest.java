package recipe;

import entities.Recipe;
import entities.RecipeList;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

class RecipeReadWriterTest {
    RecipeReadWriter recipeReadWriter;
    RecipeList rl;
    RecipeList temp;
    @BeforeEach
    void setUp() throws IOException {
        recipeReadWriter = RecipeReadWriter.getRecipeRepo();
        temp = recipeReadWriter.getRecipeList();
        rl = recipeReadWriter.getRecipeList();
        ArrayList<String> ta = new ArrayList<>();
        Recipe test = new Recipe("Test", "Procedure",
                "cuisine", ta, 1, 2, 3, "Tester");
        rl.addRecipe("Test2", "Procedure",
                "cuisine", ta, 1, 2, 3, "Tester");
        recipeReadWriter.saveRecipe(rl);
    }
    @AfterEach
    void tearDown() throws IOException {
        recipeReadWriter.saveRecipe(temp);
        recipeReadWriter = null;
        rl = null;
        temp = null;

    }

    @Test
    void getRecipeRepo() {
        assertSame(recipeReadWriter, RecipeReadWriter.getRecipeRepo());

    }

    @Test
    void getRecipeList() throws IOException {
        assertTrue(recipeReadWriter.getRecipeList().contain("Test2"));
    }

    @Test
    void saveRecipe() throws IOException {
        ArrayList<String> ta = new ArrayList<>();
        rl.addRecipe("Test3", "Procedure",
                "cuisine", ta, 1, 2, 3, "Tester");
        recipeReadWriter.saveRecipe(rl);
        assertTrue(recipeReadWriter.getRecipeList().contain("Test3"));

    }

    @Test
    void getRecipeList2() throws IOException {
        FileOutputStream f2 = new FileOutputStream("recipe.sav");
        ObjectOutputStream outputStream = new ObjectOutputStream(f2);
        outputStream.writeObject("");
        f2.close();
        assertNotNull(recipeReadWriter.getRecipeList());
    }




}