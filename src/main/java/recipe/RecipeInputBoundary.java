package recipe;

import entities.Recipe;
import entities.RecipeList;

import java.util.ArrayList;

public interface RecipeInputBoundary {
    void createRecipe (String recipe_name, String procedure, String cuisine, ArrayList<String> ingredients,
                              int calories, int time, int difficulty);

    void readRecipe(String recipeName);

    RecipeList getAll();
    Recipe getRecipe(String recipeName);

}
