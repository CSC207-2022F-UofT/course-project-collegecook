package mealplan;

import java.util.List;

public class MealplanPresenter implements MealplanOutputBoundary{
    private MealplanBox mealplanBox;

    @Override
    public void createCaloriesView(List<Integer> cal) {
         mealplanBox.setCalories(cal);
    }


    @Override
    public void setUI (MealplanBox mealplanbox) {
        this.mealplanBox=mealplanbox;
    }


}