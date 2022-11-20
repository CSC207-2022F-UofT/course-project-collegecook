package search;

import entities.Recipe;
import recipe.RecipeInterActor;

import java.util.ArrayList;

public class SearchInteractor implements SearchInputBoundary{

    final SearchPresenter searchPresenter;

    /**
     * Constructs a SearchInteractor object
     * @param searchPresenter a SearchPresenter object
     */
    public SearchInteractor(SearchPresenter searchPresenter) {
        this.searchPresenter = searchPresenter;
    }

    @Override
    public SearchResponseModel getSearchResults(SearchRequestModel requestModel){
        //TODO: Implement searching for recipes with matching criteria
        //TODO: Implement communicating with SortInteractor to sort recipes found
        return searchPresenter.prepareResultsView(new SearchResponseModel(new ArrayList<Recipe>()));
    }
}
