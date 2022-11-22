package rank;

import entities.Profile;
import entities.User;

import java.util.Comparator;

public class TotalNumRecipeComparator implements Comparator<User> {


    @Override
    public int compare(User o1, User o2) {
        Profile profile1 = new Profile(o1.getUsername());
        Profile profile2 = new Profile(o2.getUsername());
        int userTotalrecipe1 = profile1.getCreated().size();
        int userTotalrecipe2 = profile2.getCreated().size();
        return userTotalrecipe1 - userTotalrecipe2;
    }

}
