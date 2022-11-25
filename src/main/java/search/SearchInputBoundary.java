package search;

import java.io.IOException;

// Use case layer
// SearchInteractor implements this interface
public interface SearchInputBoundary {
    /**
     * Searches for recipes that match the given search criteria, in the chosen sort type and order
     * @param requestModel the given search criteria (keyword, cuisine, ingredients, time), sort type, and whether to sort by ascending
     */
    SearchResponseModel getSearchResults(SearchRequestModel requestModel) throws IOException;
}
