package search;

import entities.Recipe;
import entities.Review;
import entities.ReviewDatabase;
import review.ReviewInteractor;

import java.util.ArrayList;
import java.util.Comparator;

public class AverageRatingRecipeComparator implements Comparator<Recipe> {
    /**
     * Compares its two arguments for order.
     * <p>
     * Returns a negative integer, zero, or a positive integer
     * as r1 is less than, equal to, or greater than r2 in terms
     * of average rating.
     *
     * @param r1 the first Recipe to compare
     * @param r2 the second Recipe to compare
     * @return a negative integer, zero, or a positive integer
     * as r1 is less than, equal to, or greater than r2
     */
    @Override
    public int compare(Recipe r1, Recipe r2) {

        ReviewDatabase reviewDatabase = ReviewInteractor.loadReviewDatabase();
        ArrayList<Review> reviews1 = reviewDatabase.getRecipeReviews(r1);
        ArrayList<Review> reviews2 = reviewDatabase.getRecipeReviews(r2);

        // if one of the recipes has no reviews, return the difference between the number of reviews
        if (reviews1.isEmpty() || reviews2.isEmpty()){
            return reviews1.size() - reviews2.size();
        }
        // calculate average rating for each recipe from its reviews
        else{
            double r1avgRating = (reviews1.stream().mapToDouble(Review::getRating).sum())/ reviews1.size();
            double r2avgRating = (reviews2.stream().mapToDouble(Review::getRating).sum())/ reviews2.size();
            return (int) Math.signum(r1avgRating - r2avgRating);
        }
    }
}
