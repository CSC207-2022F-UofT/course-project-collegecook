package Mealplan;

import Entities.Recipe;

public class MealplanController {

    MealplanInteractor mealplaninteractor = new MealplanInteractor();

    public String getCalories(){
        String result;
        result = "Recommended:" + mealplaninteractor.computeCalories().get(0) + "cal; " +
        "Total:" + mealplaninteractor.computeCalories().get(1);
        return result;
    }

    public void addMealplan(Recipe r, int meal){
        mealplaninteractor.addMealplan(r, meal);
    }

    public void deleteMealplan(int meal){
        mealplaninteractor.deleteMealplan(meal);
    }
}
