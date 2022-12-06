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
        ArrayList<String> expected = new ArrayList<String>();
        expected.add(user1.getUsername());
        expected.add(user2.getUsername());
        expected.add(user3.getUsername());
        ArrayList<String> actualList  = new ArrayList<String>();
        for (User user : users) {
            actualList.add(user.getUsername());
        }
        assertEquals(expected, actualList);
        }
    @Test
    public void TestProfileComparator() throws IOException {
        User user1 = new User("User1", "CSC207");
        User user2 = new User("User2", "CSC208");
        User user3 = new User("User3", "CSC209");
        User[] users = {user2,user1,user3};
        // Set followers for user 1 to 2
        Profile profile1 = new Profile(user1.getUsername());
        Profile profile2 = new Profile(user2.getUsername());
        Profile profile3 = new Profile(user3.getUsername());
        // Making ingredients
        ArrayList<String> ing1 = new ArrayList<String>();
        ing1.add("egg");
        ing1.add("bread");
        ArrayList<String> ing2 = new ArrayList<String>();
        ing2.add("egg");
        ArrayList<String> ing3 = new ArrayList<String>();
        ing3.add("oil");
        ing3.add("wheat");
        Recipe dish1 = new Recipe("1", "---", "---", ing1, 123, 1, 1, "ser1");
        Recipe dish2 = new Recipe("2", "---", "---", ing2, 123, 1, 1, "ser1");
        Recipe dish3 = new Recipe("3", "---", "---", ing3, 123, 1, 1, "ser1");
        // Making recipe for profile 1
        ArrayList<Recipe> recipe1 = new ArrayList<Recipe>();
        recipe1.add(dish1);
        profile1.setCreated(recipe1);
        // Making recipe for profile 2
        ArrayList<Recipe> recipe2 = new ArrayList<Recipe>();
        recipe2.add(dish3);
        recipe2.add(dish2);
        profile2.setCreated(recipe2);
        User[] users1 = {user2,user1,user3};
        Arrays.sort(users1, new TotalNumRecipeComparator());
        ArrayList<String> expected = new ArrayList<String>();
        expected.add(user2.getUsername());
        expected.add(user1.getUsername());
        expected.add(user3.getUsername());
        ArrayList<String> actualList  = new ArrayList<String>();
        for (User user : users1) {
            actualList.add(user.getUsername());
        }
        assertEquals(expected, actualList);
    }
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
