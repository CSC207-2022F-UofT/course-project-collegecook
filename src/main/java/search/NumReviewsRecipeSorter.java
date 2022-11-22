package search;

import entities.Recipe;

import java.util.Arrays;

public class NumReviewsRecipeSorter implements RecipeSorter{
    /**
     * Sort recipes in chosen order by the number of reviews each recipe has
     * @param recipes list of recipes to be sorted
     * @param sortByAscending whether to sort by ascending (or descending)
     */
    @Override
    public void sort(Recipe[] recipes, boolean sortByAscending) {
        Arrays.sort(recipes, new NumReviewsComparator());
    }

}
