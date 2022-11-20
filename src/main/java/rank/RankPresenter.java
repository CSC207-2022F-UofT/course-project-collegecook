package rank;

public class RankPresenter implements RankOutputBoundary{
    /**
     * A method that contains a success method that needs to be implemented
     * for the model to output the success message with the sorted list.
     *
     * @param rank contains the sorted Users list
     */
    public String prepareSuccessView(RankResponseModel rank){
        return "Successfully ranked the users by " + rank.getRank() + "\n Here is the list of the ranked " +
                "users in descending order" + rank.getUsers();}

    /**
     * A method that contains a fail method that needs to be implemented
     * for the model to output the failed sorting message.
     *
     * @param error contains the information on the error
     */

    public String prepareFailView(String error){
        return "Unable to sort the users based on " + error + "\n Please choose one of the following: \n " +
                "Average Rating , Total Followers, Total Number of Recipe";
    }
}

