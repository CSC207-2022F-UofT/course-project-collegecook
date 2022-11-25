package rank;

import entities.User;

public interface RankResultBox {
    void success(User[] users);

    /**
     * show failure view with no recipes found
     */
    void failure(String error);
}
