package mealplan;

import entities.*;
import profile.ProfileInteractor;
import recipe.*;

import java.io.IOException;
import profile.*;
public class MealplanController {
    MealplanInputBoundary mealplanInputBoundary;
    ProfileInputBoundary profileInputBoundary;
    RecipeInputBoundary recipeInputBoundary;
    public MealplanController(MealplanInputBoundary mealplanInputBoundary, ProfileInputBoundary profileInputBoundary,
                              RecipeInterActor recipeInputBoundary) {
        this.mealplanInputBoundary=mealplanInputBoundary;
        this.profileInputBoundary = profileInputBoundary;
        this.recipeInputBoundary = recipeInputBoundary;
    }


    public void getCalories() throws IOException {
        Profile profile = profileInputBoundary.check_profile(mealplanInputBoundary.getUsername());
        RecipeList recipeList = recipeInputBoundary.getAll();
        mealplanInputBoundary.computeCalories(profile, recipeList);
    }

    public void addMealplan(String recipe, int meal){
        mealplanInputBoundary.addMealplan(recipe, meal);
    }

    public void displayRecipe(String recipe){
        recipeInputBoundary.readRecipe(recipe);
    }

    public void deleteMealplan(int meal){
        mealplanInputBoundary.deleteMealplan(meal);
    }

    public void saveMealplan() throws IOException {
        mealplanInputBoundary.saveMealplan();
    }

}
