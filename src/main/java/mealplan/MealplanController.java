package mealplan;
import entities.*;
import recipe.*;

import java.io.IOException;
import java.util.ArrayList;

import profile.*;
public class MealplanController {
    MealplanInputBoundary mealplanInputBoundary;
    ProfileInputBoundary profileInputBoundary;
    RecipeInputBoundary recipeInputBoundary;

    /**
     * @param mealplanInputBoundary Mealplan use case interactor.
     * @param profileInputBoundary Profile use case interactor.
     * @param recipeInputBoundary Recipe use case interactor.
     */
    public MealplanController(MealplanInputBoundary mealplanInputBoundary, ProfileInputBoundary profileInputBoundary,
                              RecipeInputBoundary recipeInputBoundary) {
        this.mealplanInputBoundary = mealplanInputBoundary;
        this.profileInputBoundary = profileInputBoundary;
        this.recipeInputBoundary = recipeInputBoundary;
    }

    /**
     * Get the profile of the currently-logged in user using profile interactor. Calculate and pass the total calories
     * from the user's mealplan and the recommended calories based on profile to the presenter,which calls a method in
     * the UI to show the calories.
     * @param username the username of the currently logged-in user
     */

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

    public ArrayList<ArrayList<String>>  returnMealplan(){
        return mealplanInputBoundary.getMealplan().returnMealPlan();
    }


}
