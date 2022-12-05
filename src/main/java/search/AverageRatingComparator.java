package search;

import entities.Recipe;
import entities.Review;
import entities.ReviewDatabase;
import review.ReviewInteractor;

import java.util.ArrayList;
import java.util.Comparator;

public class AverageRatingComparator implements Comparator<Recipe> {
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

        ReviewDatabase reviewDatabase = ReviewInteractor.loadReviewDatabase();
        ArrayList<Review> reviews1 = reviewDatabase.getRecipeReviews(r1);
        ArrayList<Review> reviews2 = reviewDatabase.getRecipeReviews(r2);

        if (reviews1.isEmpty() || reviews2.isEmpty()){
            return reviews1.size() - reviews2.size();
        }
        else{
            int r1avgRating = (reviews1.stream().mapToInt(Review::getRating).sum())/ reviews1.size();
            int r2avgRating = (reviews2.stream().mapToInt(Review::getRating).sum())/ reviews2.size();
            return r1avgRating - r2avgRating;

        }
    }
}
