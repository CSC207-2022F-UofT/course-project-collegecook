package search;

// Use Case layer
// SearchPresenter implements this interface
public interface SearchOutputBoundary {

    /**
     * Sets up SearchResultsBox interface
     * @param searchResultsBox interface to show search results
     */
    void setUI(SearchResultsBox searchResultsBox);

    /**
     * Success view with list of matching recipes found
     * @param searchResults list of matching recipes found
     */
    void prepareSuccessView(SearchResponseModel searchResults);
    /**
     * Failure view
     */
    void prepareFailureView(String error);
}
