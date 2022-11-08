package Rank;



public class RankController {
    final RankInputBoundary rankInput;
    public RankController(RankInputBoundary accountGateway) {
        this.rankInput = accountGateway;
    }

    RankResponseModel sort(String ranking) {
        RankRequestModel requestModel = new RankRequestModel(ranking);

        return rankInput.sort(requestModel);
    }
}
