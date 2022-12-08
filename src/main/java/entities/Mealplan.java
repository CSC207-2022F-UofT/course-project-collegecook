package entities;

import java.io.Serializable;
import java.util.ArrayList;

public class Mealplan implements Serializable {

    ArrayList<ArrayList<String>> mealplan;

    public Mealplan(){
        this.mealplan = new ArrayList<>();
        int i = 0;
        while(i<3){
            mealplan.add(new ArrayList<>());
            i++;
        }
    }
    /**
     * Add a recipe to the user's mealplan.
     * @param recipe recipe name
     * @param meal which meal the recipe is added to, 0 is breakfast, 1 is lunch, and 2 is dinner.
     */
    public void addMealPlan(String recipe, int meal){
        mealplan.get(meal).add(recipe);
    }

    /**
     * Delete all recipe in the specified meal.
     * @param meal which meal is being cleared of,  0 is breakfast, 1 is lunch, and 2 is dinner.
     */
    public void deleteMealPlan(int meal){
        mealplan.set(meal, new ArrayList<>());
    }

    public ArrayList<ArrayList<String>> returnMealPlan(){
        return this.mealplan;
    }

}
