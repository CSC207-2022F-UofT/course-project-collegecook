package review;

import entities.Recipe;
import entities.Review;

import java.util.ArrayList;

/**
 * Creates a sample review for use in testing. WARNING, the username used may not have a corresponding user class.
 *
 */
public class ReviewSimpleFactory {

    public static Review createReview() {
        ArrayList<String> ingredients = new ArrayList<>();
        ingredients.add("pasta");
        ingredients.add("sauce");
        Recipe sampleRecipe = new Recipe("spaghetti", "Just cook it",
                "italy", ingredients, 500, 10, 3, "Ben");
        return new Review("bob", sampleRecipe, "tasted terrible", 1);
    }
}
