package mealplan;

import java.util.List;

public class MealplanPresenter implements MealplanOutputBoundary{
    private MealplanBox mealplanBox;

    /**
     * Calls a function in mealplan UI to display a dialog box showing the suggested calories and mealplan calories.
     * @param cal a list of length two, first is the suggested calories and second is the total mealplan calories.
     */
    @Override
    public void createCaloriesView(List<Integer> cal) {
         mealplanBox.setCalories(cal);
    }

    /**
     * @param mealplanbox the UI that this presenter updates
     */
    @Override
    public void setUI (MealplanBox mealplanbox) {
        this.mealplanBox=mealplanbox;
    }


}