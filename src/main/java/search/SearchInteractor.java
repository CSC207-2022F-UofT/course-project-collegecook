package search;

import entities.Recipe;
import entities.RecipeList;
import recipe.RecipeRepoGateway;
import java.util.ArrayList;

//Use Case layer
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

    /**
     * Searches for recipes that match the given search criteria, in the chosen sort type and order
     * @param requestModel the given search criteria (keyword, cuisine, ingredients, time), sort type, and whether to sort by ascending
     */
    @Override
    public void getSearchResults(SearchRequestModel requestModel) {
        // get all recipes
        RecipeList recipes = recipeRepoGateway.getRecipeList();

        // search for recipes that match search criteria
        ArrayList<Recipe> matchingRecipes = new ArrayList<>();

        for (Recipe recipe : recipes){
            boolean hasName = requestModel.getName().length() == 0 || recipe.getRecipeName().contains(requestModel.getName());
            boolean isCuisine = requestModel.getCuisine().length() == 0 || recipe.getCuisine().equals(requestModel.getCuisine());
            boolean hasIngredients = requestModel.getIngredients().size() == 0 ||recipe.getIngredients().containsAll(requestModel.getIngredients());
            boolean lessThanTime = requestModel.getTimeInMin() == 0 || recipe.getTime() <= requestModel.getTimeInMin();

            if (hasName && isCuisine && hasIngredients && lessThanTime){
                matchingRecipes.add(recipe);
            }
        }

        // no matching recipes found, prepare failure view
        if (matchingRecipes.isEmpty()){
            searchOutputBoundary.prepareFailureView("No matching recipes were found");
        }

        // matching recipes found
        // change arraylist to array for sorting
        Recipe[] foundRecipes = new Recipe[matchingRecipes.size()];
        foundRecipes = matchingRecipes.toArray(foundRecipes);

        // sort array (based on chosen sort type)
        RecipeSorter recipeSorter = getRecipeSorter(requestModel.getSortType());
        recipeSorter.sort(foundRecipes, requestModel.isSortByAscending());

        // prepare success view
        searchOutputBoundary.prepareSuccessView(new SearchResponseModel(foundRecipes,requestModel));
    }

    /**
     * helper method to get RecipeSorter based on chosen sort type
     * @param sortType chosen sort type
     * @return appropriate RecipeSorter
     */
    private RecipeSorter getRecipeSorter(String sortType){
        switch (sortType) {
            case "r": {
                return new AverageRatingRecipeSorter();
            }
            case "n": {
                return new NumReviewsRecipeSorter();
            }
            case "t": {
                return new TimeNeededRecipeSorter();
            }
            default:
                return new AverageRatingRecipeSorter();
        }
    }
}
