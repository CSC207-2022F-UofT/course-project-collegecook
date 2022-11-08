package rank;
import Entities.User;


public class RankInteractor implements RankInputBoundary{

    final RankPresenter rankPresenter;
    public RankInteractor(RankPresenter rankPresenter) {
        this.rankPresenter = rankPresenter;
    }
    @Override
    public RankResponseModel sort(RankRequestModel requestModel) {
        // String[] users;
        // import all users for user
        if(requestModel.getRanking().equals("Average Rating")){
            // sort based on avg rating
            //String[] sortedUsers;
            //RankResponseModel rankResponseModel = new RankResponseModel(requestModel.getRanking(), sortedUsers);
            //return rankPresenter.prepareSuccessView(rankResponseModel);
        }
        else if(requestModel.getRanking().equals("Total Followers")){
            // sort based on total followers
            //String[] sortedUsers;
            // for(User user: users){}
            //RankResponseModel rankResponseModel = new RankResponseModel(requestModel.getRanking(), sortedUsers);
            //return rankPresenter.prepareSuccessView(rankResponseModel);
        }
        else if(requestModel.getRanking().equals("Total Number of Recipe")){
            // sort based on # of recipe
            //String[] sortedUsers;
            //RankResponseModel rankResponseModel = new RankResponseModel(requestModel.getRanking(), sortedUsers);
            //return rankPresenter.prepareSuccessView(rankResponseModel);
        }
        return rankPresenter.prepareFailView("Can not identify this rank. Please choose one of the following options: Average Rating, Total Followers, Total Number of Recipe");
    }
    }



