package Rank;

public interface RankPresenter {
    RankResponseModel prepareSuccessView(RankResponseModel rank);
    RankResponseModel prepareFailView(String error);
}

