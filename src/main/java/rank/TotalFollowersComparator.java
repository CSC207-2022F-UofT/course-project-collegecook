package rank;

import entities.User;

import java.util.Comparator;

public class TotalFollowersComparator implements Comparator<User> {
    @Override
    public int compare(User o1, User o2) {
        int userFollowers1 = o1.GetNumberOfFollowers();
        int userFollowers2 = o2.GetNumberOfFollowers();
        return userFollowers1 - userFollowers2;
    }
}
