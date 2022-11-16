package Recipe;

import Entities.RecipeList;

import java.io.IOException;

public interface RecipeRepoGateway {

    RecipeList getRecipeList() throws IOException;

    void saveRecipe(RecipeList recipeList) throws IOException;
}
