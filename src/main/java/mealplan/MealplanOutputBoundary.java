package mealplan;

import java.util.List;

public interface MealplanOutputBoundary {
    void createCaloriesView(List<Integer> cal);

    void setUI (MealplanBox mealplanbox);
}