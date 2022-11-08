package Rank;


public class RankInteractor implements RankInputBoundary{

    final RankPresenter rankPresenter;
    public RankInteractor(RankPresenter rankPresenter) {
        this.rankPresenter = rankPresenter;
    }
    @Override
    public RankResponseModel sort(RankRequestModel requestModel) {
        if(requestModel.getRanking().equals("Average Rating")){

        }
        else if(requestModel.getRanking().equals("Total Followers")){

        }
        else if(requestModel.getRanking().equals("Total Number of Recipe")){
            UserRegisterResponseModel accountResponseModel = new UserRegisterResponseModel(user.getName(), now.toString());

        }
        else{
            return userPresenter.prepareFailView("Can not identify this rank. Please choose one of the following options: Average Rating, Total Followers, Total Number of Recipe");
        }
        return userPresenter.prepareSuccessView(accountResponseModel);
    }





    }


}
