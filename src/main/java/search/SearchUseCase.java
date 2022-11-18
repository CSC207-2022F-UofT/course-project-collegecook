package search;

import java.util.ArrayList;
import java.util.List;
import java.util.function.ToDoubleFunction;

public class SearchUseCase {
    static List<String> searchResults = new ArrayList<String>();

    // #TODO: implement searchForRecipes: get matching recipes from RecipeList
    public static List<String> getSearchResults(){
        return searchResults;
    }
}
