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

public class TotalNumRecipeComparator implements Comparator<User> {
    /**
     * Sorts users based on the total number od recipes
     *
     * @param o1 a user that has a total number of recipes
     * @param o2 a user that has a total number of recipes
     */
    @Override
    public int compare(User o1, User o2) {
        ProfileOutputBoundary profileOutputBoundary = new ProfilePresenter();
        ProfileInteractor profileInteractor = new ProfileInteractor(profileOutputBoundary);
        int totalRecipe1 = 0;
        try {
            totalRecipe1 = profileInteractor.allCreatedRanking(o1.getUsername());
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        int totalRecipe2 = 0;
        try {
            totalRecipe2 = profileInteractor.allCreatedRanking(o2.getUsername());
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return totalRecipe2 - totalRecipe1;
    }

}
