package sort;

import entities.Recipe;

import java.util.ArrayList;

public class SortResponseModel {
    ArrayList<Recipe> sortedRecipes;

    public SortResponseModel(ArrayList<Recipe> sortedRecipes){
        this.sortedRecipes = sortedRecipes;
    }

    public void setSortedRecipes(ArrayList<Recipe> sortedRecipes) {
        this.sortedRecipes = sortedRecipes;
    }

    public ArrayList<Recipe> getSortedRecipes() {
        return sortedRecipes;
    }
}
