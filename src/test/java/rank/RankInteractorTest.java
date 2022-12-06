package rank;

import entities.AverageRatings;
import entities.Profile;
import entities.Recipe;
import entities.User;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;


import static org.junit.jupiter.api.Assertions.assertEquals;

public class RankInteractorTest {


    @Test
    public void TestEmptyInteractor() {
        User[] users = {};
        String rank = "total followers";
        Arrays.sort(users, new AvgRatingComparator());
        int expected = 0;
        int actual = users.length;
        assertEquals(expected, actual);
    }

    @Test
    public void TestInteractorTotal() {
        User[] users = {};
        String rank = "total followers";
        Arrays.sort(users, new AvgRatingComparator());
        int expected = 0;
        int actual = users.length;
        assertEquals(expected, actual);
    }


}
