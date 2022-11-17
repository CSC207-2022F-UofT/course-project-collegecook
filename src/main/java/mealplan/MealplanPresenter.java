package mealplan;

import recipe.RecipeInterActor;

import java.util.List;

public class MealplanPresenter implements MealplanOutputBoundary{
    private final MealplanBox UI;
    public MealplanPresenter(MealplanBox UI){
        this.UI = UI;
    }
    @Override
    public void createCaloriesView(List<Integer> cal) {
        System.out.println("Recommended:" + cal.get(0) + "cal; " +
                "Total:" + cal.get(1));
    }

    @Override
    public void addRecipe(String recipe, int meal, RecipeInterActor recipeInteractor) {
        UI.setMealplan(recipe, meal, recipeInteractor);
    }


}