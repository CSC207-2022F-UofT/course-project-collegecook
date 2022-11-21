package entities;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.BeforeAll;

import static org.junit.jupiter.api.Assertions.*;

class AverageRatingsTest {

    static AverageRatings r = new AverageRatings();

    @BeforeAll
    public static void setUp(){
        r.addAverageRating("bob", 4.2);
        r.addAverageRating("Rob", 2.2);
    }
    @Test
    public void TestGetAverageRating() {
        Double expected1 = 4.2;
        Double actual1 = r.getAverageRating("bob");
        assertEquals(expected1, actual1);

        Double expected2 = 2.2;
        Double actual2 = r.getAverageRating("Rob");
        assertEquals(expected2, actual2);

        Double expected3 = (double) -1;
        Double actual3 = r.getAverageRating("Robert");
        assertEquals(expected3, actual3);
    }

}