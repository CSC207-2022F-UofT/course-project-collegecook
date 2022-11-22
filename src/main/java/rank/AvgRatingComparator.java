package rank;

import entities.AverageRatings;
import entities.User;

import java.util.Comparator;

public class AvgRatingComparator implements Comparator<User> {
    @Override
    public int compare(User o1, User o2) {
        AverageRatings averageRatings = new AverageRatings();
        double userAvgRating1 = averageRatings.getAverageRating(o1.getUsername());
        double userAvgRating2 = averageRatings.getAverageRating(o2.getUsername());
        double userAvgDiff = userAvgRating1-userAvgRating2;
        if(userAvgDiff>0){return 1;}
        if(userAvgDiff<0){return -1;}
        return 0;
        }
}
