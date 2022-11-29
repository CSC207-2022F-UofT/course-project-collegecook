package search;

import entities.Recipe;
import entities.RecipeList;
import entities.ReviewDatabase;
import entities.UserList;
import login.UserGateWay;
import login.UserRepoImpl;
import org.junit.jupiter.api.*;
import recipe.*;
import review.ReviewDatabaseReadWriter;
import review.ReviewInteractor;
import static org.junit.jupiter.api.Assertions.*;
import java.io.IOException;
import java.util.ArrayList;

public class SearchInteractorTest {

    RecipeRepoGateway recipeRepoGateway;
    ReviewDatabaseReadWriter reviewDatabaseReadWriter;
    ReviewInteractor reviewInteractor;

    UserGateWay userGateWay;
    RecipeList tempRecipes;
    ReviewDatabase tempReviews;

    UserList tempUsers;

    /**
     * Saves current recipe database data in a temporary object, clear database for use in test cases
     * - Recipes are stored in recipe.sav file, accessed through RecipeReadWriter
     * Saves current review database data in a temporary object
     * - Reviews are stored in a review.sav file, accessed through ReviewInteractor
     */
    @BeforeEach
    void setup() throws IOException {
        recipeRepoGateway = RecipeReadWriter.getRecipeRepo();
        tempRecipes = recipeRepoGateway.getRecipeList();

        reviewDatabaseReadWriter = new ReviewDatabaseReadWriter();
        tempReviews = ReviewInteractor.loadReviewDatabase();

        userGateWay = UserRepoImpl.getUserRepoImpl();
        tempUsers = userGateWay.getAllUser();
    }

    /**
     * Put original recipes back into recipe database
     * Put original reviews back into review database
     */
    @AfterEach
    void teardown() throws IOException {
        recipeRepoGateway.saveRecipe(tempRecipes);
        recipeRepoGateway = null;
        tempRecipes = null;

        reviewDatabaseReadWriter.saveToFile("reviews.sav", tempReviews);
        tempReviews = null;

        userGateWay.saveUser(tempUsers);
        userGateWay = null;
        tempUsers = null;
    }

    /**
     * Tests if find search results according to ingredients and sort by average rating
     */
    @Test
    public void getSearchResultsSortAverageRating() throws IOException {
        // set up recipes and save to recipe database
        RecipeList recipes = new RecipeList();
        ArrayList<String> ingredients1 = new ArrayList<>();
        ingredients1.add("apple");
        ingredients1.add("flour");
        ingredients1.add("sugar");

        ArrayList<String> ingredients2 = new ArrayList<>();
        ingredients2.add("apple");
        ingredients2.add("sugar");

        ArrayList<String> ingredients3 = new ArrayList<>();
        ingredients3.add("meatball");
        ingredients3.add("tomato");
        ingredients3.add("pasta");

        Recipe recipe1 = new Recipe("apple pie", "blah apples", "french", ingredients1, 200, 20, 4, "bob"); // has sugar
        Recipe recipe2 = new Recipe("candy apple", "blah apple candy", "french", ingredients2, 300, 10, 4, "cat"); // has sugar
        Recipe recipe3 = new Recipe("spaghetti", "blah bananas", "italian", ingredients3, 100, 20, 30, "bob"); // no sugar

        recipes.add_recipe(recipe1.getRecipeName(), recipe1.getProcedure(), recipe1.getCuisine(), recipe1.getIngredients(), recipe1.getCalories(), recipe1.getTime(), recipe1.getDifficulty(), "bob");
        recipes.add_recipe(recipe2.getRecipeName(), recipe2.getProcedure(), recipe2.getCuisine(), recipe2.getIngredients(), recipe2.getCalories(), recipe2.getTime(), recipe2.getDifficulty(), "cat");
        recipes.add_recipe(recipe3.getRecipeName(), recipe3.getProcedure(), recipe3.getCuisine(), recipe3.getIngredients(), recipe3.getCalories(), recipe3.getTime(), recipe3.getDifficulty(), "bob");
        recipeRepoGateway.saveRecipe(recipes);

        // create users (since to create review, need to update user average ratings)
        UserList users = new UserList();
        users.AddAllUser("lei", "1234");
        users.AddAllUser("joe", "1234");
        users.AddAllUser("ang", "1234");

        userGateWay.saveUser(users);

        // reviews for each of the recipes
        reviewInteractor = new ReviewInteractor();
        reviewInteractor.createReview("lei", recipe1.getRecipeName(), 4);
        reviewInteractor.createReview("joe", recipe1.getRecipeName(), 5);
        reviewInteractor.createReview("ang", recipe1.getRecipeName(), 4); // recipe1 average rating = 4.3
        reviewInteractor.createReview("ang", recipe2.getRecipeName(), 5); // recipe2 average rating = 5
        reviewInteractor.createReview("lei", recipe3.getRecipeName(), 4); // recipe3 average rating = 4

        // create presenter with custom test results (instead of showing UI)
        SearchOutputBoundary searchPresenter = new SearchOutputBoundary() {
            @Override
            public void prepareSuccessView(SearchResponseModel searchResults) {
                assertEquals(searchResults.matchingRecipes.length, 2);
                assertEquals(searchResults.matchingRecipes[0], recipe2);
                assertEquals(searchResults.matchingRecipes[1], recipe1);
            }

            @Override
            public void prepareFailureView(String error) {
                System.out.println(error);
            }
        };


        // search for recipes with:
        // - ingredients has sugar, any name, cuisine, time.
        // - sorted in ascending order by average rating
        ArrayList<String> ingredients = new ArrayList<>();
        ingredients.add("sugar");
        SearchRequestModel searchRequestModel = new SearchRequestModel(
                "",
                "",
                ingredients,
                0,
                "r",
                true
        );

        // get search results
        SearchInteractor searchInteractor = new SearchInteractor(searchPresenter, recipeRepoGateway);
        searchInteractor.getSearchResults(searchRequestModel);
    }

//    /**
//     * Test for getting search results sorted by number of reviews
//     */
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
