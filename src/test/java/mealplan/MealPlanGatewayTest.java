package mealplan;
import entities.Mealplan;
import entities.MealplanList;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import static org.junit.jupiter.api.Assertions.*;

public class MealPlanGatewayTest {
    MealplanGate mealplanGate;
    MealplanList mpl;
    MealplanList temp;
    Mealplan mp;

    @BeforeEach
    void setUp() throws IOException, ClassNotFoundException {
        mealplanGate = MealplanGate.getInstance();
        temp = mealplanGate.readFromFile();
        mpl = new MealplanList();
        mp = new Mealplan();
        mpl.add("user",mp);
        mealplanGate.saveToFile(mpl);
    }

    @AfterEach
    void tearDown() {
        mealplanGate.saveToFile(temp);
        mealplanGate = null;
        mpl = null;
        temp = null;

    }

    @Test
    void getRecipeGate() {
        assertSame(mealplanGate, MealplanGate.getInstance());
    }

    @Test
    void getMealplanList() throws IOException, ClassNotFoundException {
        assertEquals(mealplanGate.readFromFile().getMealplan("user").returnMealPlan(),mp.returnMealPlan());
    }

    @Test
    void SaveMealplanList() throws IOException, ClassNotFoundException {
        Mealplan mpTest = new Mealplan();
        mpl.add("user2",mpTest);
        mealplanGate.saveToFile(mpl);
        assertEquals(mealplanGate.readFromFile().getMealplan("user2").returnMealPlan(),mpTest.returnMealPlan());
    }

}
