package rank;

import entities.Profile;
import entities.User;
import login.UserRepoImpl;
import profile.ProfileInteractor;
import profile.ProfileOutputBoundary;
import profile.ProfilePresenter;
import profile.ProfileRepoImpl;

import java.io.IOException;
import java.util.Comparator;
import java.util.List;

public class TotalNumRecipeComparator implements Comparator<Profile> {
    /**
     * Sorts users based on the total number od recipes
     *
     * @param o1 a user that has a total number of recipes
     * @param o2 a user that has a total number of recipes
     */
    @Override
    public int compare(Profile o1, Profile o2) {
        int totalRecipe1 = o1.getCreated().size();
        int totalRecipe2 = o2.getCreated().size();
        return totalRecipe2 - totalRecipe1;
    }

}
