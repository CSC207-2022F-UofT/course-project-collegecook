package mealplan;
import entities.*;
import recipe.*;

import java.io.IOException;
import profile.*;
public class MealplanController {
    MealplanInputBoundary mealplanInputBoundary;
    ProfileInputBoundary profileInputBoundary;
    RecipeInputBoundary recipeInputBoundary;
    public MealplanController(MealplanInputBoundary mealplanInputBoundary, ProfileInputBoundary profileInputBoundary,
                              RecipeInputBoundary recipeInputBoundary) {
        this.mealplanInputBoundary = mealplanInputBoundary;
        this.profileInputBoundary = profileInputBoundary;
        this.recipeInputBoundary = recipeInputBoundary;
    }


    public void getCalories(String username){
        Profile profile;
        try {
            profile = profileInputBoundary.checkProfile(username);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        RecipeList recipeList = recipeInputBoundary.getAll();
        mealplanInputBoundary.computeCalories(profile, recipeList);
    }

    public void addMealplan(String recipe, int meal){

        mealplanInputBoundary.addRecipe(recipe, meal);
    }

    public void displayRecipe(String recipe){
        recipeInputBoundary.readRecipe(recipe);
    }

    public void deleteMealplan(int meal){
        mealplanInputBoundary.deleteMealplan(meal);
    }

    public void saveMealplan(){
        mealplanInputBoundary.saveMealplan();
    }


}
