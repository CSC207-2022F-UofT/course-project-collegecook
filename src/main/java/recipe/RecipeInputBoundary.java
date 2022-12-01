package recipe;

import entities.Recipe;
import entities.RecipeList;

import java.util.ArrayList;

public interface RecipeInputBoundary {

    /**
     *
     * @param recipeRequestModel A requestModel which includes all the input, such as recipe name, procedure, ...
     */
    void createRecipe (RecipeRequestModel recipeRequestModel);

    void readRecipe(String recipeName);

    RecipeList getAll();
    Recipe getRecipe(String recipeName);
    String getReadingRecipe();

    String getCreator(String readRecipe);

}
