package search;

import entities.Recipe;
public interface RecipeSorter {
    /**
     * Sorts the recipes in the list in the chosen order
     * @param recipes list of recipes to be sorted
     * @param sortByAscending whether to sort by ascending (or descending)
     */
    void sort(Recipe[] recipes, boolean sortByAscending);
}
