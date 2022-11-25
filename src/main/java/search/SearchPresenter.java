package search;

public class SearchPresenter implements SearchOutputBoundary{
    SearchResultsBox searchResultsBox;
    @Override
    public void prepareSuccessView(SearchResponseModel searchResults) {
        searchResultsBox.success(searchResults.matchingRecipes);
    }

    @Override
    public void prepareFailureView(String error) {
        searchResultsBox.failure(error);
    }
}
