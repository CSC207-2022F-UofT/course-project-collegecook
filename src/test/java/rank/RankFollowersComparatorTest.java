package rank;

import entities.User;
import org.junit.jupiter.api.Test;



import java.util.ArrayList;
import java.util.Arrays;


import static org.junit.jupiter.api.Assertions.assertEquals;

public class RankFollowersComparatorTest {

    @Test
    public void TestUserFollowerComparator() {
        User user1 = new User("User1", "CSC207");
        User user2 = new User("User2", "CSC208");
        User user3 = new User("User3", "CSC209");
        User user4 = new User("User4", "CSC210");
        // Set followers for user 1 to 2
        user1.addFollowers(user4);
        user1.addFollowers(user3);
        user2.addFollowers(user4);
        User[] users = {user2,user1,user3};
        Arrays.sort(users, new TotalFollowersComparator());
        ArrayList<String> expected = new ArrayList<>();
        expected.add(user1.getUsername());
        expected.add(user2.getUsername());
        expected.add(user3.getUsername());
        ArrayList<String> actualList  = new ArrayList<>();
        for (User user : users) {
            actualList.add(user.getUsername());
        }
        assertEquals(expected, actualList);
    }

}