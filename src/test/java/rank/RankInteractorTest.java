package rank;
import entities.UserList;
import login.UserRepoImpl;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;


import java.io.IOException;
import java.lang.NullPointerException;



import static org.junit.jupiter.api.Assertions.assertEquals;

public class RankInteractorTest {
    UserRepoImpl userRepoImpl = new UserRepoImpl();
    UserList temp = new UserList();
    UserList user = new UserList();
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
    @BeforeEach
    void setUp() throws IOException {
        UserRepoImpl userRepoImpl = UserRepoImpl.getUserRepoImpl();
        user = userRepoImpl.getAllUser();
        temp = userRepoImpl.getAllUser();
        user.AddAllUser("User1", "1234");
        user.AddAllUser("User2", "1234");
        userRepoImpl.saveUser(user);
    }
    @AfterEach
    void tearDown() throws IOException {
        userRepoImpl.saveUser(temp);
        userRepoImpl = null;
        user = null;
        temp = null;

    }

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
        int actual;
        try{
            actual = returned.getUsers().size();
        } catch (NullPointerException e){
            actual = 0;
        }
        int expected = 2;
        assertEquals(actual,expected);

    }

    @Test
    public void TestRecipeInteractor() throws IOException {
        String ranking = "total number of recipe";
        RankRequestModel rankRequestModel = new RankRequestModel(ranking);
        RankResponseModel returned = rankInteractor.sortUsers(rankRequestModel);
        int actual;
        try{
            actual = returned.getUsers().size();
        } catch (NullPointerException e){
            actual = 0;
        }
        int expected = 2;
        assertEquals(actual,expected);

    }


}