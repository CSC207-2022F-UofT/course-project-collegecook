package search;

import entities.Recipe;
import entities.RecipeList;
import recipe.RecipeRepoGateway;

import java.io.IOException;
import java.util.ArrayList;

public class SearchInteractor implements SearchInputBoundary{

    final SearchPresenter searchPresenter;
    final RecipeRepoGateway recipeRepoGateway;
    /**
     * interactor that searches for matching recipes and sorts in chosen order
     * @param searchPresenter SearchPresenter to interact with UI and display appropriate results
     * @param recipeRepoGateway RecipeRepoGateway that gets all recipes
     */
    public SearchInteractor(SearchPresenter searchPresenter, RecipeRepoGateway recipeRepoGateway) {
        this.searchPresenter = searchPresenter;
        this.recipeRepoGateway = recipeRepoGateway;
    }


    @Override
    public SearchResponseModel getSearchResults(SearchRequestModel requestModel) throws IOException {
        // get all recipes
        RecipeList recipes = recipeRepoGateway.getRecipeList();

        // search for recipes that match search criteria
        ArrayList<Recipe> matchingRecipes = new ArrayList<>();

        for (Recipe recipe : recipes){
            boolean hasName = recipe.getRecipeName().contains(requestModel.name);
            boolean isCuisine = recipe.getCuisine().equals(requestModel.cuisine);
            boolean hasIngredients = recipe.getIngredients().containsAll(requestModel.ingredients);
            boolean lessThanTime = recipe.getTime() <= requestModel.timeInMin;

            if (hasName && isCuisine && hasIngredients && lessThanTime){
                matchingRecipes.add(recipe);
            }
        }

        // if no matching recipes found, return failure view
        if (matchingRecipes.isEmpty()){
            return searchPresenter.prepareFailureView("No matching recipes were found");
        }

        // change arraylist to array for sorting
        Recipe[] foundRecipes = new Recipe[matchingRecipes.size()];
        foundRecipes = matchingRecipes.toArray(foundRecipes);

        // sort array, strategy design pattern
        RecipeSorter recipeSorter = null;

        switch (requestModel.sortType) {
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
            recipeSorter.sort(foundRecipes, requestModel.sortByAscending);
            return searchPresenter.prepareResultsView(new SearchResponseModel(foundRecipes));

    }
}
