package recipe;

import entities.Recipe;
import entities.RecipeList;

import java.io.*;
import java.util.ArrayList;

public class RecipeReadWriter implements RecipeRepoGateway{
    /**
     * This class is used to read recipe from "recipe.sav" or write recipe into "recipe.sav"
     */
    private static final String file = "recipe.sav";
    private static RecipeReadWriter recipeReadWriter;

    public RecipeReadWriter(){}

    /**
     *
     * @return RecipeReadWriter. The Singleton Design Pattern is used here to control the initialization of gateway.
     */
    public static RecipeReadWriter getRecipeRepo(){
        if (recipeReadWriter == null){
            recipeReadWriter = new RecipeReadWriter();
        }
        return recipeReadWriter;
    }

    /**
     *
     * @return Return the recipeList stored in the local file.
     * @throws IOException
     */
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

    /**
     *
     * @param recipeList The recipeList that user wants to store.
     * @throws IOException
     */
    @Override
    public void saveRecipe(RecipeList recipeList) throws IOException {
        FileOutputStream f2 = new FileOutputStream(file);
        ObjectOutputStream outputStream = new ObjectOutputStream(f2);
        outputStream.writeObject(recipeList);
        f2.close();
    }

    public static void main(String[] args) throws IOException {
        RecipeReadWriter recipeReadWriter1 = RecipeReadWriter.getRecipeRepo();
        RecipeList recipeList = new RecipeList().getRecipe();
        }
    }
}