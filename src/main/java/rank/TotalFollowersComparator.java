package rank;

import entities.User;

import java.util.Comparator;

public class TotalFollowersComparator implements Comparator<User> {
    @Override
    public int compare(User o1, User o2) {
//        int userFollowers1 = o1.GetNumberOfFollowers();
//        int userFollowers2 = o2.GetNumberOfFollowers();
//        System.out.println(Integer.compare(userFollowers1, userFollowers2));
//        return 0;
//        return userFollowers1 - userFollowers2;
        return o2.GetNumberOfFollowers() - o1.GetNumberOfFollowers();
    }
}
