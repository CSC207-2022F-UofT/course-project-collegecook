package mealplan;

import entities.Recipe;

import java.io.IOException;
import recipe.*;

public interface MealplanInputBoundary {
    void addMealplan(Recipe r, int meal,RecipeInterActor recipeInteractor);

    void computeCalories();

    void deleteMealplan(int meal);

    void saveMealplan() throws IOException;
}