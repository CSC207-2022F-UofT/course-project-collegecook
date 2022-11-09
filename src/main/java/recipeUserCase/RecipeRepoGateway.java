package RecipeUserCase;

import Entities.Recipe;
import Entities.RecipeList;

import java.io.IOException;
import java.util.Map;

public interface RecipeRepoGateway {

    RecipeList getRecipeList() throws IOException;

    void saveRecipe(RecipeList recipeList) throws IOException;
}
