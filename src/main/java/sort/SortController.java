package sort;

import entities.Recipe;

import java.util.ArrayList;

public class SortController {
    // Sort by time, averageRating, difficulty, number of ingredients
    SortInputBoundary userInput;

    public SortController(SortInputBoundary userInput){
        this.userInput = userInput;
    }

    public SortResponseModel sortRecipes(ArrayList<Recipe> recipesToBeSorted, String sortType, boolean sortByAscending){
        SortRequestModel requestModel = new SortRequestModel(recipesToBeSorted, sortType, sortByAscending);
        //TODO: Figure out what call here
        return userInput.sortRecipesByTimeNeeded(requestModel);
    }
}
