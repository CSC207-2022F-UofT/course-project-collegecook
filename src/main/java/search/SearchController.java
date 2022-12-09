package search;

import java.io.IOException;
import java.util.ArrayList;

// Interface Adaptor layer
public class SearchController {
    final SearchInputBoundary searchInputBoundary;

    public SearchController(SearchInputBoundary searchInputBoundary) {
        this.searchInputBoundary = searchInputBoundary;
    }

    /**
     * Create SearchRequestModel with user input, then pass to SearchInputBoundary
     * @param name keyword that recipe title contains
     * @param cuisine cuisine type that recipe has
     * @param ingredients ingredients that are in recipe
     * @param timeInMin amount of time needed for recipe
     * @param sortType in what order to sort results (i.e. by average rating, number of ingredients, time needed)
     */
    public void getSearchResults(String name, String cuisine, ArrayList<String> ingredients, int timeInMin, String sortType, boolean sortAscending) throws IOException {
        SearchRequestModel requestModel = new SearchRequestModel(name, cuisine, ingredients, timeInMin, sortType, sortAscending);
        searchInputBoundary.getSearchResults(requestModel);
    }

}
