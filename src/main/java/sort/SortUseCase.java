package sort;

import Entities.Recipe;

import java.util.ArrayList;
import java.util.List;

public class SortUseCase {

    public static List<Recipe> sortRecipesBySortType(List<Recipe> recipes, String sortType){
        ArrayList<Recipe> sortedRecipes = new ArrayList<>();
        for (Recipe recipe : recipes){
            System.out.println("hi");
        }
        return sortedRecipes;
    }
}
