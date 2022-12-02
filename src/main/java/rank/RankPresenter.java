package rank;


public class RankPresenter implements RankOutputBoundary{
    RankResultBox rankResultBox;

    /**
     * A method that contains a success method that is implemented
     * for the model to output the success message with the sorted list.
     *
     * @param rank contains the sorted Users list
     */
    public void prepareSuccessView(RankResponseModel rank){
        rankResultBox.success(rank.getUsers());}
        // return "Success! Here are the users ranked by: " + rank.getRank() + "\n" + Arrays.toString(rank.getUsers());}

    /**
     * A method that contains a fail method that is implemented
     * for the model to output the failed sorting message.
     *
     * @param error contains the information on the error
     */

    public void prepareFailView(String error){
        rankResultBox.failure(error);
    }
    /**
     * A method that returns the response of the model to the user
     *
     * @param rankResultBox contains the information that is going to be displayed
     */
    public void setUI(RankResultBox rankResultBox){
        this.rankResultBox = rankResultBox;
    }
}

