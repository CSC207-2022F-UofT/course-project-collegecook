package Recipe;

import Entities.RecipeList;

import java.util.List;

public interface RecipeInputBoundry {
    void createRecipe (String recipe_name, String procedure, String cuisine, List<String> ingredients,
                              int calories, int time, int difficulty);

    void readRecipe(String recipeName);

    RecipeList getAll();

}
