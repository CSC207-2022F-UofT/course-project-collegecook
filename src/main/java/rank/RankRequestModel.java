package rank;

public class RankRequestModel {
    private final String ranking;

    /**
     * Constructor for RankRequestModel. Takes in a ranking which
     * contains the variable chosen by the user to sort the other
     * Users.
     *
     * @param ranking contains variable chosen by the user to sort the other
     *      * Users
     */
    public RankRequestModel(String ranking) {
        this.ranking = ranking;
    }

    /**
     * A getter function that returns the variable chosen by
     * the user.
     */
    public String getRanking() {
        return this.ranking;
    }

}
