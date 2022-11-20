package mealplan;

import java.util.List;


public interface MealplanBox {
    void setMealplan(String recipe, int meal);

    void setCalories(List<Integer> cal);
}