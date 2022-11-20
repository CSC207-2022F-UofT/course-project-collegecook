package search;

import java.util.ArrayList;

// Use case layer
// input data: get and set name, cuisine, ingredients, timeInMin, sortType
public class SearchRequestModel {
    String name;
    String cuisine;
    ArrayList<String> ingredients;
    int timeInMin;
    String sortType;

    public SearchRequestModel(String name, String cuisine, ArrayList<String> ingredients, int timeInMin, String sortType){
        this.name = name;
        this.cuisine = cuisine;
        this.ingredients = ingredients;
        this.timeInMin = timeInMin;
        this.sortType = sortType;
    }

    public String getName(){
        return this.name;
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
}
