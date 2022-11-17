    package rank;

public class RankController {
    final RankInputBoundary rankInput;
    /**
     *
     * Decide the use case based on input provided by the user.
     * This method calls the response model to start the ranking
     * process.
     *
     * @param accountGateway contains the sort function that needs
     *                       to be implemented
     */
    public RankController(RankInputBoundary accountGateway) {
        this.rankInput = accountGateway;
    }

    RankResponseModel sort(String ranking) {
        ranking = ranking.toLowerCase().strip();
        RankRequestModel requestModel = new RankRequestModel(ranking);

        return rankInput.sort(requestModel);
    }
}
