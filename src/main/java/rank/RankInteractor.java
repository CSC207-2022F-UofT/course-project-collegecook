package rank;

import entities.Rank;
import entities.User;
import entities.UserList;

import java.util.Collections;
import java.util.List;

public class RankInteractor implements RankInputBoundary{
    // The only input accepted are "Average Rating" , "Total Followers", "Total Number of Recipe"
    final RankOutputBoundary rankOutputBoundary;
    UserList userList;
    List<User> users = userList.getAllUser();
    Rank rankobj = new Rank(users);

    public RankInteractor(RankOutputBoundary rankOutputBoundary) {
        this.rankOutputBoundary = rankOutputBoundary;
    }
    @Override
    public String sortUsers(RankRequestModel requestModel) {
        // import all users for user
        switch (requestModel.getRanking()) {
            case "Average Rating": {
                // sort based on avg rating
                users.sort(Rank.UserAvgRating);
                RankResponseModel rankResponseModel = new RankResponseModel(requestModel.getRanking(), users);
                return rankOutputBoundary.prepareSuccessView(rankResponseModel);
            }
            case "Total Followers": {
                // sort based on total followers
                users.sort(Rank.UserFollowerComparator);
                RankResponseModel rankResponseModel = new RankResponseModel(requestModel.getRanking(), users);
                return rankOutputBoundary.prepareSuccessView(rankResponseModel);
            }
            case "Total Number of Recipe": {
                // sort based on # of recipe
                users.sort(Rank.UserTotalRecipe);
                RankResponseModel rankResponseModel = new RankResponseModel(requestModel.getRanking(), users);
                return rankOutputBoundary.prepareSuccessView(rankResponseModel);
            }
        }
        return rankOutputBoundary.prepareFailView(requestModel.getRanking());
    }
}

