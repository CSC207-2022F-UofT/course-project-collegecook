package mealplan;

import recipe.RecipeInterActor;


public interface MealplanBox {
    void setMealplan(String recipe, int meal, RecipeInterActor recipeInteractor);
}