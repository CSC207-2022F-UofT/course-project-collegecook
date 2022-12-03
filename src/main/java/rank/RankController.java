package rank;

public class RankController {
    final RankInputBoundary rankInput;
    /**
     *
     * Constructor for RankController. Takes in a RankInputBoundary
     * to set the boundaries for the input.
     *
     * @param rankInputBoundary contains the sort function that needs
     *                       to be implemented
     */
    public RankController(RankInputBoundary rankInputBoundary) {
        this.rankInput = rankInputBoundary;
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
    public void sorting(String ranking) {
        ranking = ranking.toLowerCase().strip();
        RankRequestModel requestModel = new RankRequestModel(ranking);
        rankInput.sortUsers(requestModel);
    }
}
