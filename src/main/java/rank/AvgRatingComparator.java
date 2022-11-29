package rank;

import entities.AverageRatings;
import entities.User;

import java.io.PushbackInputStream;
import java.util.Arrays;
import java.util.Comparator;

public class AvgRatingComparator implements Comparator<User> {
//    @Override
//    public int compare(User o1, User o2) {
//        AverageRatings averageRatings = new AverageRatings();
//        double userAvgRating1 = averageRatings.getAverageRating(o1.getUsername());
//        System.out.println(userAvgRating1);
//        double userAvgRating2 = averageRatings.getAverageRating(o2.getUsername());
//        System.out.println(userAvgRating2);
//        return  0;
//        //double userAvgDiff = userAvgRating1 - userAvgRating2;
////        if(userAvgDiff<0){return -1;}
////        else if(userAvgDiff>0){return 1;}
////        else {
////            return 0; }
//        }
        @Override
        public int compare(User o1, User o2) {
            String u1name = o1.getUsername();
            System.out.println(u1name);
            AverageRatings averageRatings = new AverageRatings();
            double userAvgRating1 = averageRatings.getAverageRating(o1.getUsername());
            System.out.println(userAvgRating1);
            double userAvgRating2 = averageRatings.getAverageRating(o2.getUsername());
            System.out.println(userAvgRating2);
            return  0;
            //double userAvgDiff = userAvgRating1 - userAvgRating2;
    //        if(userAvgDiff<0){return -1;}
    //        else if(userAvgDiff>0){return 1;}
    //        else {
    //            return 0; }


}

}
