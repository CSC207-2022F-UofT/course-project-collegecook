package search;

import entities.Recipe;
import entities.RecipeList;
import recipe.RecipeRepoGateway;

import java.io.IOException;
import java.util.ArrayList;

public class SearchInteractor implements SearchInputBoundary{

    final SearchOutputBoundary searchOutputBoundary;
    final RecipeRepoGateway recipeRepoGateway;
    /**
     * interactor that searches for matching recipes and sorts in chosen order
     * @param searchOutputBoundary SearchOutputBoundary to interact with UI and display appropriate results
     * @param recipeRepoGateway RecipeRepoGateway that gets all recipes
     */
    public SearchInteractor(SearchOutputBoundary searchOutputBoundary, RecipeRepoGateway recipeRepoGateway) {
        this.searchOutputBoundary = searchOutputBoundary;
        this.recipeRepoGateway = recipeRepoGateway;
    }


    @Override
    public void getSearchResults(SearchRequestModel requestModel) throws IOException {
        // get all recipes
        RecipeList recipes = recipeRepoGateway.getRecipeList();

        // search for recipes that match search criteria
        ArrayList<Recipe> matchingRecipes = new ArrayList<>();

        for (Recipe recipe : recipes){
            boolean hasName = requestModel.getName().length() == 0 || recipe.getRecipeName().contains(requestModel.getName());
            boolean isCuisine = requestModel.getCuisine().length() == 0 || recipe.getCuisine().equals(requestModel.getCuisine());
            boolean hasIngredients = requestModel.getIngredients().size() == 0 ||recipe.getIngredients().containsAll(requestModel.getIngredients());
            //TODO: user does not input time, set default to 0
            boolean lessThanTime = requestModel.getTimeInMin() == 0 || recipe.getTime() <= requestModel.getTimeInMin();

            if (hasName && isCuisine && hasIngredients && lessThanTime){
                matchingRecipes.add(recipe);
            }
        }

        // if no matching recipes found, return failure view
        if (matchingRecipes.isEmpty()){
            searchOutputBoundary.prepareFailureView("No matching recipes were found");
        }

        // change arraylist to array for sorting
        Recipe[] foundRecipes = new Recipe[matchingRecipes.size()];
        foundRecipes = matchingRecipes.toArray(foundRecipes);

        // sort array, strategy design pattern
        RecipeSorter recipeSorter = null;

        switch (requestModel.getSortType()) {
            case "r": {
                recipeSorter = new AverageRatingRecipeSorter();
                break;
            }
            case "n": {
                recipeSorter = new NumReviewsRecipeSorter();
                break;

            }
            case "t": {
                recipeSorter = new TimeNeededRecipeSorter();
                break;
            }
            default:
                recipeSorter = new AverageRatingRecipeSorter();
                break;
        }
            recipeSorter.sort(foundRecipes, requestModel.isSortByAscending());
            searchOutputBoundary.prepareSuccessView(new SearchResponseModel(foundRecipes));
    }
}
