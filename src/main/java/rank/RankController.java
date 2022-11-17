    package rank;

public class RankController {
    final RankInputBoundary rankInput;
    public RankController(RankInputBoundary accountGateway) {
        this.rankInput = accountGateway;
    }

    RankResponseModel sort(String ranking) {
        ranking = ranking.toLowerCase().strip();
        RankRequestModel requestModel = new RankRequestModel(ranking);

        return rankInput.sort(requestModel);
    }
}
