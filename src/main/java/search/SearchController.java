package search;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class SearchController {
    String name;
    String cuisine;
    int timeInMin;
    List<String> ingredients;
    String sortType;

    public Map<String, Object> getSearchCriteria(String name, String cuisine, int timeInMin, List<String> ingredients, String sortType) {
        Map<String, Object> searchCriteria = new HashMap<String, Object>();
        searchCriteria.put("name", name);
        searchCriteria.put("cuisine", cuisine);
        searchCriteria.put("timeInMin", timeInMin);
        searchCriteria.put("ingredients", ingredients);
        searchCriteria.put("sortType", sortType);
        return searchCriteria;
    }

    public void setSearchCriteria(String name, String cuisine, int timeInMin, List<String> ingredients, String sortType) {
        this.name = name;
        this.cuisine = cuisine;
        this.timeInMin = timeInMin;
        this.ingredients = ingredients;
        this.sortType = sortType;
    }

}
