    package rank;

public class RankController {
    final RankInputBoundary rankInput;
    /**
     *
     * Constructor for RankController. Takes in a RankInputBoundary
     * to set the boundaries for the input.
     *
     * @param accountGateway contains the sort function that needs
     *                       to be implemented
     */
    public RankController(RankInputBoundary accountGateway) {
        this.rankInput = accountGateway;
    }

    /**
     *
     * Decide the use case based on variable inputted.
     * This method returns RankResponseModel which contains
     * information stored by the user. Return the action
     * response for the model.
     *
     * @param ranking variable chosen by the user to sort other Users
     */
    RankResponseModel sort(String ranking) {
        ranking = ranking.toLowerCase().strip();
        RankRequestModel requestModel = new RankRequestModel(ranking);

        return rankInput.sort(requestModel);
    }
}
