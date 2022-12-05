package rank;

import entities.User;

import java.util.ArrayList;
import java.util.List;

public class RankResponseModel {
    String rank;
    ArrayList<String> users;
    /**
     *
     * Constructor for RankResponseModel. Takes in a string which
     * contains the variable used to rank the users. Also takes in
     * a list of all the sorted users based on the rank.
     *
     * @param rank contains the variable used to sort Users
     * @param rank contains the sorted list of users
     */
    public RankResponseModel(String rank, ArrayList<String> users) {
        this.rank = rank;
        this.users = users;
    }
    /**
     * A getter function that returns the variable chosen by
     * the user.
     */
    public String getRank() {
        return rank;
    }
    /**
     * A getter function that returns the sorted list of users.
     */
    public ArrayList<String> getUsers() {
        return users;
    }
    /**
     * A setter function that sets rank
     */
    public void setRank(String rank) {
        this.rank = rank;
    }
    /**
     * A setter function that sets users
     */
    public void setUsers(ArrayList<String> users) {
        this.users = users;
    }
}
