package search;

import entities.Recipe;
import entities.Review;
import entities.ReviewDatabase;
import review.ReviewInteractor;

import java.util.ArrayList;
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
        ReviewDatabase reviewDatabase = ReviewInteractor.loadReviewDatabase();
        ArrayList<Review> reviews1 = reviewDatabase.getRecipeReviews(r1);
        ArrayList<Review> reviews2 = reviewDatabase.getRecipeReviews(r2);
        return reviews1.size() - reviews2.size();
    }
}
