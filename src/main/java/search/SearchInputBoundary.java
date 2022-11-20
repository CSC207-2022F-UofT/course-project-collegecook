package search;

// Use case layer
// SearchInteractor implements this interface
public interface SearchInputBoundary {
    SearchResponseModel getSearchResults(SearchRequestModel requestModel);
}
