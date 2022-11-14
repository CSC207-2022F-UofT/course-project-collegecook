package Recipe;

import Entities.Recipe;
import Entities.RecipeList;

import java.io.*;
import java.util.Map;

public class RecipeRepoImpl implements RecipeRepoGateway{
    private static final String file = "recipe.sav";

    @Override
    public RecipeList getRecipeList() throws IOException {
        FileInputStream f = new FileInputStream(file);
        ObjectInputStream inputStream = new ObjectInputStream(f);
        try{
            RecipeList newRecipe = (RecipeList) inputStream.readObject();
            return newRecipe;
        } catch (ClassNotFoundException e){
            e.printStackTrace();
        }
        f.close();
        return null;
    }

    @Override
    public void saveRecipe(RecipeList recipeList) throws IOException {
        FileOutputStream f2 = new FileOutputStream(file);
        ObjectOutputStream outputStream = new ObjectOutputStream(f2);
        outputStream.writeObject(recipeList);
        f2.close();
    }
}