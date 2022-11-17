package Mealplan;

import Entities.Recipe;

import java.io.IOException;
import Recipe.*;

public interface MealplanInputBoundary {
    void addMealplan(Recipe r, int meal, RecipeInteractor recipeInteractor);

    void computeCalories();

    void deleteMealplan(int meal);

    void saveMealplan() throws IOException;
}
