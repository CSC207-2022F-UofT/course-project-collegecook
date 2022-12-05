package rank;

import entities.User;

import java.io.IOException;
import java.util.List;

public interface RankInputBoundary {
    /**
     *
     * Interface which contains method that needs to be implemented
     * for the feature to successfully run.
     *
     * @param requestModel contains the choice of ranking
     */
    RankResponseModel sortUsers(RankRequestModel requestModel) throws IOException;

}