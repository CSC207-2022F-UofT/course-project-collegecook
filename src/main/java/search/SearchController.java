package search;

import java.util.ArrayList;

public class SearchController {
    final SearchInputBoundary userInput;

    public SearchController(SearchInputBoundary userInput) {
        this.userInput = userInput;
    }

    /**
     *
     * @param name keyword that recipe title contains
     * @param cuisine cuisine type that recipe has
     * @param ingredients ingredients that are in recipe
     * @param timeInMin amount of time needed for recipe
     * @param sortType in what order to sort results (ie. by average rating, number of ingredients, time needed)
     * @return search results (list of recipes) for the given criteria
     */
    SearchResponseModel getSearchResults(String name, String cuisine, ArrayList<String> ingredients, int timeInMin, String sortType, boolean sortAscending){
        SearchRequestModel requestModel = new SearchRequestModel(name, cuisine, ingredients, timeInMin, sortType, sortAscending);
        return userInput.getSearchResults(requestModel);
    }

}
