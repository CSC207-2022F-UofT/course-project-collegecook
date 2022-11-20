package sort;

import entities.Recipe;

import java.util.ArrayList;

public class SortRequestModel {
    ArrayList<Recipe> recipesToBeSorted;
    String sortType;
    boolean sortByAscending;

    public SortRequestModel(ArrayList<Recipe> recipesToBeSorted, String sortType, boolean sortByAscending){
        this.recipesToBeSorted = recipesToBeSorted;
        this.sortType = sortType;
        this.sortByAscending = sortByAscending;
    }

    public void setRecipesToBeSorted(ArrayList<Recipe> recipesToBeSorted) {
        this.recipesToBeSorted = recipesToBeSorted;
    }

    public ArrayList<Recipe> getRecipesToBeSorted() {
        return recipesToBeSorted;
    }
    public void setSortType(String sortType) {
        this.sortType = sortType;
    }

    public String getSortType() {
        return sortType;
    }

    public boolean isSortByAscending() {
        return sortByAscending;
    }

    public void setSortByAscending(boolean sortByAscending) {
        this.sortByAscending = sortByAscending;
    }
}
