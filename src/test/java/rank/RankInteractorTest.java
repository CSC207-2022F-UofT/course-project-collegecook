package rank;
import login.UserRepoImpl;
import org.junit.jupiter.api.Test;
import java.io.IOException;



import static org.junit.jupiter.api.Assertions.assertEquals;

public class RankInteractorTest {
    UserRepoImpl userRepo = new UserRepoImpl();
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
        int expected = userRepo.getAllUser().getAllUser().size();
        assertEquals(actual,expected);
    }

    @Test
    public void TestRecipeInteractor() throws IOException {
        String ranking = "total number of recipe";
        RankRequestModel rankRequestModel = new RankRequestModel(ranking);
        RankResponseModel returned = rankInteractor.sortUsers(rankRequestModel);
        int actual = returned.getUsers().size();
        int expected = userRepo.getAllUser().getAllUser().size();
        assertEquals(actual,expected);
    }


}