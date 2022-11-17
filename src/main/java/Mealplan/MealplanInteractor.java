package Mealplan;
import Entities.*;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import Recipe.*;

public class MealplanInteractor implements MealplanInputBoundary{
    String filePath = "C:\\Users\\lucia\\Desktop";
    private Mealplan mealplan;
    private User user;
    private MealplanGateway rrg;
    private MealplanList mealplans;
    final MealplanOutputBoundary mealplanout;

    public MealplanInteractor(MealplanOutputBoundary mealplanout, User user, MealplanGateway rrg){
        this.mealplanout = mealplanout;
        this.user = user;
        this.rrg = rrg;

        try {
            mealplans= rrg.readFromFile(filePath);
        } catch (IOException | ClassNotFoundException e) {
            mealplans = new MealplanList();
            System.out.println("Readfile failed.....");
        }

        try {
            this.mealplan = mealplans.getMealplan("user");
        } catch (Exception e) {
            this.mealplan = new Mealplan();
            System.out.println("New Meal-plan created");
        }
    }


    public void addMealplan(Recipe r, int meal, RecipeInteractor recipeInteractor){
        this.mealplan.addMealPlan(r, meal);
        mealplanout.addRecipe(r.get_recipe_name(), meal, recipeInteractor);
    }

    public void computeCalories(){
        List<Integer> Calories = new ArrayList<Integer>();
        Calories.add(UserCalories.getUserCalories(user));
        Calories.add(this.mealplan.computeTotalCalories());
        mealplanout.createCaloriesView(Calories);
    }

    public void deleteMealplan(int meal){
        this.mealplan.deleteMealPlan(meal);
    }

    public void saveMealplan() throws IOException {
        mealplans.add(user, mealplan);
        rrg.saveToFile(filePath,mealplans);
    }

}
