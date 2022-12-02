package rank;

import entities.User;

public interface RankResultBox {
    /**
     * A method outputs the successfully sorted list of users
     *
     * @param users contains the sorted list of userss
     */
    void success(User[] users);

    /**
     * A method outputs the successfully sorted list of users
     *
     * @param error contains error found
     */
    void failure(String error);
}
