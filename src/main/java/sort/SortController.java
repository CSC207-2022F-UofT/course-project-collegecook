package sort;

import entities.Recipe;

import java.util.ArrayList;

public class SortController {
    SortInputBoundary userInput;

    /**
     * Constructs a SortController object
     * @param userInput the SortInteractor that implements the SortInputBoundary interface
     */
    public SortController(SortInputBoundary userInput){
        this.userInput = userInput;
    }

    /**
     * //FIXME: How to write javadoc for Controller classes?
     * @param recipesToBeSorted list of recipes to be sorted
     * @param sortType the way that recipes are sorted by ("r" = average rating, "n" = number of ratings, "t" = time needed)
     * @param sortByAscending if true, sort recipes from lowest to highest score based on sortType. if false, vice versa.
     * @return //FIXME: What do Controller classes return?
     */
    public SortResponseModel sortRecipes(ArrayList<Recipe> recipesToBeSorted, String sortType, boolean sortByAscending){
        SortRequestModel requestModel = new SortRequestModel(recipesToBeSorted, sortType, sortByAscending);
        //FIXME: Figure out what method to call here
        return userInput.sortRecipesByTimeNeeded(requestModel);
    }
}
