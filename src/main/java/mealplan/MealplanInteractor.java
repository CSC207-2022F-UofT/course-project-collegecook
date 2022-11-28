package mealplan;
import entities.*;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;


public class MealplanInteractor implements MealplanInputBoundary{
    private Mealplan mealplan;
    private final String username;
    private final MealplanGateway mrg;
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
            System.out.println("Read file failed.....");
        }

        try {
            this.mealplan = mealplans.getMealplan(username);
        } catch (Exception e) {
            this.mealplan = new Mealplan();
            mealplans.add(username, mealplan);
            System.out.println("New Meal-plan created");
        }
        if (mealplan == null){
            this.mealplan = new Mealplan();
            mealplans.add(username, mealplan);
        }

    }


    public void addRecipe(String recipe, int meal){
        mealplans.getMealplan(username).addMealPlan(recipe, meal);
        try {
            mealplans.add(username, mealplan);
            mrg.saveToFile(mealplans);
        } catch (IOException e) {
            System.out.println("123");
        }
    }

    public int computeRecipeCal(RecipeList recipeList){
        int cal = 0;
        if (mealplan == null){
            return 0;
        }
        for (ArrayList<String> l : mealplan.returnMealPlan()){
            for (String r : l){
                cal = cal + recipeList.getRecipe(r).getCalories();
            }
        }
        return cal;
    }

    public int computeProfileCal(Profile pro){
        int required_cal;
        float weight = pro.getWeight();
        float height = pro.getHeight();
        String gender = pro.getGender();
        int age = pro.getAge();


        if (Objects.equals(gender, "male")){
            required_cal = (int) (9.99 * weight + 6.25 * height  - 4.92 * age + 5);
        }else{
            required_cal = (int) (9.99 * weight + 6.25 * height  - 4.92 * age - 161);
        }
        return required_cal;
    }

    public void computeCalories(Profile pro, RecipeList recipeList){
        List<Integer> Calories = new ArrayList<Integer>();
        Calories.add(computeProfileCal(pro));
        Calories.add(computeRecipeCal(recipeList));
        if (mealplanout != null) {
            mealplanout.createCaloriesView(Calories);
        }
    }

    public void deleteMealplan(int meal){
        if(mealplan != null) {
            this.mealplan.deleteMealPlan(meal);
        }
    }

    public void saveMealplan() throws IOException {
        mealplans.add(username, mealplan);
        mrg.saveToFile(mealplans);
    }

    public String getUsername() {
        return this.username;
    }

    public Mealplan getMealplan() {
        return this.mealplan;
    }

    public MealplanList getMealplanList() {
        return this.mealplans;
    }

    public static void main(String[] arg){
        MealplanOutputBoundary mealplanOutputBoundary = new MealplanPresenter();
        MealplanGateway mealplanGateway = new MealplanGate();
        MealplanInteractor mealplanInteractor = new MealplanInteractor(mealplanOutputBoundary, "Ben", mealplanGateway);
        mealplanInteractor.addRecipe("Apple", 1);
    }

}
