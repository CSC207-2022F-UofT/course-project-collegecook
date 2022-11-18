package sort;

import entities.Recipe;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;

public class SortPresenter {

    public void showSortedRecipes(){
//        ArrayList<Recipe> recipes = new ArrayList<>();
        String sortType = "averageRating";
        System.out.println("These were the sorted recipes:" + SortUseCase.sortRecipesBySortType(recipes, sortType));
    }
}
