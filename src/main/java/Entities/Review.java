package entities;

public class Review {

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

}
