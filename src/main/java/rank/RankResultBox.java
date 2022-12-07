package rank;



import java.util.ArrayList;

public interface RankResultBox {
    /**
     * A method outputs the successfully sorted list of users
     *
     * @param users contains the sorted list of userss
     */
    void success(ArrayList<String> users, String rank);

    /**
     * A method outputs the successfully sorted list of users
     *
     * @param error contains error found
     */
    void failure(String error);
}
