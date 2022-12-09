package rank;


import entities.User;


import java.io.IOException;
import java.util.Comparator;


public class TotalNumRecipeComparator implements Comparator<User> {
    /**
     * Sorts users based on the total number od recipes
     *
     * @param o1 a user that has a total number of recipes
     * @param o2 a user that has a total number of recipes
     */
    @Override
    public int compare(User o1, User o2) {
        RankOutputBoundary rankOutputBoundary = new RankPresenter();
        RankInteractor rankInteractor = new RankInteractor(rankOutputBoundary);
        int rep1;
        try {
            rep1 = rankInteractor.allCreatedRanking(o1.getUsername());
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        int rep2;
        try {
            rep2 = rankInteractor.allCreatedRanking(o2.getUsername());
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return rep2 - rep1;
    }

}