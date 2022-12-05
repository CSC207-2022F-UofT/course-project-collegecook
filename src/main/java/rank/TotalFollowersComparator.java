package rank;

import entities.User;

import java.util.Comparator;

public class TotalFollowersComparator implements Comparator<User> {
    /**
     * Sorts users based on the total followers
     *
     * @param o1 a user that has a total number of followers
     * @param o2 a user that has a total number of followers
     */
    @Override
    public int compare(User o1, User o2) {
        return o2.GetNumberOfFollowers() - o1.GetNumberOfFollowers();
    }
}
