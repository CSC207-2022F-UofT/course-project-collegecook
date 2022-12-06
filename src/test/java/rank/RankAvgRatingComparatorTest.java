package rank;

import entities.AverageRatings;
import entities.User;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;


public class RankAvgRatingComparatorTest {
    @Test
    public void TestAvgRating() {
        AverageRatings averageRatings = new AverageRatings();
        averageRatings.addAverageRating("User1", 4.5);
        averageRatings.addAverageRating("User2", 2.5);
        averageRatings.addAverageRating("User3", 5.0);
        User user1 = new User("User1", "CSC207");
        User user2 = new User("User2", "CSC208");
        User user3 = new User("User3", "CSC209");
        User[] users = {user2,user1,user3};
        Arrays.sort(users, new AvgRatingComparator());
        ArrayList<String> expected = new ArrayList<>();
        expected.add(user2.getUsername());
        expected.add(user1.getUsername());
        expected.add(user3.getUsername());
        ArrayList<String> actual = new ArrayList<>();
        for (User user : users) {
            actual.add(user.getUsername());
        }
        Assertions.assertEquals(expected, actual);
    }
}