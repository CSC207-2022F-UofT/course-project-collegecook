package entities;

import java.io.Serializable;
import java.util.Objects;

public class Review implements Serializable {

    private static final long serialVersionUID = -1460462247339298801L;
    private final String username;
    private final Recipe reviewedRecipe;
    private String reviewContent = "";
    private final int rating;

    /**
     * Construct a Review, with the
     * given user, recipe, and rating.
     * The rating must be between 0 and 5, inclusive.
     *
     * @param username the username of the User that created this review
     * @param recipe the Recipe being reviewed
     * @param rating the reviews rating.
     */
    public Review (String username, Recipe recipe, int rating) {
        this.username = username;
        this.reviewedRecipe = recipe;
        this.rating = rating;
    }

    /**
     * Construct a Review, with the
     * given user, recipe, review content and rating.
     * The rating must be between 0 and 5, inclusive.
     *
     * @param username the User that created this review
     * @param recipe the Recipe being reviewed
     * @param content the content of the review
     * @param rating the reviews rating
     */

    public Review (String username, Recipe recipe, String content, int rating) {
        this(username, recipe, rating);
        this.reviewContent = content;
    }

    /**
     * Get the user who made this review.
     */
    public String getUser() {
        return this.username;
    }

    /**
     * Get the recipe this review is for.
     */
    public Recipe getRecipe() {
        return this.reviewedRecipe;
    }

    /**
     * Get the review's content.
     */
    public String getContent() {
        return this.reviewContent;
    }

    /**
     * Get the review's rating.
     */
    public int getRating() {
        return this.rating;
    }

    @Override
    public String toString(){
        return "Reviewer: " + username + System.lineSeparator() + "Rating: " + rating + "/5" +
                System.lineSeparator() + "\"" + reviewContent + "\"";
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Review review = (Review) o;
        return rating == review.rating && Objects.equals(username, review.username) && Objects.equals(reviewedRecipe, review.reviewedRecipe) && Objects.equals(reviewContent, review.reviewContent);
    }

}
