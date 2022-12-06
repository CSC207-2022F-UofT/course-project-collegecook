package rank;

import entities.AverageRatings;
import entities.User;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

public class RankAvgRatingComparatorTest {
    @Test
    public void TestAvgRating() {
        User user1 = new User("User1", "CSC207");
        User user2 = new User("User2", "CSC208");
        User user3 = new User("User3", "CSC209");
        User[] users = {user2,user1,user3};
        AverageRatings averageRatings = new AverageRatings();
        averageRatings.addAverageRating(user1.getUsername(), 5.0);
        System.out.println(averageRatings);
        averageRatings.addAverageRating(user2.getUsername(), 4.0);
        System.out.println(averageRatings);
        averageRatings.addAverageRating(user3.getUsername(), 3.0);
        System.out.println(averageRatings);
        Arrays.sort(users, new AvgRatingComparator());
        for (User user : users) {
            System.out.println(user.getUsername());
        }}
}
