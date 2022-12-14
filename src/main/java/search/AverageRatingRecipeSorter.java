package search;

import entities.Recipe;
import java.util.Arrays;
import java.util.Collections;

public class AverageRatingRecipeSorter implements RecipeSorter{
    /**
     * Sort recipes in chosen order by the average rating of each recipe
     * @param recipes list of recipes to be sorted
     * @param sortByAscending whether to sort by ascending (or descending)
     */
    @Override
    public void sort(Recipe[] recipes, boolean sortByAscending) {
        if (sortByAscending) {
            Arrays.sort(recipes, new AverageRatingRecipeComparator());
        }
        else{Arrays.sort(recipes, Collections.reverseOrder(new AverageRatingRecipeComparator()));}

    }

}
