package rank;

import entities.Rank;
import entities.User;
import entities.UserList;
import login.UserRepoImpl;

import java.io.IOException;
import java.lang.reflect.Array;
import java.util.Arrays;
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
    public RankResponseModel sortUsers(RankRequestModel requestModel) throws IOException {
        // stores all the Users in a list
        UserRepoImpl userRepo = new UserRepoImpl();
        List<User> users = userRepo.getAllUser().getAllUser();
//        UserList userList = new UserList();
//        List<User> users = userList.getAllUser();
        // Return an error if no users have been registered
        if (users.isEmpty()){
            rankOutputBoundary.prepareFailView("There are no users!");
        }
        // arraylist -> array
        User[] totalUsers = new User[users.size()];
        users.toArray(totalUsers);

        switch (requestModel.getRanking()) {
            case "average rating": {
                // sort based on avg rating
                Arrays.sort(totalUsers, new AvgRatingComparator());
                break;}
            case "total number of recipe": {
                // sort based on # of recipe
                Arrays.sort(totalUsers, new TotalNumRecipeComparator());
                break;}
            default: {
                // sort based on total followers
                Arrays.sort(totalUsers, new TotalFollowersComparator());
                break;}
        }
        rankOutputBoundary.prepareSuccessView(new RankResponseModel(requestModel.getRanking(), totalUsers));
        return new RankResponseModel(requestModel.getRanking(), totalUsers);
    }
}

