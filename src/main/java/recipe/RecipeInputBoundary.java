package recipe;

import entities.Recipe;
import entities.RecipeList;

import java.util.ArrayList;

public interface RecipeInputBoundary {
    void createRecipe (RecipeRequestModel recipeRequestModel);

    void readRecipe(String recipeName);

    RecipeList getAll();
    Recipe getRecipe(String recipeName);

}
