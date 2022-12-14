package rank;

import entities.Profile;
import entities.Recipe;
import entities.User;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;


import static org.junit.jupiter.api.Assertions.assertEquals;

public class RankRecipeComparatorTest {

    @Test
    public void TestProfileComparator() {
        User user1 = new User("User1", "CSC207");
        User user2 = new User("User2", "CSC208");
        User user3 = new User("User3", "CSC209");
        // Set followers for user 1 to 2
        Profile profile1 = new Profile(user1.getUsername());
        Profile profile2 = new Profile(user2.getUsername());
        // Making ingredients
        ArrayList<String> ing1 = new ArrayList<>();
        ing1.add("egg");
        ing1.add("bread");
        ArrayList<String> ing2 = new ArrayList<>();
        ing2.add("egg");
        ArrayList<String> ing3 = new ArrayList<>();
        ing3.add("oil");
        ing3.add("wheat");
        Recipe dish1 = new Recipe("1", "---", "---", ing1, 123, 1, 1, "ser1");
        Recipe dish2 = new Recipe("2", "---", "---", ing2, 123, 1, 1, "ser1");
        Recipe dish3 = new Recipe("3", "---", "---", ing3, 123, 1, 1, "ser1");
        // Making recipe for profile 1
        ArrayList<Recipe> recipe1 = new ArrayList<>();
        recipe1.add(dish1);
        profile1.setCreated(recipe1);
        // Making recipe for profile 2
        ArrayList<Recipe> recipe2 = new ArrayList<>();
        recipe2.add(dish3);
        recipe2.add(dish2);
        profile2.setCreated(recipe2);
        User[] users1 = {user2,user1,user3};
        Arrays.sort(users1, new TotalNumRecipeComparator());
        ArrayList<String> expected = new ArrayList<>();
        expected.add(user2.getUsername());
        expected.add(user1.getUsername());
        expected.add(user3.getUsername());
        ArrayList<String> actualList  = new ArrayList<>();
        for (User user : users1) {
            actualList.add(user.getUsername());
        }
        assertEquals(expected, actualList);
    }

}