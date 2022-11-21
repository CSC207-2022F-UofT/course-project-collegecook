package search;

import entities.Recipe;

import java.util.ArrayList;

public class SearchPresenter implements SearchOutputBoundary{

    @Override
    public SearchResponseModel prepareResultsView(SearchResponseModel searchResults){
        //TODO: delete and fill out implementation details for results view
        return new SearchResponseModel(new Recipe[0]);
    };

    @Override
    public SearchResponseModel prepareFailureView(String error){
        //TODO: delete and fill out implementation details for failure view
        return new SearchResponseModel(new Recipe[0]);
    };

}
