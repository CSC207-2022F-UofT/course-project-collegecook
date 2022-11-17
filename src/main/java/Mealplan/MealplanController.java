package Mealplan;

import Entities.*;
import Recipe.*;

import java.io.IOException;

public class MealplanController {
    MealplanInputBoundary mealplanInputBoundary;
    public MealplanController(MealplanInputBoundary mealplanInputBoundary) {
        this.mealplanInputBoundary=mealplanInputBoundary;
    }


    public void getCalories(){
        mealplanInputBoundary.computeCalories();
    }

    public void addMealplan(Recipe r, int meal, RecipeInteractor recipeInteractor){
        mealplanInputBoundary.addMealplan(r, meal, recipeInteractor);
    }

    public void deleteMealplan(int meal){
        mealplanInputBoundary.deleteMealplan(meal);
    }

    public void saveMealplan() throws IOException {
        mealplanInputBoundary.saveMealplan();
    }

}
