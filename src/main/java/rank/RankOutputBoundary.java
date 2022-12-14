package rank;

public interface RankOutputBoundary {
    /**
     * A method that contains a success method that needs to be implemented
     * for the model to output the success message with the sorted list.
     *
     * @param rank contains the sorted Users list
     */
    void prepareSuccessView(RankResponseModel rank);
    /**
     * A method that contains a fail method that needs to be implemented
     * for the model to output the failed sorting message.
     *
     * @param error contains the information on the error
     */
    void prepareFailView(String error);
    void setUI(RankResultBox rankResultBox);
}
