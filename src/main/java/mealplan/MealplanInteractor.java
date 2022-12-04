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

    /**
     * Add a recipe to the user's mealplan, save/update the mealplan in mealplan list and save the mealplanlist via
     * gateway.
     * @param recipe recipe name
     * @param meal which meal the recipe is added to, 0 is breakfast, 1 is lunch, and 2 is dinner.
     */
    public void addRecipe(String recipe, int meal){
        mealplans.getMealplan(username).addMealPlan(recipe, meal);
        try {
            mealplans.add(username, mealplan);
            mrg.saveToFile(mealplans);
        } catch (IOException e) {
            System.out.println("Cannot save mealplan.");
        }
    }

    /**
     * Compute the total calories of all recipes in the user's mealplan
     * @param recipeList a list of all stored recipes.
     */
    public int computeRecipeCal(RecipeList recipeList){
        int cal = 0;
        if (mealplan == null){
            return 0;
        }
        for (ArrayList<String> l : mealplan.returnMealPlan()){
            for (String r : l){
                cal = cal + recipeList.get_recipe(r).getCalories();
            }
        }
        return cal;
    }

    /**
     * Compute the recommended calories intake based on information stored in user's profile.
     * @param pro the profile associated with the current user, containing information including gender, height, weight,
     * and age.
     */
    public int computeProfileCal(Profile pro){
        int required_cal;
        float weight = pro.getWeight();
        float height = pro.getHeight();
        String gender = pro.getGender();
        int age = pro.getAge();

        if (Objects.equals(gender, "Male")){
            required_cal = (int) (9.99 * weight + 6.25 * height  - 4.92 * age + 5);
        }else{
            required_cal = (int) (9.99 * weight + 6.25 * height  - 4.92 * age - 161);
        }
        return required_cal;
    }
    /**
     * Pass the total calories from the user's mealplan and the recommended calories based on profile to the presenter,
     * which calls a
     * @param pro the profile associated with the current user, containing information including gender, height, weight,
     * and age.
     * @param recipeList a list of all stored recipes.
     */
    public void computeCalories(Profile pro, RecipeList recipeList){
        List<Integer> Calories = new ArrayList<>();
        Calories.add(computeProfileCal(pro));
        Calories.add(computeRecipeCal(recipeList));
        if (mealplanout != null) {
            mealplanout.createCaloriesView(Calories);
        }
    }

    /**
     * Delete all recipe in the specified meal from user's mealplan.
     * @param meal which meal is being cleared of,  0 is breakfast, 1 is lunch, and 2 is dinner.
     */
    public void deleteMealplan(int meal){
        if(mealplan != null) {
            this.mealplan.deleteMealPlan(meal);
        }
    }

    /**
     * Save the current mealplan by adding the user and the mealplan to the hashmap mealplans. Then save the mealplans
     * through gateway.
     */
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



}
