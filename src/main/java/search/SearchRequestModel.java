package search;

import java.util.ArrayList;

public class SearchRequestModel {
    String name;
    String cuisine;
    ArrayList<String> ingredients;
    int timeInMin;
    String sortType;

    boolean sortByAscending;

    /**
     * Input data to search for matching recipes with
     * @param name keyword in recipe
     * @param cuisine type of cuisine
     * @param ingredients list of ingredients
     * @param timeInMin time it takes
     * @param sortType the way recipes are sorted by (i.e. average rating, number of reviews, time it takes)
     * @param sortByAscending sort by ascending or descending
     */
    public SearchRequestModel(String name, String cuisine, ArrayList<String> ingredients, int timeInMin, String sortType, boolean sortByAscending){
        this.name = name;
        this.cuisine = cuisine;
        this.ingredients = ingredients;
        this.timeInMin = timeInMin;
        this.sortType = sortType;
        this.sortByAscending = sortByAscending;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCuisine() {
        return cuisine;
    }

    public void setCuisine(String cuisine) {
        this.cuisine = cuisine;
    }

    public ArrayList<String> getIngredients() {
        return ingredients;
    }

    public void setIngredients(ArrayList<String> ingredients) {
        this.ingredients = ingredients;
    }

    public int getTimeInMin() {
        return timeInMin;
    }

    public void setTimeInMin(int timeInMin) {
        this.timeInMin = timeInMin;
    }

    public String getSortType() {
        return sortType;
    }

    public void setSortType(String sortType) {
        this.sortType = sortType;
    }

    public void setSortByAscending(boolean sortByAscending) {
        this.sortByAscending = sortByAscending;
    }

    public boolean isSortByAscending() {
        return sortByAscending;
    }
}
