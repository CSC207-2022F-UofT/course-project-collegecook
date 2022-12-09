package search;

public interface SearchResultsBox {
    /**
     * show success view with matching recipes
     * @param searchResponseModel search response: search criteria, and search results: array of recipes that match search criteria, in order of chosen sort
     */
    void success(SearchResponseModel searchResponseModel);

    /**
     * show failure view with no recipes found
     */
    void failure(String error);

}
