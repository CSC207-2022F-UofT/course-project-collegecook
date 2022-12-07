package rank;


import java.io.IOException;


public interface RankInputBoundary {
    /**
     *
     * Interface which contains method that needs to be implemented
     * for the feature to successfully run.
     *
     * @param requestModel contains the choice of ranking
     */
    RankResponseModel sortUsers(RankRequestModel requestModel) throws IOException;
    /**
     *
     * Returns the number of recipe created by the user
     *
     * @param username username of user
     */int allCreatedRanking(String username) throws IOException;
}