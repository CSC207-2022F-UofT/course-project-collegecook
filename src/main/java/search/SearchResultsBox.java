package search;

import entities.Recipe;

public interface SearchResultsBox {
    /**
     * show success view with matching recipes
     * @param matchingRecipes search results: array of recipes that match search criteria, in order of chosen sort
     */
    void success(Recipe[] matchingRecipes);

    /**
     * show failure view with no recipes found
     */
    void failure(String error);

}
