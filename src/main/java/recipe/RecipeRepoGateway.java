package recipe;

import entities.RecipeList;


public interface RecipeRepoGateway {
    /**
     *
     * This interface should be implemented by RecipeReadWriter to save and get recipe.
     */

    RecipeList getRecipeList();

    void saveRecipe(RecipeList recipeList);
}
