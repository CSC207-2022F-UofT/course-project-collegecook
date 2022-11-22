package rank;

import entities.User;

public class RankPresenter implements RankOutputBoundary{
    /**
     * A method that contains a success method that is implemented
     * for the model to output the success message with the sorted list.
     *
     * @param rank contains the sorted Users list
     */
    public RankResponseModel prepareSuccessView(RankResponseModel rank){
        return rank;}

    /**
     * A method that contains a fail method that is implemented
     * for the model to output the failed sorting message.
     *
     * @param error contains the information on the error
     */

    public RankResponseModel prepareFailView(String error){
        User[] errorUser = new User[0];
        return new RankResponseModel(error, errorUser );
    }
}

