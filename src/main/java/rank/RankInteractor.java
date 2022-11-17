package rank;

public class RankInteractor implements RankInputBoundary{

    // The only input accepted are "Average Rating" , "Total Followers", "Total Number of Recipe"
    final RankOutputBoundary rankOutputBoundary;
    public RankInteractor(RankOutputBoundary rankOutputBoundary) {
        this.rankOutputBoundary = rankOutputBoundary;
    }
    @Override
    public RankResponseModel sort(RankRequestModel requestModel) {
        // String[] users;
        // import all users for user
        if(requestModel.getRanking().equals("Average Rating")){
            // sort based on avg rating
            // String[] sortedUsers;
            // RankResponseModel rankResponseModel = new RankResponseModel(requestModel.getRanking(), sortedUsers);
            // return rankPresenter.prepareSuccessView(rankResponseModel);
        }
        else if(requestModel.getRanking().equals("Total Followers")){
            // sort based on total followers
            // String[] sortedUsers;
            // RankResponseModel rankResponseModel = new RankResponseModel(requestModel.getRanking(), sortedUsers);
            // return rankPresenter.prepareSuccessView(rankResponseModel);
        }
        else if(requestModel.getRanking().equals("Total Number of Recipe")){
            // sort based on # of recipe
            // String[] sortedUsers;
            // RankResponseModel rankResponseModel = new RankResponseModel(requestModel.getRanking(), sortedUsers;
            // return rankPresenter.prepareSuccessView(rankResponseModel);
        }
        return rankOutputBoundary.prepareFailView("Can not identify this rank. Please choose one of the following options: Average Rating, Total Followers, Total Number of Recipe");


    }
}

