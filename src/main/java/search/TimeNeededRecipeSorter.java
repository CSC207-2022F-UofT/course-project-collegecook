package search;

import entities.Recipe;
import java.util.Arrays;
import java.util.Collections;

public class TimeNeededRecipeSorter implements RecipeSorter {
    /**
     * Sort recipes in chosen order by the time needed to make each recipe
     * @param recipes list of recipes to be sorted
     * @param sortByAscending whether to sort by ascending (or descending)
     */
    @Override
    public void sort(Recipe[] recipes, boolean sortByAscending) {
        if (sortByAscending)
        {
            Arrays.sort(recipes, new TimeNeededComparator());
        }
        else{Arrays.sort(recipes, Collections.reverseOrder(new TimeNeededComparator()));}

    }
}
