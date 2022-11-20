package search;

import entities.Recipe;

import java.util.ArrayList;

public class SearchResponseModel {
    ArrayList<Recipe> matchingRecipes;

    /**
     * Transiently stores data for presenter
     * @param matchingRecipes list of recipes matching search criteria
     */
    public SearchResponseModel(ArrayList<Recipe> matchingRecipes){
        this.matchingRecipes = matchingRecipes;
    }

    public ArrayList<Recipe> getMatchingRecipes() {
        return matchingRecipes;
    }

    public void setMatchingRecipes(ArrayList<Recipe> matchingRecipes) {
        this.matchingRecipes = matchingRecipes;
    }
}
