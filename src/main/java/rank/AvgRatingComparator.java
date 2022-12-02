package rank;

import entities.AverageRatings;
import entities.User;

import java.io.PushbackInputStream;
import java.util.Arrays;
import java.util.Comparator;

public class AvgRatingComparator implements Comparator<User> {
    /**
     * Sorts users based on the average rating
     *
     * @param o1 a user that contains average rating for the recipe they have created
     * @param o2 a user that contains average rating for the recipe they have created
     */
    @Override
        public int compare(User o1, User o2) {
            AverageRatings averageRatings = new AverageRatings();
            double userAvgRating1 = averageRatings.getAverageRating(o1.getUsername());
            double userAvgRating2 = averageRatings.getAverageRating(o2.getUsername());
            double userAvgDiff = userAvgRating1 - userAvgRating2;
            if(userAvgDiff<0){return -1;}
            else if(userAvgDiff>0){return 1;}
            else {
                return 0; }


}

}
