package entities;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.BeforeAll;

import static org.junit.jupiter.api.Assertions.*;

class AverageRatingsTest {

    @BeforeAll
    public static void setUp(){
        AverageRatings.addAverageRating("bob", 4.2);
        AverageRatings.addAverageRating("Rob", 2.2);
    }
    @Test
    public void TestGetAverageRating() {
        Double expected1 = 4.2;
        Double actual1 = AverageRatings.getAverageRating("bob");
        assertEquals(expected1, actual1);

        Double expected2 = 2.2;
        Double actual2 = AverageRatings.getAverageRating("Rob");
        assertEquals(expected2, actual2);

        Double expected3 = (double) -1;
        Double actual3 = AverageRatings.getAverageRating("Robert");
        assertEquals(expected3, actual3);
    }

}