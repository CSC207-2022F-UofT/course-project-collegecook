package recipe;

import entities.RecipeList;

import java.io.IOException;

public interface RecipeRepoGateway {
    /**
     *
     * This interface should be implemented by RecipeReadWriter to save and get recipe.
     */

    RecipeList getRecipeList() throws IOException;

    void saveRecipe(RecipeList recipeList) throws IOException;
}
