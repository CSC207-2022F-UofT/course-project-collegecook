package mealplan;

import entities.*;

import java.io.IOException;

public interface MealplanInputBoundary {
    void addRecipe(String recipe, int meal);

    int computeRecipeCal(RecipeList recipeList);
    int computeProfileCal(Profile pro);
    void computeCalories(Profile pro, RecipeList recipeList);

    void deleteMealplan(int meal);

    void saveMealplan() throws IOException;

    String getUsername();

    Mealplan getMealplan();

    MealplanList getMealplanList();
}