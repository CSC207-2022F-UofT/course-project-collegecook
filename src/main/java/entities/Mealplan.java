package entities;

import java.util.ArrayList;

public class Mealplan {

    ArrayList<ArrayList<String>> mealplan;

    public Mealplan(){
        this.mealplan = new ArrayList<>();
        int i = 0;
        while(i<3){
            mealplan.add(new ArrayList<String>());
            i++;
        }
    }

    public void addMealPlan(String recipe, int meal){
        mealplan.get(meal).add(recipe);

    }

    public void deleteMealPlan(int meal){
        mealplan.set(meal, new ArrayList<String>());
    }

    public ArrayList<ArrayList<String>> returnMealPlan(){
        return this.mealplan;
    }

}
