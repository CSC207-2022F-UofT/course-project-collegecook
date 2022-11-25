package rank;

import entities.User;

import java.util.Arrays;

public class RankPresenter implements RankOutputBoundary{
    /**
     * A method that contains a success method that is implemented
     * for the model to output the success message with the sorted list.
     *
     * @param rank contains the sorted Users list
     */
    public String prepareSuccessView(RankResponseModel rank){
        return "Success! Here are the users ranked by: " + rank.getRank() + "\n" + Arrays.toString(rank.getUsers());}

    /**
     * A method that contains a fail method that is implemented
     * for the model to output the failed sorting message.
     *
     * @param error contains the information on the error
     */

    public String prepareFailView(String error){
        return error;
    }
}

