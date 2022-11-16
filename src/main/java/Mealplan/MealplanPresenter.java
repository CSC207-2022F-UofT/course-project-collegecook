package Mealplan;

import Recipe.RecipeController;

import java.util.List;

public class MealplanPresenter implements MealplanOutputBoundary{
    private final MealplanBoxUI UI;
    public MealplanPresenter(MealplanBoxUI UI){
        this.UI = UI;
    }
    @Override
    public void createCaloriesView(List<Integer> cal) {
        System.out.println("Recommended:" + cal.get(0) + "cal; " +
                "Total:" + cal.get(1));
    }

    @Override
    public void addRecipe(String recipe, int meal, RecipeController recipeController) {
        UI.setMealplan(recipe, meal, recipeController);
    }


}
