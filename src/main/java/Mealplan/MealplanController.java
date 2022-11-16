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

    public void addMealplan(Recipe r, int meal, RecipeController recipeController){
        mealplanInputBoundary.addMealplan(r, meal, recipeController);
    }

    public void deleteMealplan(int meal){
        mealplanInputBoundary.deleteMealplan(meal);
    }

    public void saveMealplan() throws IOException {
        mealplanInputBoundary.saveMealplan();
    }

}
