package search;

import entities.Recipe;
import entities.RecipeList;
import entities.Review;
import org.junit.jupiter.api.*;
import recipe.*;

import static org.junit.jupiter.api.Assertions.*;

import java.io.IOException;
import java.util.ArrayList;

public class SearchInteractorTest {

    RecipeRepoGateway recipeRepoGateway;
    RecipeList temp;

    @BeforeEach
    void setup() throws IOException {
        recipeRepoGateway = RecipeReadWriter.getRecipeRepo();
        temp = recipeRepoGateway.getRecipeList();
    }

    @AfterEach
    void teardown() throws IOException {
        recipeRepoGateway.saveRecipe(temp);
        recipeRepoGateway = null;
    }

    @Test
    public void getSearchResultsSortAverageRating() throws IOException {
        // set up recipes
        Recipe[] recipes = new Recipe[3];
        ArrayList<String> ingredients1 = new ArrayList<String>();
        ingredients1.add("apple");
        ingredients1.add("flour");
        ingredients1.add("sugar");

        ArrayList<String> ingredients2 = new ArrayList<String>();
        ingredients2.add("apple");
        ingredients2.add("sugar");

        ArrayList<String> ingredients3 = new ArrayList<String>();
        ingredients3.add("meatball");
        ingredients3.add("tomato");
        ingredients3.add("pasta");

        Recipe recipe1 = new Recipe("apple pie", "blah apples", "french", ingredients1, 200, 20, 4, "bob");
        Recipe recipe2 = new Recipe("candy apple", "blah apple candy", "french", ingredients2, 300, 10, 4, "cat");
        Recipe recipe3 = new Recipe("spaghetti", "blah bananas", "italian", ingredients3, 100, 20, 30, "bob");

        recipes[0] = recipe1;
        recipes[1] = recipe2;
        recipes[2] = recipe3;

        // reviews for each of the recipes
        // average rating for each recipe should be: 4.3, 5, 4.
        // sorted order should be Recipe3 (spaghetti), Recipe1 (apple pie), Recipe2 (candy apple)
        Review[] reviews = new Review[5];
        Review review1a = new Review("lei", recipes[0], 4);
        Review review1b = new Review("joe", recipes[0], 5);
        Review review1c = new Review("ang", recipes[0], 4);
        Review review2a = new Review("ang", recipes[1], 5);
        Review review3a = new Review("lei", recipes[2], 4);

        // create presenter with custom results
        SearchOutputBoundary searchPresenter = new SearchOutputBoundary() {
            @Override
            public void prepareSuccessView(SearchResponseModel searchResults) {
                Recipe[] expectedResults = new Recipe[3];
                expectedResults[0] = recipe3;
                expectedResults[1] = recipe1;
                expectedResults[2] = recipe2;

                assertEquals(searchResults.matchingRecipes, expectedResults);
            }

            @Override
            public void prepareFailureView(String error) {
                System.out.println(error);
            }
        };

        SearchInteractor searchInteractor = new SearchInteractor(searchPresenter, recipeRepoGateway);

        // search request model
        ArrayList<String> ingredients = new ArrayList<String>();
        ingredients.add("sugar");

        SearchRequestModel searchRequestModel = new SearchRequestModel(
                "",
                "",
                ingredients,
                0,
                "r",
                true
        );

        RecipeInteractor recipeInteractor = new RecipeInteractor(new RecipePresenter(), recipeRepoGateway);
        recipeInteractor.createRecipe(new RecipeRequestModel(
                recipe1.getRecipeName(), recipe1.getProcedure(),
                recipe1.getCuisine(), recipe1.getIngredients(),
                recipe1.getCalories(), recipe1.getTime(), recipe1.getDifficulty(), "bob"));
        recipeInteractor.createRecipe(new RecipeRequestModel(
                recipe2.getRecipeName(), recipe2.getProcedure(),
                recipe2.getCuisine(), recipe2.getIngredients(),
                recipe2.getCalories(), recipe2.getTime(), recipe2.getDifficulty(), "cat"));
        recipeInteractor.createRecipe(new RecipeRequestModel(
                recipe3.getRecipeName(), recipe3.getProcedure(),
                recipe3.getCuisine(), recipe3.getIngredients(),
                recipe3.getCalories(), recipe3.getTime(), recipe3.getDifficulty(), "bob"));
        // get search results
        searchInteractor.getSearchResults(searchRequestModel);
    }

    /**
     * Test for getting search results sorted by number of reviews
     */
//    @Test
//    public void getSearchResultsSortNumReviews() throws IOException {
//        // set up objects
//        SearchInteractor searchInteractor = new SearchInteractor(searchPresenter, recipeRepoGateway);
//
//        ArrayList<String> ingredients = new ArrayList<String>();
//        ingredients.add("chicken");
//        ingredients.add("potato");
//        ingredients.add("tomato");
//
//        SearchRequestModel searchRequestModel = new SearchRequestModel(
//                "potato",
//                "chinese",
//                ingredients,
//                10,
//                "n",
//                true
//        );
//
//        // get search results
//        searchInteractor.getSearchResults(searchRequestModel);
//    }
//
//    /**
//     * Test for getting search results sorted by time needed
//     */
//    @Test
//    public void getSearchResultsSortTimeNeeded() throws IOException {
//        SearchInteractor searchInteractor = new SearchInteractor(searchPresenter, recipeRepoGateway);
//
//        ArrayList<String> ingredients = new ArrayList<String>();
//        ingredients.add("chicken");
//        ingredients.add("potato");
//        ingredients.add("tomato");
//
//        SearchRequestModel searchRequestModel = new SearchRequestModel(
//                "potato",
//                "chinese",
//                ingredients,
//                10,
//                "t",
//                true
//        );
//
//        // get search results
//        searchInteractor.getSearchResults(searchRequestModel);
//    }
//
//    /**
//     * Test for getting search results sorted in descending order
//     */
//    @Test
//    public void getSearchResultsSortByDescending() throws IOException {
//        SearchInteractor searchInteractor = new SearchInteractor(searchPresenter, recipeRepoGateway);
//
//        ArrayList<String> ingredients = new ArrayList<String>();
//        ingredients.add("chicken");
//        ingredients.add("potato");
//        ingredients.add("tomato");
//
//        SearchRequestModel searchRequestModel = new SearchRequestModel(
//                "potato",
//                "chinese",
//                ingredients,
//                10,
//                "t",
//                false
//        );
//
//        // get search results
//        searchInteractor.getSearchResults(searchRequestModel);
//    }
//
//    /**
//     * Test for no results
//     */
//    @Test
//    public void getSearchResultsNoResults() throws IOException {
//        // set up objects
//        SearchInteractor searchInteractor = new SearchInteractor(searchPresenter, recipeRepoGateway);
//
//        ArrayList<String> ingredients = new ArrayList<String>();
//        ingredients.add("chicken");
//        ingredients.add("potato");
//        ingredients.add("tomato");
//
//        SearchRequestModel searchRequestModel = new SearchRequestModel(
//                "turkey",
//                "chinese",
//                ingredients,
//                10,
//                "t",
//                false
//        );
//
//        // get search results
//        searchInteractor.getSearchResults(searchRequestModel);
//    }
//
//    /**
//     * Test average rating comparator for two recipes
//     */
//    @Test
//    public void testAverageRatingComparator() throws IOException {
//        // set up objects
//        ArrayList<String> ingredients = new ArrayList<String>();
//        ingredients.add("chicken");
//        ingredients.add("potato");
//        ingredients.add("tomato");
//
//        Recipe r1 = new Recipe(
//                "potato pancakes",
//                "1. fry potatoes, 2. serve",
//                "chinese",
//                ingredients,
//        250,
//        10,
//        3,
//        "bob"
//        );
//
//        ArrayList<String> ingredients2 = new ArrayList<String>();
//        ingredients.add("tomato");
//        ingredients.add("leafy greens");
//
//        Recipe r2 = new Recipe(
//                "tomato salad",
//                "1. mix tomatoes and leafy greens 2. add vinegar",
//                "chinese",
//                ingredients2,
//                300,
//                20,
//                2,
//                "bobbette"
//        );
//
//        Recipe[] recipes = new Recipe[2];
//        recipes[0] = r1;
//        recipes[1] = r2;
//
//        RecipeSorter recipeSorter = new TimeNeededRecipeSorter();
//        recipeSorter.sort(recipes, true);
//        // compare
//        Assertions.assertEquals("tomato salad", recipes[1].getRecipeName());
//
//    }
}
