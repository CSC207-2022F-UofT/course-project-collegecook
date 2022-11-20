package entities;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class MealplanListTest {
    MealplanList mpl;
    Mealplan mp;
    @BeforeEach
    void setUp() {
        mpl = new MealplanList();
        mp = new Mealplan();
    }

    @Test
    void returnMealPlan() {
        mpl.add("user",mp);
        assertEquals(mpl.getMealplan("user"),mp);
    }

    @AfterEach
    void tearDown() {
        mp = null;
        mpl = null;
    }
}
