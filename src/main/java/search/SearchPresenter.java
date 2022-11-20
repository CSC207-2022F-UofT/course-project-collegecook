package search;

import entities.Recipe;

import java.util.ArrayList;

public class SearchPresenter implements SearchOutputBoundary{
    /**
     * Success view for recipes found
     * @param searchResults matching recipes found
     * @return view that shows the recipes found
     */
    @Override
    public SearchResponseModel prepareResultsView(SearchResponseModel searchResults){
        //TODO: delete and fill out implementation details for results view
        return new SearchResponseModel(new ArrayList<Recipe>());
    };

    /**
     * Failure view for no recipes found
     * @param error error message
     * @return error that shows no recipes were found
     */
    @Override
    public SearchResponseModel prepareNoResultsView(String error){
        //TODO: delete and fill out implementation details for no results view
        return new SearchResponseModel(new ArrayList<Recipe>());
    };

}
