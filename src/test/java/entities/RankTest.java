package entities;

import org.junit.jupiter.api.Test;


import java.util.ArrayList;
import java.util.List;



    public class RankTest {

    @Test
    public void TestUserFollowerComparator() {
        User user1 = new User("Krutika", "CSC207");
        User user2 = new User("Krutika1", "CSC208");
        User user3 = new User("Krutika2", "CSC209");
        User user4 = new User("Krutika3", "CSC210");
        // Set followers for user 1 to 2
        List<User> folloUser1 = new ArrayList<>();
        folloUser1.add(user3);
        folloUser1.add(user4);
        //user1.addFollowers(folloUser1);
        // Set followers for User 2 to 1
        List<User> folloUser2 = new ArrayList<>();
        folloUser1.add(user3);
        //user2.addFollowers(folloUser2);
        // Testing
        UserList userList = new UserList();
        List<User> users = userList.getAllUser();
        Rank rank = new Rank(users);
    }
}
