package rank;

public interface RankOutputBoundary {
    RankResponseModel prepareSuccessView(RankResponseModel rank);
    RankResponseModel prepareFailView(String error);
}

