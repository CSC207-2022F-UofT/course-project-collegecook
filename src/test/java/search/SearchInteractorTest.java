package search;

import entities.Recipe;
import entities.RecipeList;
import org.junit.jupiter.api.*;
import recipe.RecipeRepoGateway;

import java.io.IOException;
import java.util.ArrayList;

public class SearchInteractorTest {

    /**
     * Test for getting search results sorted by average rating
     */
    @Test
    public void getSearchResultsSortAverageRating() throws IOException {
        // set up objects
        RecipeRepoGateway recipeRepoGateway = new RecipeRepoGateway() {
            @Override
            public RecipeList getRecipeList(){
                return null;
            }

            @Override
            public void saveRecipe(RecipeList recipeList){

            }
        };
        SearchPresenter searchPresenter = new SearchPresenter(){
            @Override
            public SearchResponseModel prepareResultsView(SearchResponseModel searchResponseModel) {
                return null;
            }
            @Override
            public SearchResponseModel prepareFailureView(String error) {
                return null;
            }

        };
        SearchInteractor searchInteractor = new SearchInteractor(searchPresenter, recipeRepoGateway);

        ArrayList<String> ingredients = new ArrayList<String>();
        ingredients.add("chicken");
        ingredients.add("potato");
        ingredients.add("tomato");

        SearchRequestModel searchRequestModel = new SearchRequestModel(
                "potato",
                "chinese",
                ingredients,
                10,
                "r",
                true
        );

        // get search results
        searchInteractor.getSearchResults(searchRequestModel);
    }

    /**
     * Test for getting search results sorted by number of reviews
     */
    @Test
    public void getSearchResultsSortNumReviews() throws IOException {
        // set up objects
        RecipeRepoGateway recipeRepoGateway = new RecipeRepoGateway() {
            @Override
            public RecipeList getRecipeList(){
                return null;
            }

            @Override
            public void saveRecipe(RecipeList recipeList) {

            }
        };
        SearchPresenter searchPresenter = new SearchPresenter(){
            @Override
            public SearchResponseModel prepareResultsView(SearchResponseModel searchResponseModel) {
                return null;
            }
            @Override
            public SearchResponseModel prepareFailureView(String error) {
                return null;
            }

        };
        SearchInteractor searchInteractor = new SearchInteractor(searchPresenter, recipeRepoGateway);

        ArrayList<String> ingredients = new ArrayList<String>();
        ingredients.add("chicken");
        ingredients.add("potato");
        ingredients.add("tomato");

        SearchRequestModel searchRequestModel = new SearchRequestModel(
                "potato",
                "chinese",
                ingredients,
                10,
                "n",
                true
        );

        // get search results
        searchInteractor.getSearchResults(searchRequestModel);
    }

    /**
     * Test for getting search results sorted by time needed
     */
    @Test
    public void getSearchResultsSortTimeNeeded() throws IOException {
        // set up objects
        RecipeRepoGateway recipeRepoGateway = new RecipeRepoGateway() {
            @Override
            public RecipeList getRecipeList(){
                return null;
            }

            @Override
            public void saveRecipe(RecipeList recipeList) {

            }
        };
        SearchPresenter searchPresenter = new SearchPresenter(){
            @Override
            public SearchResponseModel prepareResultsView(SearchResponseModel searchResponseModel) {
                return null;
            }
            @Override
            public SearchResponseModel prepareFailureView(String error) {
                return null;
            }

        };
        SearchInteractor searchInteractor = new SearchInteractor(searchPresenter, recipeRepoGateway);

        ArrayList<String> ingredients = new ArrayList<String>();
        ingredients.add("chicken");
        ingredients.add("potato");
        ingredients.add("tomato");

        SearchRequestModel searchRequestModel = new SearchRequestModel(
                "potato",
                "chinese",
                ingredients,
                10,
                "t",
                true
        );

        // get search results
        searchInteractor.getSearchResults(searchRequestModel);
    }

    /**
     * Test for getting search results sorted in descending order
     */
    @Test
    public void getSearchResultsSortByDescending() throws IOException {
        // set up objects
        RecipeRepoGateway recipeRepoGateway = new RecipeRepoGateway() {
            @Override
            public RecipeList getRecipeList(){
                return null;
            }

            @Override
            public void saveRecipe(RecipeList recipeList) {

            }
        };
        SearchPresenter searchPresenter = new SearchPresenter(){
            @Override
            public SearchResponseModel prepareResultsView(SearchResponseModel searchResponseModel) {
                return null;
            }
            @Override
            public SearchResponseModel prepareFailureView(String error) {
                return null;
            }

        };
        SearchInteractor searchInteractor = new SearchInteractor(searchPresenter, recipeRepoGateway);

        ArrayList<String> ingredients = new ArrayList<String>();
        ingredients.add("chicken");
        ingredients.add("potato");
        ingredients.add("tomato");

        SearchRequestModel searchRequestModel = new SearchRequestModel(
                "potato",
                "chinese",
                ingredients,
                10,
                "t",
                false
        );

        // get search results
        searchInteractor.getSearchResults(searchRequestModel);
    }

    /**
     * Test for no results
     */
    @Test
    public void getSearchResultsNoResults() throws IOException {
        // set up objects
        RecipeRepoGateway recipeRepoGateway = new RecipeRepoGateway() {
            @Override
            public RecipeList getRecipeList(){
                return null;
            }

            @Override
            public void saveRecipe(RecipeList recipeList) {

            }
        };
        SearchPresenter searchPresenter = new SearchPresenter(){
            @Override
            public SearchResponseModel prepareResultsView(SearchResponseModel searchResponseModel) {
                return null;
            }
            @Override
            public SearchResponseModel prepareFailureView(String error) {
                return null;
            }

        };
        SearchInteractor searchInteractor = new SearchInteractor(searchPresenter, recipeRepoGateway);

        ArrayList<String> ingredients = new ArrayList<String>();
        ingredients.add("chicken");
        ingredients.add("potato");
        ingredients.add("tomato");

        SearchRequestModel searchRequestModel = new SearchRequestModel(
                "turkey",
                "chinese",
                ingredients,
                10,
                "t",
                false
        );

        // get search results
        searchInteractor.getSearchResults(searchRequestModel);
    }

    /**
     * Test average rating comparator for two recipes
     */
    @Test
    public void testAverageRatingComparator() throws IOException {
        // set up objects
        ArrayList<String> ingredients = new ArrayList<String>();
        ingredients.add("chicken");
        ingredients.add("potato");
        ingredients.add("tomato");

        Recipe r1 = new Recipe(
                "potato pancakes",
                "1. fry potatoes, 2. serve",
                "chinese",
                ingredients,
        250,
        10,
        3,
        "bob"
        );

        ArrayList<String> ingredients2 = new ArrayList<String>();
        ingredients.add("tomato");
        ingredients.add("leafy greens");

        Recipe r2 = new Recipe(
                "tomato salad",
                "1. mix tomatoes and leafy greens 2. add vinegar",
                "chinese",
                ingredients2,
                300,
                20,
                2,
                "bobbette"
        );

        Recipe[] recipes = new Recipe[2];
        recipes[0] = r1;
        recipes[1] = r2;

        RecipeSorter recipeSorter = new TimeNeededRecipeSorter();
        recipeSorter.sort(recipes, true);
        // compare
        Assertions.assertEquals("tomato salad", recipes[1].getRecipeName());

    }
}
