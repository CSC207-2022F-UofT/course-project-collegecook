package rank;
import login.UserRepoImpl;
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
        String ranking = "total followers";
        RankRequestModel rankRequestModel = new RankRequestModel(ranking);
        RankResponseModel returned = rankInteractor.sortUsers(rankRequestModel);
        int actual = returned.getUsers().size();
        int expected = UserRepoImpl.getUserRepoImpl().getAllUser().getAllUser().size();
        boolean actual1 = UserRepoImpl.getUserRepoImpl().getAllUser().CheckAllUser(returned.getUsers().get(0));
        boolean expected1 = true;
        assertEquals(actual1,expected1);
        assertEquals(actual,expected);
    }

    @Test
    public void TestRecipeInteractor() throws IOException {
        String ranking = "total number of recipe";
        RankRequestModel rankRequestModel = new RankRequestModel(ranking);
        RankResponseModel returned = rankInteractor.sortUsers(rankRequestModel);
        int actual = returned.getUsers().size();
        int expected = UserRepoImpl.getUserRepoImpl().getAllUser().getAllUser().size();
        Boolean actual1 = UserRepoImpl.getUserRepoImpl().getAllUser().CheckAllUser(returned.getUsers().get(0));
        Boolean expected1 = true;
        assertEquals(actual,expected);
        assertEquals(actual1,expected1);
    }


}