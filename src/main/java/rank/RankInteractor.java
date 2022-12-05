package rank;

import entities.*;
import login.UserRepoImpl;
import profile.ProfileInteractor;
import profile.ProfileOutputBoundary;
import profile.ProfilePresenter;
import profile.ProfileRepoImpl;

import javax.swing.*;
import java.io.IOException;
import java.lang.reflect.Array;
import java.util.ArrayList;
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
        List<User> users = UserRepoImpl.getUserRepoImpl().getAllUser().getAllUser();
        // arraylist -> array
        User[] totalUsers = new User[users.size()];
        users.toArray(totalUsers);
        // For total number of recipe
        List<Profile> profiles = ProfileRepoImpl.getPrl().getProfile();
        Profile[] totalProfile = new Profile[profiles.size()];
        profiles.toArray(totalProfile);
        // Final array
        ArrayList<String> finalList = new ArrayList<String>();
        // Return an error if no users have been registered
        if (users.isEmpty()){
            rankOutputBoundary.prepareFailView("There are no users!");
        }
        switch (requestModel.getRanking()) {
            case "average rating": {
                // sort based on avg rating
                Arrays.sort(totalUsers, new AvgRatingComparator());
                for(User user: users){
                    AverageRatings averageRatings = new AverageRatings();
                    double userAvgRating1 = averageRatings.getAverageRating(user.getUsername());
                    String returns = userAvgRating1 + "-" + user.getUsername();
                    finalList.add(returns);
                }
                break;}
            case "total number of recipe": {
                // sort based on # of recipe
                Arrays.sort(totalUsers, new TotalNumRecipeComparator());
//                Arrays.sort(totalProfile, new TotalNumRecipeComparator());
//                for(Profile profile: totalProfile){
//                    int recipe = profile.getCreated().size();
//                    String returns = recipe + "-" + profile.getUsername();
//                    finalList.add(returns);
//                }
                for(User user: totalUsers){
                    ProfileOutputBoundary profileOutputBoundary = new ProfilePresenter();
                    ProfileInteractor profileInteractor = new ProfileInteractor(profileOutputBoundary);
                    int userAvgRating1 = profileInteractor.allCreatedRanking(user.getUsername());
                    String returns = userAvgRating1 + "-" + user.getUsername();
                    finalList.add(returns);
                }
                break;}
            default: {
                // sort based on total followers
                Arrays.sort(totalUsers, new TotalFollowersComparator());
                for(User user: totalUsers){
                    Integer followers = user.GetNumberOfFollowers();
                    String returns = followers + "-" + user.getUsername();
                    finalList.add(returns);
                }
                break;}
        }
        rankOutputBoundary.prepareSuccessView(new RankResponseModel(requestModel.getRanking(), finalList));
        return new RankResponseModel(requestModel.getRanking(), finalList);
    }
}

