package Entities;

import java.util.ArrayList;
import java.io.Serializable;

public class Mealplan implements Serializable{

    ArrayList<ArrayList<Recipe>> mealplan;

    public Mealplan(){
        this.mealplan = new ArrayList<>();
        int i = 0;
        while(i<3){
            mealplan.add(new ArrayList<Recipe>());
            i++;
        }
    }

    public void addMealPlan(Recipe r, int meal){
        mealplan.get(meal).add(r);

    }

    public void deleteMealPlan(int meal){

        mealplan.set(meal, new ArrayList<Recipe>());
    }

    public int computeTotalCalories(){
        int cal = 0;
        for (ArrayList<Recipe> l : mealplan){
            for (Recipe r : l){
                cal = cal + r.get_calories();
            }
        }
        return cal;
    }
}
