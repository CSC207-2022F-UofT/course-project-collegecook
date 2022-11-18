package login;

import entities.RecipeList;

import java.io.IOException;

public interface UserGateWay {

    UserManager getAllUser() throws IOException;

    void saveRecipe(RecipeList recipeList) throws IOException;
}

