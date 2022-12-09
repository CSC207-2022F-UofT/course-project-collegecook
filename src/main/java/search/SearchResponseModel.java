package search;

import entities.Recipe;

public class SearchResponseModel {
    Recipe[] matchingRecipes;
    SearchRequestModel searchRequestModel;

    /**
     * Transiently stores data for presenter
     * @param matchingRecipes list of recipes matching search criteria
     */
    public SearchResponseModel(Recipe[] matchingRecipes, SearchRequestModel searchRequestModel){
        this.matchingRecipes = matchingRecipes;
        this.searchRequestModel = searchRequestModel;
    }

    public Recipe[] getMatchingRecipes() {
        return matchingRecipes;
    }

    public SearchRequestModel getSearchRequestModel() {return searchRequestModel;}
}
