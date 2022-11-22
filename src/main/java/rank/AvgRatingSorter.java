package rank;

import entities.User;

import java.util.Arrays;

public class AvgRatingSorter implements RankSorter{
    public void sort(User[] users) {
        Arrays.sort(users, new AvgRatingComparator());
    }

}
