package rank;
import entities.User;
import org.junit.jupiter.api.Test;
import java.util.ArrayList;


import static org.junit.jupiter.api.Assertions.assertEquals;

public class RankResponseModelTest {

    User user1 = new User("User1", "CSC207");
    User user2 = new User("User2", "CSC208");
    User user3 = new User("User3", "CSC209");
    ArrayList<String> users = new ArrayList<String>(){
        {
            add(user1.getUsername());
            add(user2.getUsername());
            add(user3.getUsername());}
        };
    final String rank = "total followers";
    final RankResponseModel rankResponseModel = new RankResponseModel(rank, users);

    @Test
    public void RankResponseGetRankTest() {
        //Expected
        String expected1 = "total followers";
        //Actual
        String actual1 = rankResponseModel.getRank();
        assertEquals(expected1, actual1);
    }

    @Test
    public void RankResponseGetUserTest() {
        //Expected values
        ArrayList<String> expected2 = new ArrayList<>();
        expected2.add("User1");
        expected2.add("User2");
        expected2.add("User3");
        // Actual values
        ArrayList<String> actual2 = rankResponseModel.getUsers();
        assertEquals(expected2, actual2);
    }
    @Test
    public void RankResponseSetRankTest() {
        rankResponseModel.setRank("average rating");
        //Expected
        String expected1 = "average rating";
        //Actual
        String actual1 = rankResponseModel.getRank();
        assertEquals(expected1, actual1);
    }
    @Test
    public void RankResponseSetUserTest() {
        User user4 = new User("User4", "CSC203");
        users.add(user4.getUsername());
        rankResponseModel.setUsers(users);
        //Expected
        ArrayList<String> expected2 = new ArrayList<>();
        expected2.add("User1");
        expected2.add("User2");
        expected2.add("User3");
        expected2.add("User4");
        //Actual
        ArrayList<String> actual2 = rankResponseModel.getUsers();
        assertEquals(expected2, actual2);
    }
}




