package mealplan;

import java.util.List;

public interface MealplanOutputBoundary {
    public void createCaloriesView(List<Integer> cal);

    public void setUI (MealplanBox mealplanbox);
}