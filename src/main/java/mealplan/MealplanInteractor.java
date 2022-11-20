package mealplan;
import entities.*;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;


public class MealplanInteractor implements MealplanInputBoundary{
    private Mealplan mealplan;
    private String username;
    private MealplanGateway mrg;
    private MealplanList mealplans;
    final MealplanOutputBoundary mealplanout;

    public MealplanInteractor(MealplanOutputBoundary mealplanout, String username, MealplanGateway mrg){
        this.mealplanout = mealplanout;
        this.username = username;
        this.mrg = mrg;

        try {
            mealplans= mrg.readFromFile();
        } catch (IOException | ClassNotFoundException e) {
            mealplans = new MealplanList();

        }

        try {
            this.mealplan = mealplans.getMealplan(username);
        } catch (Exception e) {
            this.mealplan = new Mealplan();
            System.out.println("New Meal-plan created");
        }
    }


    public void addMealplan(String recipe, int meal){
        this.mealplan.addMealPlan(recipe, meal);
        mealplanout.addRecipe(recipe, meal);
    }

    public void computeCalories(Profile pro, RecipeList recipeList){
        int required_cal;
        int cal = 0;
        List<Integer> Calories = new ArrayList<Integer>();
        float weight = pro.getWeight();
        float height = pro.getHeight();
        String gender = pro.getGender();
        int age = pro.getAge();


        if (Objects.equals(gender, "male")){
            required_cal = (int) (9.99 * weight + 6.25 * height  - 4.92 * age + 5);
        }else{
            required_cal = (int) (9.99 * weight + 6.25 * height  - 4.92 * age - 161);
        }

        for (ArrayList<String> l : mealplan.returnMealPlan()){
            for (String r : l){
                cal = cal + recipeList.get_recipe(r).get_calories();
            }
        }

        Calories.add(required_cal);
        Calories.add(cal);
        mealplanout.createCaloriesView(Calories);
    }

    public void deleteMealplan(int meal){
        this.mealplan.deleteMealPlan(meal);
    }

    public void saveMealplan() throws IOException {
        mealplans.add(username, mealplan);
        mrg.saveToFile(mealplans);
    }

    public String getUsername() {
        return this.username;
    }

}
