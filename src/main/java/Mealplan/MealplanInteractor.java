package Mealplan;
import Entities.*;

import java.util.ArrayList;
import java.util.List;

public class MealplanInteractor {
    private Mealplan mealplan;

    public MealplanInteractor(){
        this.mealplan = new Mealplan();
    }

    public void addMealplan(Recipe r, int meal){
        this.mealplan.addMealPlan(r, meal);
    }

    public List<Integer>  computeCalories(){
        List<Integer> Calories = new ArrayList<Integer>();
        Calories.add(UserCalories.getUserCalories());
        Calories.add(this.mealplan.computeTotalCalories());
        return Calories;
    }

    public void deleteMealplan(int meal){
        this.mealplan.deleteMealPlan(meal);
    }


}
