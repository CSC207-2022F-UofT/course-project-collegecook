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
    RecipeList tempRecipes;

    UserGateWay userGateWay;
    UserList tempUsers;

    ReviewDatabaseReadWriter reviewDatabaseReadWriter;
    ReviewInteractor reviewInteractor;
    ReviewDatabase tempReviews;

    static Recipe recipe1;
    static Recipe recipe2;
    static Recipe recipe3;


    /**
     * Saves current recipe, review, and user database data in temporary objects
     * Initializes recipes for use in test cases
     */
    @BeforeEach
    void setup() throws IOException {
        recipeRepoGateway = RecipeReadWriter.getRecipeRepo();
        tempRecipes = recipeRepoGateway.getRecipeList();

        reviewDatabaseReadWriter = new ReviewDatabaseReadWriter();
        reviewInteractor = new ReviewInteractor();
        tempReviews = ReviewInteractor.loadReviewDatabase();

        userGateWay = UserRepoImpl.getUserRepoImpl();
        tempUsers = userGateWay.getAllUser();

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

    }

    /**
     * Restores original recipe, review, and user database data
     */
    @AfterEach
    void teardown() throws IOException {
        recipeRepoGateway.saveRecipe(tempRecipes);
        recipeRepoGateway = null;

        reviewDatabaseReadWriter.saveToFile("reviews.sav", tempReviews);

        userGateWay.saveUser(tempUsers);
        userGateWay = null;
    }

    /**
     * Test if sorting an array of Recipes by time needed works
     */
    @Test
    public void sortRecipesTimeNeeded() throws IOException {
        // setup objects
        RecipeSorter recipeSorter = new TimeNeededRecipeSorter();

        Recipe[] recipes = new Recipe[3];
        recipes[0] = recipe1; // time needed = 20
        recipes[1] = recipe2; // time needed = 10
        recipes[2] = recipe3; // time needed = 30

        // expected: recipe3, recipe1, recipe2
        Recipe[] expectedResults = new Recipe[3];
        expectedResults[0] = recipe2;
        expectedResults[1] = recipe1;
        expectedResults[2] = recipe3;

        // sort by time needed, smallest to largest
        recipeSorter.sort(recipes, true);

        assertEquals(expectedResults[0].getRecipeName(), recipes[0].getRecipeName());
        assertEquals(expectedResults[1].getRecipeName(), recipes[1].getRecipeName());
        assertEquals(expectedResults[2].getRecipeName(), recipes[2].getRecipeName());
    }

    /**
     * Test if sorting recipes by number of reviews works
     */
    @Test
    public void sortRecipesNumReviews() throws IOException {

        RecipeSorter recipeSorter = new NumReviewsRecipeSorter();

        //setup
        // create recipes
        Recipe[] recipes = new Recipe[3];
        recipes[0] = recipe1; // 3 reviews
        recipes[1] = recipe2; // 2 reviews
        recipes[2] = recipe3; // 1 review

        // create users (required to create reviews)
        UserList users = new UserList();
        users.AddAllUser("lei", "1234");
        users.AddAllUser("joe", "1234");
        users.AddAllUser("ang", "1234");
        userGateWay.saveUser(users);

        // create reviews
        reviewInteractor = new ReviewInteractor();
        reviewInteractor.createReview("lei", recipe1.getRecipeName(), 4);
        reviewInteractor.createReview("joe", recipe1.getRecipeName(), 5);
        reviewInteractor.createReview("ang", recipe1.getRecipeName(), 4);
        reviewInteractor.createReview("ang", recipe2.getRecipeName(), 5);
        reviewInteractor.createReview("lei", recipe2.getRecipeName(), 3);
        reviewInteractor.createReview("lei", recipe3.getRecipeName(), 3);

        //expected: recipe3, recipe2, recipe1
        Recipe[] expectedResults = new Recipe[3];
        expectedResults[0] = recipe3;
        expectedResults[1] = recipe2;
        expectedResults[2] = recipe1;

        recipeSorter.sort(recipes, true);

        assertEquals(expectedResults[0].getRecipeName(), recipes[0].getRecipeName());
        assertEquals(expectedResults[1].getRecipeName(), recipes[1].getRecipeName());
        assertEquals(expectedResults[2].getRecipeName(), recipes[2].getRecipeName());
    }

    /**
     * Test if sorting recipes by average rating works
     */
    @Test
    public void sortRecipesAvgRating() throws IOException {
        Recipe[] recipes = new Recipe[3];
        recipes[0] = recipe1; // average rating 4.3
        recipes[1] = recipe2; // average rating 4
        recipes[2] = recipe3; // average rating 3

        UserList users = new UserList();
        users.AddAllUser("lei", "1234");
        users.AddAllUser("joe", "1234");
        users.AddAllUser("ang", "1234");
        userGateWay.saveUser(users);

        reviewInteractor = new ReviewInteractor();
        reviewInteractor.createReview("lei", recipe1.getRecipeName(), 4);
        reviewInteractor.createReview("joe", recipe1.getRecipeName(), 5);
        reviewInteractor.createReview("ang", recipe1.getRecipeName(), 4); // recipe1 # of ratings = 3
        reviewInteractor.createReview("ang", recipe2.getRecipeName(), 5);
        reviewInteractor.createReview("lei", recipe2.getRecipeName(), 3); // recipe2 # of ratings = 2
        reviewInteractor.createReview("lei", recipe3.getRecipeName(), 3); // recipe3 # of rating = 1

        RecipeSorter recipeSorter = new NumReviewsRecipeSorter();

        recipeSorter.sort(recipes, true);

        Recipe[] expectedResults = new Recipe[3];
        expectedResults[0] = recipe3;
        expectedResults[1] = recipe2;
        expectedResults[2] = recipe1;

        assertEquals(recipes[0].getRecipeName(), expectedResults[0].getRecipeName());
        assertEquals(recipes[1].getRecipeName(), expectedResults[1].getRecipeName());
        assertEquals(recipes[2].getRecipeName(), expectedResults[2].getRecipeName());
    }

    /**
     * Test if sorting recipes by average rating works when a recipe in the list doesn't have any reviews
     */
    @Test
    public void sortRecipesAvgRatingNoReviews() throws IOException {

        RecipeSorter recipeSorter = new NumReviewsRecipeSorter();

        Recipe[] recipes = new Recipe[3];
        recipes[0] = recipe1; // average rating 4.3
        recipes[1] = recipe2; // average rating 5
        recipes[2] = recipe3; // no reviews

        UserList users = new UserList();
        users.AddAllUser("lei", "1234");
        users.AddAllUser("joe", "1234");
        users.AddAllUser("ang", "1234");
        userGateWay.saveUser(users);

        reviewInteractor = new ReviewInteractor();
        reviewInteractor.createReview("lei", recipe1.getRecipeName(), 4);
        reviewInteractor.createReview("joe", recipe1.getRecipeName(), 5);
        reviewInteractor.createReview("ang", recipe1.getRecipeName(), 4); // recipe1 # of ratings = 3
        reviewInteractor.createReview("ang", recipe2.getRecipeName(), 5);
        reviewInteractor.createReview("lei", recipe2.getRecipeName(), 3); // recipe2 # of ratings = 2/ recipe3 # of rating = 1

        //expected = recipe2, recipe1, recipe3
        Recipe[] expectedResults = new Recipe[3];
        expectedResults[0] = recipe3;
        expectedResults[1] = recipe2;
        expectedResults[2] = recipe1;

        recipeSorter.sort(recipes, false);

        assertEquals(recipes[0].getRecipeName(), expectedResults[0].getRecipeName());
        assertEquals(recipes[1].getRecipeName(), expectedResults[1].getRecipeName());
        assertEquals(recipes[2].getRecipeName(), expectedResults[2].getRecipeName());
    }

    // test getSearchResults for recipes that contain ingredients, sorted by time needed in ascending order
    @Test
    public void getSearchResultsWithMatchingIngredientsSortAscendingTimeNeeded() throws IOException {
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
    public void getSearchResultsMultipleCriteriaOneResultDescendingOrder() throws IOException {
        // set up recipes and save to recipe database
        RecipeList recipes = new RecipeList();
        recipes.addRecipe(recipe1.getRecipeName(), recipe1.getProcedure(), recipe1.getCuisine(), recipe1.getIngredients(), recipe1.getCalories(), recipe1.getTime(), recipe1.getDifficulty(), "bob"); // within time limit, has flour
        recipes.addRecipe(recipe2.getRecipeName(), recipe2.getProcedure(), recipe2.getCuisine(), recipe2.getIngredients(), recipe2.getCalories(), recipe2.getTime(), recipe2.getDifficulty(), "cat"); // within time limit, no flour
        recipes.addRecipe(recipe3.getRecipeName(), recipe3.getProcedure(), recipe3.getCuisine(), recipe3.getIngredients(), recipe3.getCalories(), recipe3.getTime(), recipe3.getDifficulty(), "bob"); // not within time limit, has flour
        recipeRepoGateway.saveRecipe(recipes);

        // create presenter with custom test results (instead of showing UI)
        // expected: recipe1, recipe2
        SearchOutputBoundary searchPresenter = new SearchOutputBoundary() {
            @Override
            public void setUI(SearchResultsBox searchResultsBox) {

            }

            @Override
            public void prepareSuccessView(SearchResponseModel searchResults) {
                assertEquals(1, searchResults.matchingRecipes.length);
                assertEquals(recipe1, searchResults.matchingRecipes[0]);
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

    @Test
    public void getSearchResultsEmptyIngredients() throws IOException {
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
                assertEquals(2, searchResults.matchingRecipes.length);
                assertEquals(recipe1, searchResults.matchingRecipes[0]);
                assertEquals(recipe2, searchResults.matchingRecipes[1]);
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
