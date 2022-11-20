package mealplan;
import entities.Mealplan;
import entities.MealplanList;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.util.ArrayList;
import static org.junit.jupiter.api.Assertions.*;

public class MealPlanGatewayTest {
    MealplanGate mealplanGate;
    MealplanList mpl;
    Mealplan mp;

    @BeforeEach
    void setUp() throws IOException {
        mealplanGate = MealplanGate.getInstance();
        mpl = new MealplanList();
        mp = new Mealplan();

        mealplanGate.saveToFile(mpl);
    }


    @Test
    void getRecipeGate() {
        assertSame(mealplanGate, MealplanGate.getInstance());
    }

    @Test
    void getMealplanList() throws IOException, ClassNotFoundException {
        assertSame(mealplanGate.readFromFile().getMealplan("user"), mp);
    }

    @Test
    void SaveMealplanList() throws IOException, ClassNotFoundException {
        Mealplan mpTest = new Mealplan();
        mpl.add("user2",mpTest);
        mealplanGate.saveToFile(mpl);
        assertSame(mealplanGate.readFromFile().getMealplan("user2"), mpTest);
    }

    @Test
    void saveRecipe() throws IOException {
        ArrayList<String> ta = new ArrayList<>();
        rl.add_recipe("Test3", "Procedure",
                "cuisine", ta, 1, 2, 3, "Tester");
        recipeReadWriter.saveRecipe(rl);
        assertTrue(recipeReadWriter.getRecipeList().contain("Test3"));

    }
}