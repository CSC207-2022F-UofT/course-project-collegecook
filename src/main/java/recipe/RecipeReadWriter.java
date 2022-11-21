package recipe;

import entities.RecipeList;

import java.io.*;

public class RecipeReadWriter implements RecipeRepoGateway{
    private static final String file = "recipe.sav";
    private static RecipeReadWriter recipeReadWriter;

    public RecipeReadWriter(){}

    public static RecipeReadWriter getRecipeRepo(){
        if (recipeReadWriter == null){
            recipeReadWriter = new RecipeReadWriter();
        }
        return recipeReadWriter;
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