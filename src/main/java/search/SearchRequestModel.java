package search;

import java.util.ArrayList;

public class SearchRequestModel {
    private final String name;
    private final String cuisine;
    private final ArrayList<String> ingredients;
    private final int timeInMin;
    private final String sortType;
    private final boolean sortByAscending;

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

    /**
     * Get the name/keyword of search criteria
     * @return name/keyword of search criteria
     */
    public String getName() {
        return name;
    }

    /**
     * Get cuisine of search criteria
     * @return cuisine of search criteria
     */
    public String getCuisine() {
        return cuisine;
    }

    /**
     * Get ingredients of search criteria
     * @return ingredients of search criteria
     */
    public ArrayList<String> getIngredients() {
        return ingredients;
    }

    /**
     * Get time in minutes of search criteria
     * @return time in minutes of search criteria
     */
    public int getTimeInMin() {
        return timeInMin;
    }

    /**
     * Get sort type of search criteria
     * @return sort type of search criteria
     */
    public String getSortType() {
        return sortType;
    }

    /**
     * Get whether to sort resulting recipes by ascending/descending order
     * @return true if sort by ascending order
     */
    public boolean isSortByAscending() {
        return sortByAscending;
    }
}
