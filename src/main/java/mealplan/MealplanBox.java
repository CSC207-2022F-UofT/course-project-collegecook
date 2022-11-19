package mealplan;

import recipe.RecipeInterActor;

import java.util.List;


public interface MealplanBox {
    void setMealplan(String recipe, int meal, RecipeInterActor recipeInteractor);

    void setCalories(List<Integer> cal);
}