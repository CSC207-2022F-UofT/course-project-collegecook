package rank;

import entities.User;

public interface RankSorter {
    /**
     * A method outputs the successfully sorted list of users
     *
     * @param users contains the sorted list of users that need to be sorted
     */
    void sort(User[] users);
}
