package mealplan;

import recipe.RecipeInterActor;


import java.util.List;

public interface MealplanOutputBoundary {
    public void createCaloriesView(List<Integer> cal);

    public void addRecipe(String recipe, int meal, RecipeInterActor recipeInteractor);

    public void setUI (MealplanBox mealplanbox);
}