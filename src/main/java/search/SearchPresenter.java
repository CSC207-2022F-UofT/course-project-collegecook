package search;

// Interface Adaptor layer
public class SearchPresenter implements SearchOutputBoundary{
    SearchResultsBox searchResultsBox;

    @Override
    public void setUI(SearchResultsBox searchResultsBox){
        this.searchResultsBox = searchResultsBox;
    }
    @Override
    public void prepareSuccessView(SearchResponseModel searchResults) {
        searchResultsBox.success(searchResults);
    }

    @Override
    public void prepareFailureView(String error) {
        searchResultsBox.failure(error);
    }
}
