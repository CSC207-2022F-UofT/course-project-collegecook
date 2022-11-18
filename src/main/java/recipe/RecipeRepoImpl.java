package recipe;

import entities.RecipeList;

import java.io.*;
import java.util.ArrayList;

public class RecipeRepoImpl implements RecipeRepoGateway{
    private static final String file = "recipe.sav";
    private static RecipeRepoImpl recipeRepoImpl;

    private RecipeRepoImpl(){}

    public static RecipeRepoImpl getRecipeRepoImpl(){
        if (recipeRepoImpl == null){
            recipeRepoImpl = new RecipeRepoImpl();
        }
        return recipeRepoImpl;
    }
    @Override
    public RecipeList getRecipeList() throws IOException {
        FileInputStream f = new FileInputStream(file);
        ObjectInputStream inputStream = new ObjectInputStream(f);
        try{
            return (RecipeList) inputStream.readObject();
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