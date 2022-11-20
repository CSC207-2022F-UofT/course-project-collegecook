package search;

import entities.Recipe;
import recipe.RecipeInterActor;

import java.util.ArrayList;

public class SearchInteractor implements SearchInputBoundary{

    final SearchPresenter searchPresenter;

    public SearchInteractor(SearchPresenter searchPresenter) {
        this.searchPresenter = searchPresenter;
    }

    /**
     * Searches for recipes that match the given search criteria, in the order of the chosen sort
     * @param requestModel the search criteria given
     * @return search results or no results
     */
    @Override
    public SearchResponseModel getSearchResults(SearchRequestModel requestModel){
        //TODO: Implement details for searching for recipes, then sorting them
        return searchPresenter.prepareResultsView(new SearchResponseModel(new ArrayList<Recipe>()));
    }
}
