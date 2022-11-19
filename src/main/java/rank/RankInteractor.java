package rank;

public class RankInteractor implements RankInputBoundary{

    // The only input accepted are "Average Rating" , "Total Followers", "Total Number of Recipe"
    final RankOutputBoundary rankOutputBoundary;
    public RankInteractor(RankOutputBoundary rankOutputBoundary) {
        this.rankOutputBoundary = rankOutputBoundary;
    }
    @Override
    public RankResponseModel sort(RankRequestModel requestModel) {
        // User[] users;
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
//    public void UserselectionSort(int[] arr, User[] users)
//    {
//        int pos;
//        int temp;
//        for (int i = 0; i < arr.length; i++)
//        {
//            pos = i;
//            for (int j = i+1; j < arr.length; j++)
//            {
//                if (arr[j] < arr[pos])                  //find the index of the minimum element
//                {
//                    pos = j;
//                }
//            }
//
//            temp = arr[pos];            //swap the current element with the minimum element
//            arr[pos] = arr[i];
//            users[pos] = users[i];
//            arr[i] = temp;
//        }
//    }
}

