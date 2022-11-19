package rank;

import entities.AverageRatings;
import entities.User;
import entities.UserList;
import java.util.List;

public class RankInteractor implements RankInputBoundary{
    // The only input accepted are "Average Rating" , "Total Followers", "Total Number of Recipe"
    final RankOutputBoundary rankOutputBoundary;
    UserList userList;
    public RankInteractor(RankOutputBoundary rankOutputBoundary) {
        this.rankOutputBoundary = rankOutputBoundary;
    }
    @Override
    public RankResponseModel sorting(RankRequestModel requestModel) {
        List<User> users = userList.getAllUser();
        // import all users for user
        switch (requestModel.getRanking()) {
            case "Average Rating": {
                // sort based on avg rating
                users.sort(User.UserAvgRating);
                RankResponseModel rankResponseModel = new RankResponseModel(requestModel.getRanking(), users);
                return rankOutputBoundary.prepareSuccessView(rankResponseModel);
            }
            case "Total Followers": {
                // sort based on total followers
                users.sort(User.UserFollowerComparator);
                RankResponseModel rankResponseModel = new RankResponseModel(requestModel.getRanking(), users);
                return rankOutputBoundary.prepareSuccessView(rankResponseModel);
            }
            case "Total Number of Recipe": {
                // sort based on # of recipe
                users.sort(User.UserTotalRecipe);
                RankResponseModel rankResponseModel = new RankResponseModel(requestModel.getRanking(), users);
                return rankOutputBoundary.prepareSuccessView(rankResponseModel);
            }
        }
        return rankOutputBoundary.prepareFailView("Can not identify this rank. Please choose one of the following options: Average Rating, Total Followers, Total Number of Recipe");
    }
}

