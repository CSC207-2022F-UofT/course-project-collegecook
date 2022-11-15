package recipe;

import entities.RecipeList;

import java.util.ArrayList;
import java.util.List;

public interface RecipeInputBoundry {
    void createRecipe (String recipe_name, String procedure, String cuisine, ArrayList<String> ingredients,
                              int calories, int time, int difficulty);

    void readRecipe(String recipeName);

    RecipeList getAll();

}
