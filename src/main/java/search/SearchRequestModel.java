package search;

import java.util.ArrayList;

public class SearchRequestModel {
    private final String name;
    private String cuisine;
    private ArrayList<String> ingredients;
    private int timeInMin;
    private String sortType;

    private boolean sortByAscending;

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

    public String getCuisine() {
        return cuisine;
    }

    public ArrayList<String> getIngredients() {
        return ingredients;
    }

    public int getTimeInMin() {
        return timeInMin;
    }

    public String getSortType() {
        return sortType;
    }

    public boolean isSortByAscending() {
        return sortByAscending;
    }
}
