package search;

import java.util.ArrayList;
import java.util.List;

public class SearchUseCase {
    List<String> searchResults = new ArrayList<String>();

    public List<String> getSearchResults(){
        return searchResults;
    }
}
