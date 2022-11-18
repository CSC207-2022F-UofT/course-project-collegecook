package search;

import java.util.List;

public class SearchPresenter {

    /**
     * Presenting search results to user
     */

    // Show list of names of the recipes found
    public void showSearchResults(){
        System.out.println("These were the recipes found matching your criteria:" + SearchUseCase.getSearchResults());
    }

    // Show message if there were no matching recipes found
    public void showNoResults(){
        System.out.println("No Results Found");
    }

}
