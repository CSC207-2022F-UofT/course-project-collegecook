package Entities;

public class Review {

    private final User user;
    private final Recipe reviewedRecipe;
    private String reviewContent = "";
    private int rating;

    /**
     * Construct a Review, with the
     * given user, recipe, and rating.
     * The rating must be between 0 and 5, inclusive.
     *
     * @param user the User that created this review
     * @param recipe the Recipe being reviewed
     * @param rating the reviews rating.
     */
    public Review (User user, Recipe recipe, int rating) {
        this.user = user;
        this.reviewedRecipe = recipe;
        this.rating = rating;
    }

    /**
     * Construct a Review, with the
     * given user, recipe, review content and rating.
     * The rating must be between 0 and 5, inclusive.
     *
     * @param user the User that created this review
     * @param recipe the Recipe being reviewed
     * @param content the content of the review
     * @param rating the reviews rating.
     */

    public Review (User user, Recipe recipe, String content, int rating) {
        this(user, recipe, rating);
        this.reviewContent = content;
    }

    /**
     * Get the user who made this review.
     */
    public User getUser() {
        return this.user;
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

}
