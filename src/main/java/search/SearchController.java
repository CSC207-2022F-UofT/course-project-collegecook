package search;

import java.io.IOException;
import java.util.ArrayList;

public class SearchController {
    final SearchInputBoundary searchInputBoundary;

    public SearchController(SearchInputBoundary searchInputBoundary) {
        this.searchInputBoundary = searchInputBoundary;
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
    public SearchResponseModel getSearchResults(String name, String cuisine, ArrayList<String> ingredients, int timeInMin, String sortType, boolean sortAscending) throws IOException {
        SearchRequestModel requestModel = new SearchRequestModel(name, cuisine, ingredients, timeInMin, sortType, sortAscending);
        return searchInputBoundary.getSearchResults(requestModel);
    }

}
