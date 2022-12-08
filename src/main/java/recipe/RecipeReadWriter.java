package recipe;

import entities.RecipeList;

import java.io.*;

public class RecipeReadWriter implements RecipeRepoGateway{
    /**
     * This class is used to read recipe from "recipe.sav" or write recipe into "recipe.sav"
     */
    private static final String file = "recipe.sav";
    private static RecipeReadWriter recipeReadWriter;

    private RecipeReadWriter(){}

    /**
     * Construct the RecipeReadWriter
     * @return RecipeReadWriter. The Singleton Design Pattern is used here to control the initialization of gateway.
     */
    public static RecipeReadWriter getRecipeRepo(){
        if (recipeReadWriter == null){
            recipeReadWriter = new RecipeReadWriter();
        }
        return recipeReadWriter;
    }

    /**
     * Get the stored RecipeList
     * @return The RecipeList stored in the database.
     */
    @Override
    public RecipeList getRecipeList(){
        try{
            FileInputStream f = new FileInputStream(file);
            ObjectInputStream inputStream = new ObjectInputStream(f);
            return (RecipeList) inputStream.readObject();
        } catch (ClassNotFoundException | ClassCastException | IOException e){
            return new RecipeList();
        }
    }

    /**
     * Save the recipe.
     * @param recipeList The RecipeList that the user wants to store.
     */
    @Override
    public void saveRecipe(RecipeList recipeList){
        try {
            FileOutputStream f2 = new FileOutputStream(file);
            ObjectOutputStream outputStream = new ObjectOutputStream(f2);
            outputStream.writeObject(recipeList);
            f2.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}