package Mealplan;

import java.util.List;

public class MealplanPresenter implements MealplanOutputBoundary{
    @Override
    public void createCaloriesView(List<Integer> cal) {
        System.out.println("Recommended:" + cal.get(0) + "cal; " +
                "Total:" + cal.get(1));
    }

    @Override
    public void addRecipe(String recipe, int meal) {

    }


}
