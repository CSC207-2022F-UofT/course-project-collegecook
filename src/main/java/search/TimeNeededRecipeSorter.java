package search;

import entities.Recipe;
import java.util.Arrays;

public class TimeNeededRecipeSorter implements RecipeSorter {
    /**
     * Sort recipes in chosen order by the time needed to make each recipe
     * @param recipes list of recipes to be sorted
     * @param sortByAscending whether to sort by ascending (or descending)
     */
    @Override
    public void sort(Recipe[] recipes, boolean sortByAscending) {
        Arrays.sort(recipes, new TimeNeededComparator());
    }
}
