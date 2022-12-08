package rank;
import org.junit.jupiter.api.Test;


import java.io.IOException;
import java.lang.NullPointerException;



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
    public void TestTotalFollowersInteractor() throws NullPointerException, IOException {
        String ranking = "total followers";
        RankRequestModel rankRequestModel = new RankRequestModel(ranking);
        RankResponseModel returned = rankInteractor.sortUsers(rankRequestModel);
        String actual;
        try{
            actual = returned.getRank();
        } catch (NullPointerException e){
            actual = "";
        }
        String expected = "total followers";
        assertEquals(actual,expected);

    }

    @Test
    public void TestRecipeInteractor() throws IOException {
        String ranking = "total number of recipe";
        RankRequestModel rankRequestModel = new RankRequestModel(ranking);
        RankResponseModel returned = rankInteractor.sortUsers(rankRequestModel);
        String actual;
        try{
            actual = returned.getRank();
        } catch (NullPointerException e){
            actual = "";
        }
        String expected = "total number of recipe";
        assertEquals(actual,expected);

    }


}