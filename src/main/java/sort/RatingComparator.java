package sort;

import entities.Recipe;

import java.util.Comparator;

public class RatingComparator implements Comparator<Recipe> {
    /**
     * Compares its two arguments for order.
     * <p>
     * Returns a negative integer, zero, or a positive integer
     * as r1 is less than, equal to, or greater than r2 in terms
     * of average rating.
     *
     * @param r1 the first Review to compare
     * @param r2 the second Review to compare
     * @return a negative integer, zero, or a positive integer
     * as r1 is less than, equal to, or greater than r2
     */
    @Override
    public int compare(Recipe r1, Recipe r2) {
        // TODO: calculate averageRating for each recipe. Get all reviews where reviewedRecipe == r1. Sum up ratings, divide by number of reviews.
        float r1avRating =  0;
        float r2avRating = 1;
        float recipeRatingDiff = r1avRating - r2avRating;
        int diff = int((recipeRatingDiff >= 0) ? Math.ceil(recipeRatingDiff) : Math.floor(recipeRatingDiff));
        return diff;
    }
}
