package entities;

import java.util.Comparator;
import java.util.List;

public class Rank {
    List<User> AllUser;

    public Rank(List<User> AllUser) {
        this.AllUser = AllUser;
    }
    public static Comparator<User> UserFollowerComparator = new Comparator<User>() {
        public int compare(User u1, User u2) {
            int userFollowers1 = u1.GetNumberOfFollowers();
            int userFollowers2 = u2.GetNumberOfFollowers();
            return userFollowers1 - userFollowers2;
        }};

    // Comparator for sorting the list by average rating
    public static Comparator<User> UserAvgRating = new Comparator<User>() {
        public int compare(User u1, User u2) {
            AverageRatings averageRatings = new AverageRatings();
            double userAvgRating1 = averageRatings.getAverageRating(u1.getUsername());
            double userAvgRating2 = averageRatings.getAverageRating(u2.getUsername());
            double userAvgDiff = userAvgRating1-userAvgRating2;
            if(userAvgDiff>0){return 1;}
            if(userAvgDiff<0){return -1;}
            return 0;
        }
    };

    // Comparator for sorting the list by Total Recipe
    public static Comparator<User> UserTotalRecipe = new Comparator<User>() {
        public int compare(User u1, User u2) {
            Profile profile1 = new Profile(u1.getUsername());
            Profile profile2 = new Profile(u2.getUsername());
            int userTotalrecipe1 = profile1.getCreated().size();
            int userTotalrecipe2 = profile2.getCreated().size();
            return userTotalrecipe1 - userTotalrecipe2;
        }
    };


}
