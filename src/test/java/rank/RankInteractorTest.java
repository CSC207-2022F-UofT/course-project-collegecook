package rank;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import java.io.IOException;



import static org.junit.jupiter.api.Assertions.assertEquals;

public class RankInteractorTest {

    RankOutputBoundary rankOutputBoundary = new RankOutputBoundary() {
        @Override
        public void prepareSuccessView(RankResponseModel rank) {

        }

        @Override
        public void prepareFailView(String error) {

        }

        @Override
        public void setUI(RankResultBox rankResultBox) {

        }
    };
    RankInteractor rankInteractor = new RankInteractor(rankOutputBoundary);



    @Test
    public void TestallCreateInteractor() throws IOException {
        RankOutputBoundary rankOutputBoundary = new RankPresenter();
        RankInteractor rankInteractor = new RankInteractor(rankOutputBoundary);
        int actual = rankInteractor.allCreatedRanking("user1");
        int expected = 3;
        assertEquals(expected, actual);
    }

    @Test
    public void TestTotalFollowersInteractor() throws IOException {
        // Dependent on the saved data file of users, so it might cause errors on different computers
        String ranking = "total followers";
        RankRequestModel rankRequestModel = new RankRequestModel(ranking);
        RankResponseModel returned = rankInteractor.sortUsers(rankRequestModel);
        int actual = returned.getUsers().size();
        int expected = 18;
        String actual1 = returned.getUsers().get(0);
        String expected1 = "3-Mary";
        assertEquals(expected, actual);
        assertEquals(actual1,expected1);
    }

    @Test
    public void TestRecipeInteractor() throws IOException {
        // Dependent on the saved data file of users, so it might cause errors on different computers
        String ranking = "total number of recipe";
        RankRequestModel rankRequestModel = new RankRequestModel(ranking);
        RankResponseModel returned = rankInteractor.sortUsers(rankRequestModel);
        int actual = returned.getUsers().size();
        int expected = 18;
        String actual1 = returned.getUsers().get(0);
        String expected1 = "4-user3";
        assertEquals(expected, actual);
        assertEquals(actual1,expected1);
    }


}