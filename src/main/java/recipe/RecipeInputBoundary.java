package recipe;

import entities.Recipe;
import entities.RecipeList;


public interface RecipeInputBoundary {

    /**
     * An interface that the iteractor should implement.
     */
    void createRecipe (RecipeRequestModel recipeRequestModel);

    void readRecipe(String recipeName);

    RecipeList getAll();
    Recipe getRecipe(String recipeName);
    String getReadingRecipe();

    String getCreator(String readRecipe);

}
