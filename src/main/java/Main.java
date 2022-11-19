import recipe.*;

public class Main {
    public static void main(String[] args){
        RecipeRepoGateway recipeRepoGateway = RecipeReadWriter.getRecipeRepo();
        RecipeOutputBoundary recipeOutputBoundary = new RecipePresenter();
        RecipeInputBoundary recipeInputBoundary = new RecipeInterActor(recipeOutputBoundary, recipeRepoGateway);
        RecipeController recipeController = new RecipeController(recipeInputBoundary);
    }
}
