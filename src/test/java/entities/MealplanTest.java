package entities;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

public class MealplanTest {
    Mealplan mp;
    @BeforeEach
    void setUp() {
        mp = new Mealplan();
    }

    @Test
    void returnMealPlan() {
        assertEquals(3,mp.returnMealPlan().size());
    }

    @Test
    void addMealPlan() {
        ArrayList<String> ingredients = new ArrayList<>();
        Recipe recipe = new Recipe("name", "procedure",
                "cuisine", ingredients, 1, 2, 3,"creator");
        mp.addMealPlan("name",0);
        mp.addMealPlan("name",0);
        ArrayList<String> breakfast = new ArrayList<>();
        breakfast.add("name");
        breakfast.add("name");
        ArrayList<ArrayList<String>> expected = new ArrayList<>();
        expected.add(breakfast);
        expected.add(new ArrayList<>());
        expected.add(new ArrayList<>());
        assertEquals(mp.returnMealPlan(),expected);
    }
    @Test
    void deleteMealPlan() {
       mp.deleteMealPlan(0);
       ArrayList<ArrayList<String>> expected = new ArrayList<>();
       expected.add(new ArrayList<>());
       expected.add(new ArrayList<>());
       expected.add(new ArrayList<>());
       assertEquals(mp.returnMealPlan(),expected);
    }

    @AfterEach
    void tearDown() {
        mp = null;
    }
}
