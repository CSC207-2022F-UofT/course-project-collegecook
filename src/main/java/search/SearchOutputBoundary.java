package search;

public interface SearchOutputBoundary {
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
