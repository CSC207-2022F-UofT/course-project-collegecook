package search;

import entities.Recipe;

import java.util.ArrayList;

public class SearchResponseModel {
    Recipe[] matchingRecipes;

    /**
     * Transiently stores data for presenter
     * @param matchingRecipes list of recipes matching search criteria
     */
    public SearchResponseModel(Recipe[] matchingRecipes){
        this.matchingRecipes = matchingRecipes;
    }

    public Recipe[] getMatchingRecipes() {
        return matchingRecipes;
    }

    public void setMatchingRecipes(Recipe[] matchingRecipes) {
        this.matchingRecipes = matchingRecipes;
    }
}
