package search;

import entities.Recipe;

import java.util.ArrayList;

public class SearchPresenter implements SearchOutputBoundary{

    @Override
    public SearchResponseModel prepareResultsView(SearchResponseModel searchResults){
        //TODO: delete and fill out implementation details for results view
        return new SearchResponseModel(new ArrayList<Recipe>());
    };

    @Override
    public SearchResponseModel prepareNoResultsView(String error){
        //TODO: delete and fill out implementation details for no results view
        return new SearchResponseModel(new ArrayList<Recipe>());
    };

}
