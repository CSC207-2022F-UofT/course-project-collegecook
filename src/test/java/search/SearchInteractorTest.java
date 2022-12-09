package search;

import entities.*;
import login.UserGateWay;
import login.UserRepoImpl;
import org.junit.jupiter.api.*;
import recipe.*;
import review.ReviewDatabaseReadWriter;
import review.ReviewInteractor;

import static org.junit.jupiter.api.Assertions.*;
import java.io.IOException;
import java.util.ArrayList;

// Test cases for SearchInteractor
public class SearchInteractorTest {

    RecipeRepoGateway recipeRepoGateway;
    RecipeList tempRecipes;

    UserGateWay userGateWay;
    UserList tempUsers;

    ReviewDatabaseReadWriter reviewDatabaseReadWriter;
    ReviewDatabase tempReviews;

    static Recipe recipe1;
    static Recipe recipe2;
    static Recipe recipe3;


    /**
     * Saves current recipe, review, and user database data in temporary objects to be restored later.
     * Creates recipes and users for use in test cases
     */
    @BeforeEach
    void setup() throws IOException {
        recipeRepoGateway = RecipeReadWriter.getRecipeRepo();
        tempRecipes = recipeRepoGateway.getRecipeList();

        reviewDatabaseReadWriter = new ReviewDatabaseReadWriter();
        tempReviews = ReviewInteractor.loadReviewDatabase();

        userGateWay = UserRepoImpl.getUserRepoImpl();
        tempUsers = userGateWay.getAllUser();

        // creates recipes
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
        ingredients3.add("flour");

        recipe1 = new Recipe("apple pie", "blah apples", "french", ingredients1, 200, 20, 4, "bob"); // time = 20
        recipe2 = new Recipe("candy apple", "blah apple candy", "french", ingredients2, 300, 10, 4, "cat"); // time = 10
        recipe3 = new Recipe("spaghetti", "blah bananas", "italian", ingredients3, 100, 30, 30, "bob"); // time = 30 (over time limit)

        RecipeList recipeList = new RecipeList();
        recipeList.addRecipe("apple pie", "blah apples", "french", ingredients1, 200, 20, 4, "bob"); // time = 20
        recipeList.addRecipe("candy apple", "blah apple candy", "french", ingredients2, 300, 10, 4, "cat"); // time = 10
        recipeList.addRecipe("spaghetti", "blah bananas", "italian", ingredients3, 100, 30, 30, "bob"); // time = 30 (over time limit)
        recipeRepoGateway.saveRecipe(recipeList);

        // create users (required to create reviews)
        UserList users = new UserList();
        users.AddAllUser("lei", "1234");
        users.AddAllUser("joe", "1234");
        users.AddAllUser("ang", "1234");
        userGateWay.saveUser(users);

    }

    /**
     * Restores original recipe, review, and user database data
     */
    @AfterEach
    void teardown() throws IOException {
        recipeRepoGateway.saveRecipe(tempRecipes);
        reviewDatabaseReadWriter.saveToFile("reviews.sav", tempReviews);
        userGateWay.saveUser(tempUsers);
    }

    /**
     * Test sorting an array of Recipes by time needed
     */
    @Test
    public void sortRecipesTimeNeeded(){
        // setup objects
        RecipeSorter recipeSorter = new TimeNeededRecipeSorter();

        Recipe[] recipes = new Recipe[3];
        recipes[0] = recipe1; // time needed = 20
        recipes[1] = recipe2; // time needed = 10
        recipes[2] = recipe3; // time needed = 30

        // sort by time needed, smallest to largest
        recipeSorter.sort(recipes, true);

        assertEquals(recipes[0].getRecipeName(), recipe2.getRecipeName());
        assertEquals(recipes[1].getRecipeName(), recipe1.getRecipeName());
        assertEquals(recipes[2].getRecipeName(), recipe3.getRecipeName());
    }

    /**
     * Test if sorting recipes by number of reviews works
     */
    @Test
    public void sortRecipesNumReviews() throws IOException {
        //setup
        // create reviews
        ReviewDatabase reviewDatabase = new ReviewDatabase();
        reviewDatabase.addReview(new Review("lei", recipe1, 4));
        reviewDatabase.addReview(new Review("joe", recipe1, 5));
        reviewDatabase.addReview(new Review("ang", recipe1, 4));
        reviewDatabase.addReview(new Review("ang", recipe2, 5));
        reviewDatabase.addReview(new Review("lei", recipe2, 3));
        reviewDatabase.addReview(new Review("lei", recipe3, 3));
        reviewDatabaseReadWriter.saveToFile("reviews.sav", reviewDatabase);

        Recipe[] recipes = new Recipe[3];
        recipes[0] = recipe1; // 3 reviews
        recipes[1] = recipe2; // 2 reviews
        recipes[2] = recipe3; // 1 review

        // sort recipes
        RecipeSorter recipeSorter = new NumReviewsRecipeSorter();
        recipeSorter.sort(recipes, true);

        assertEquals(recipe3.getRecipeName(), recipes[0].getRecipeName());
        assertEquals(recipe2.getRecipeName(), recipes[1].getRecipeName());
        assertEquals(recipe1.getRecipeName(), recipes[2].getRecipeName());
    }

    /**
     * Test if sorting recipes by average rating works
     */
    @Test
    public void sortRecipesAvgRating() throws IOException {
        // setup
        Recipe[] recipes = new Recipe[3];
        recipes[0] = recipe1; // average rating 4.3
        recipes[1] = recipe2; // average rating 4
        recipes[2] = recipe3; // average rating 3

        // create reviews
        ReviewDatabase reviewDatabase = new ReviewDatabase();
        reviewDatabase.addReview(new Review("lei", recipe1, 4));
        reviewDatabase.addReview(new Review("joe", recipe1, 5));
        reviewDatabase.addReview(new Review("ang", recipe1, 4));
        reviewDatabase.addReview(new Review("ang", recipe2, 5)); // average rating 4.3
        reviewDatabase.addReview(new Review("lei", recipe2, 3)); // average rating 4
        reviewDatabase.addReview(new Review("lei", recipe3, 3)); // average rating 3
        reviewDatabaseReadWriter.saveToFile("reviews.sav", reviewDatabase);

        // sort recipes
        RecipeSorter recipeSorter = new AverageRatingRecipeSorter();
        recipeSorter.sort(recipes, true);

        assertEquals(recipes[0].getRecipeName(), recipe3.getRecipeName());
        assertEquals(recipes[1].getRecipeName(), recipe2.getRecipeName());
        assertEquals(recipes[2].getRecipeName(), recipe1.getRecipeName());
    }

    /**
     * Test if sorting recipes by average rating works when a recipe in the list doesn't have any reviews
     */
    @Test
    public void sortRecipesAvgRatingNoReviews() throws IOException {

        Recipe[] recipes = new Recipe[3];
        recipes[0] = recipe1; // average rating 4.3
        recipes[1] = recipe2; // average rating 4
        recipes[2] = recipe3; // no reviews

        // create reviews
        ReviewDatabase reviewDatabase = new ReviewDatabase();
        reviewDatabase.addReview(new Review("lei", recipe1, 4));
        reviewDatabase.addReview(new Review("joe", recipe1, 5));
        reviewDatabase.addReview(new Review("ang", recipe1, 4));
        reviewDatabase.addReview(new Review("ang", recipe2, 5));
        reviewDatabase.addReview(new Review("lei", recipe2, 3));
        reviewDatabaseReadWriter.saveToFile("reviews.sav", reviewDatabase);

        RecipeSorter recipeSorter = new AverageRatingRecipeSorter();
        recipeSorter.sort(recipes, true);

        assertEquals(recipes[0].getRecipeName(), recipe3.getRecipeName());
        assertEquals(recipes[1].getRecipeName(), recipe2.getRecipeName());
        assertEquals(recipes[2].getRecipeName(), recipe1.getRecipeName());
    }

    /**
     * Test getSearchResults for recipes that contain ingredients, sorted by time needed in ascending order
     */
    @Test
    public void getSearchResultsWithMatchingIngredientsSortAscendingTimeNeeded() {
        RecipeList recipes = new RecipeList();
        recipes.addRecipe(recipe1.getRecipeName(), recipe1.getProcedure(), recipe1.getCuisine(), recipe1.getIngredients(), recipe1.getCalories(), recipe1.getTime(), recipe1.getDifficulty(), "bob");
        recipes.addRecipe(recipe2.getRecipeName(), recipe2.getProcedure(), recipe2.getCuisine(), recipe2.getIngredients(), recipe2.getCalories(), recipe2.getTime(), recipe2.getDifficulty(), "cat");
        recipes.addRecipe(recipe3.getRecipeName(), recipe3.getProcedure(), recipe3.getCuisine(), recipe3.getIngredients(), recipe3.getCalories(), recipe3.getTime(), recipe3.getDifficulty(), "bob");
        recipeRepoGateway.saveRecipe(recipes);

        SearchOutputBoundary searchPresenter = new SearchOutputBoundary() {
            @Override
            public void setUI(SearchResultsBox searchResultsBox) {

            }

            @Override
            public void prepareSuccessView(SearchResponseModel searchResults) {
                assertEquals(searchResults.getMatchingRecipes().length, 2);
                assertEquals(searchResults.getMatchingRecipes()[0], recipe2);
                assertEquals(searchResults.getMatchingRecipes()[1], recipe1);
            }

            @Override
            public void prepareFailureView(String error) {
                System.out.println(error);
            }
        };

        // search for recipes with:
        // - ingredients has sugar (other fields don't matter)
        // - sorted in ascending order by time needed
        ArrayList<String> ingredients = new ArrayList<>();
        ingredients.add("sugar");
        SearchRequestModel searchRequestModel = new SearchRequestModel(
                "",
                "",
                ingredients,
                0,
                "t",
                true
        );

        // get search results
        SearchInteractor searchInteractor = new SearchInteractor(searchPresenter, recipeRepoGateway);
        searchInteractor.getSearchResults(searchRequestModel);
    }

    /**
     * test getSearchResults for:
     *  - multiple criteria: within time limit AND contains ingredients
     *  - only one matching result
     *  - sorted in descending order by time needed
     */
    @Test
    public void getSearchResultsMultipleCriteriaOneResultDescendingOrder(){
        // set up recipes and save to recipe database
        RecipeList recipes = new RecipeList();
        recipes.addRecipe(recipe1.getRecipeName(), recipe1.getProcedure(), recipe1.getCuisine(), recipe1.getIngredients(), recipe1.getCalories(), recipe1.getTime(), recipe1.getDifficulty(), "bob"); // within time limit, has flour
        recipes.addRecipe(recipe2.getRecipeName(), recipe2.getProcedure(), recipe2.getCuisine(), recipe2.getIngredients(), recipe2.getCalories(), recipe2.getTime(), recipe2.getDifficulty(), "cat"); // within time limit, no flour
        recipes.addRecipe(recipe3.getRecipeName(), recipe3.getProcedure(), recipe3.getCuisine(), recipe3.getIngredients(), recipe3.getCalories(), recipe3.getTime(), recipe3.getDifficulty(), "bob"); // not within time limit, has flour
        recipeRepoGateway.saveRecipe(recipes);

        // create presenter with custom test results (instead of showing UI)
        SearchOutputBoundary searchPresenter = new SearchOutputBoundary() {
            @Override
            public void setUI(SearchResultsBox searchResultsBox) {

            }

            @Override
            public void prepareSuccessView(SearchResponseModel searchResults) {
                assertEquals(1, searchResults.getMatchingRecipes().length);
                assertEquals(recipe1, searchResults.getMatchingRecipes()[0]);
            }

            @Override
            public void prepareFailureView(String error) {
                System.out.println(error);
            }
        };

        // search for recipes with:
        // - time needed <=20, ingredients contain flour
        // - sorted in descending order by time needed

        ArrayList<String> ingredients = new ArrayList<>();
        ingredients.add("flour");
        SearchRequestModel searchRequestModel = new SearchRequestModel(
                "",
                "",
                ingredients,
                20,
                "t",
                false
        );

        // get search results
        SearchInteractor searchInteractor = new SearchInteractor(searchPresenter, recipeRepoGateway);
        searchInteractor.getSearchResults(searchRequestModel);
    }

    // Test getSearchResults for list of empty ingredients
    @Test
    public void getSearchResultsEmptyIngredients(){
        RecipeList recipes = new RecipeList();
        recipes.addRecipe(recipe1.getRecipeName(), recipe1.getProcedure(), recipe1.getCuisine(), recipe1.getIngredients(), recipe1.getCalories(), recipe1.getTime(), recipe1.getDifficulty(), "bob"); // within time limit
        recipes.addRecipe(recipe2.getRecipeName(), recipe2.getProcedure(), recipe2.getCuisine(), recipe2.getIngredients(), recipe2.getCalories(), recipe2.getTime(), recipe2.getDifficulty(), "cat"); // within time limit
        recipes.addRecipe(recipe3.getRecipeName(), recipe3.getProcedure(), recipe3.getCuisine(), recipe3.getIngredients(), recipe3.getCalories(), recipe3.getTime(), recipe3.getDifficulty(), "bob"); // not within time limit
        recipeRepoGateway.saveRecipe(recipes);

        SearchOutputBoundary searchPresenter = new SearchOutputBoundary() {
            @Override
            public void setUI(SearchResultsBox searchResultsBox) {
            }

            @Override
            public void prepareSuccessView(SearchResponseModel searchResults) {
                assertEquals(2, searchResults.getMatchingRecipes().length);
                assertEquals(recipe1, searchResults.getMatchingRecipes()[0]);
                assertEquals(recipe2, searchResults.getMatchingRecipes()[1]);
            }

            @Override
            public void prepareFailureView(String error) {
                System.out.println(error);
            }
        };


        SearchRequestModel searchRequestModel = new SearchRequestModel(
                "",
                "",
                new ArrayList<>(),
                20,
                "t",
                false
        );


        SearchInteractor searchInteractor = new SearchInteractor(searchPresenter, recipeRepoGateway);
        searchInteractor.getSearchResults(searchRequestModel);
    }
}
