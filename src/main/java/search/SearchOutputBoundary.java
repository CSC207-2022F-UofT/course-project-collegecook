package search;

public interface SearchOutputBoundary {
    SearchResponseModel prepareResultsView(SearchResponseModel searchResults);
    SearchResponseModel prepareNoResultsView(String error);
}
