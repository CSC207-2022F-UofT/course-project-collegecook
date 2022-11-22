package rank;

import entities.User;

import java.util.Arrays;

public class TotalNumRecipeSorter implements RankSorter{
    public void sort(User[] users) {
        Arrays.sort(users, new TotalNumRecipeComparator());
    }

}
