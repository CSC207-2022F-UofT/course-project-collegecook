package rank;

public interface RankPresenter {
    RankResponseModel prepareSuccessView(RankResponseModel rank);
    RankResponseModel prepareFailView(String error);
}

