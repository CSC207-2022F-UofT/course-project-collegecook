package rank;

import entities.*;
import login.UserRepoImpl;
import recipe.RecipeReadWriter;
import recipe.RecipeRepoGateway;
import review.UpdateAverageRating;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class RankInteractor implements RankInputBoundary{
    // The only input accepted are "Average Rating" , "Total Followers", "Total Number of Recipe"
    final RankOutputBoundary rankOutputBoundary;
    private final RecipeRepoGateway rrg = RecipeReadWriter.getRecipeRepo();

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
    public int allCreatedRanking(String username) throws IOException {
        RecipeList allRecipe = rrg.getRecipeList();
        ArrayList<Recipe> recipeList = new ArrayList<>();
        for (Recipe r: allRecipe){
            if (r.getCreator().equals(username)){
                recipeList.add(r);
            }
        }
        if(recipeList.isEmpty()){
            return 0;
        }
        return recipeList.size();
    }
    @Override
    public RankResponseModel sortUsers(RankRequestModel requestModel) throws IOException {
        // stores all the Users in a list
        List<User> users = UserRepoImpl.getUserRepoImpl().getAllUser().getAllUser();
        // arraylist -> array
        User[] totalUsers = new User[users.size()];
        users.toArray(totalUsers);
        // Final array
        ArrayList<String> finalList = new ArrayList<>();
        // Return an error if no users have been registered
        if (users.isEmpty()){
            rankOutputBoundary.prepareFailView("There are no users!");
        }
        switch (requestModel.getRanking()) {
            case "average rating": {
                // sort based on avg rating
                Arrays.sort(totalUsers, new AvgRatingComparator());
                for(User user: totalUsers){
                    AverageRatings averageRatings = UpdateAverageRating.loadRatingDatabase();
                    double userAvgRating1 = averageRatings.getAverageRating(user.getUsername());
                    String returns = userAvgRating1 + "-" + user.getUsername();
                    finalList.add(returns);
                }
                break;}
            case "total number of recipe": {
                // sort based on # of recipe
                Arrays.sort(totalUsers, new TotalNumRecipeComparator());
                for(User user: totalUsers){
                    int userAvgRating1 = allCreatedRanking(user.getUsername());
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
