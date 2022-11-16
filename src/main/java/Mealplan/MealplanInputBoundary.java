package Mealplan;

import Entities.Recipe;

import java.io.IOException;
import Recipe.*;

public interface MealplanInputBoundary {
    void addMealplan(Recipe r, int meal,RecipeController recipeController);

    void computeCalories();

    void deleteMealplan(int meal);

    void saveMealplan() throws IOException;
}
