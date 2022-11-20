package search;

public interface SearchOutputBoundary {
    /**
     * Success view with list of matching recipes found
     * @param searchResults list of matching recipes found
     * @return view that shows the list of matching recipes found
     */
    SearchResponseModel prepareResultsView(SearchResponseModel searchResults);
    /**
     * Failure view
     * @param error error message
     * @return view with error message displayed (ie. invalid search criteria, no recipes found)
     */
    SearchResponseModel prepareNoResultsView(String error);
}
