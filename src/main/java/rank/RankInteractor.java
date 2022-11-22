package rank;

import entities.Rank;
import entities.User;
import entities.UserList;

import java.util.List;

public class RankInteractor implements RankInputBoundary{
    // The only input accepted are "Average Rating" , "Total Followers", "Total Number of Recipe"
    final RankOutputBoundary rankOutputBoundary;

    /**
     *
     * Returns a list of the sorted Users based on the variable chosen
     * by the user.
     *
     * @param rankOutputBoundary contains the requirements needed for the model to work
     */
    public RankInteractor(RankOutputBoundary rankOutputBoundary) {
        this.rankOutputBoundary = rankOutputBoundary;
    }
    @Override
    public RankResponseModel sortUsers(RankRequestModel requestModel) {
        // stores all the Users in a list
        UserList userList = new UserList();
        List<User> users = userList.getAllUser();
        // Return an error if no users have been registered
        if (users.isEmpty()){
            return rankOutputBoundary.prepareFailView("There are no users!");
        }
        // arraylist -> array
        User[] totalUsers = new User[users.size()];
        users.toArray(totalUsers);

        // sort
        RankSorter rankSorter = null;

        switch (requestModel.getRanking()) {
            case "average rating": {
                // sort based on avg rating
                rankSorter = new AvgRatingSorter();
                break;}
            case "total number of recipe": {
                // sort based on # of recipe
                rankSorter = new TotalNumRecipeSorter();
                break;}
            default: {
                // sort based on total followers
                rankSorter = new TotalFollowersSorter();
                break;}
        }
        rankSorter.sort(totalUsers);
        return rankOutputBoundary.prepareSuccessView(new RankResponseModel(requestModel.getRanking(), totalUsers));
    }
}

