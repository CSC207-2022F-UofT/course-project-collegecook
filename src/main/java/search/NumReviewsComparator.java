package search;

import entities.Recipe;

import java.util.Comparator;

public class NumReviewsComparator implements Comparator<Recipe> {
    /**
     * Compares its two arguments for order.
     * Returns a negative integer, zero, or a positive integer
     * as r1 is less than, equal to, or greater than r2 in terms
     * of the number of reviews it has
     *
     * @param r1 the first Recipe to compare
     * @param r2 the second Recipe to compare
     * @return a negative integer, zero, or a positive integer
     *      as r1 is less than, equal to, or greater than r2
     */
    @Override
    public int compare(Recipe r1, Recipe r2) {
        //TODO: get all reviews for a given recipe
        int n1 = 2;
        int n2 = 3;
        return n1 - n2;
    }
}
