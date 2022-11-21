package mealplan;

import entities.Profile;
import entities.Recipe;

import java.io.IOException;

import entities.RecipeList;
import recipe.*;

public interface MealplanInputBoundary {
    void addMealplan(String recipe, int meal);

    void computeCalories(Profile pro, RecipeList recipeList);

    void deleteMealplan(int meal);

    void saveMealplan() throws IOException;

    String getUsername();
}