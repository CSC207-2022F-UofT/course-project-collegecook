package entities;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;

import java.util.ArrayList;
import static org.junit.jupiter.api.Assertions.*;

public class ReviewTest {
    Review rev;
    Recipe sampleRecipe;

    @BeforeEach
    public void setUp(){
        ArrayList<String> ingredients = new ArrayList<>();
        ingredients.add("pasta");
        ingredients.add("sauce");
        sampleRecipe = new Recipe("spaghetti", "Just cook it",
                "italy", ingredients, 500, 10, 3);
        rev = new Review("bob", sampleRecipe, "tasted terrible", 1);
    }

    @AfterEach
    void tearDown() {
        rev = null;
    }

    @Test
    public void TestGetRecipe() {
        Recipe expected = sampleRecipe;
        Recipe actual = rev.getRecipe();
        assertEquals(expected, actual);
    }

    @Test
    public void TestGetUser() {
        String expected = "bob";
        String actual = rev.getUser();
        assertEquals(expected, actual);
    }

    @Test
    public void TestGetContent() {
        String expected = "tasted terrible";
        String actual = rev.getContent();
        assertEquals(expected, actual);
    }

    @Test
    public void TestGetRating() {
        int expected = 1;
        int actual = rev.getRating();
        assertEquals(expected, actual);
    }

    @Test
    public void TestToString() {
        String expected = "Reviewer: bob" + System.lineSeparator() + "Rating: 1/5" +
                System.lineSeparator() + "\"tasted terrible\"";
        System.out.println(expected);
        String actual = rev.toString();
        assertEquals(expected, actual);
    }

}