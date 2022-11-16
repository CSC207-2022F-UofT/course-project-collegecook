package Mealplan;

import java.util.List;

public interface MealplanOutputBoundary {
    public void createCaloriesView(List<Integer> cal);

    public void addRecipe(String recipe, int meal);
}
