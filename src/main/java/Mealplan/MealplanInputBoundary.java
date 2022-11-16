package Mealplan;

import Entities.Recipe;

import java.io.IOException;
import java.util.List;

public interface MealplanInputBoundary {
    void addMealplan(Recipe r, int meal);

    void computeCalories();

    void deleteMealplan(int meal);

    void saveMealplan() throws IOException;
}
