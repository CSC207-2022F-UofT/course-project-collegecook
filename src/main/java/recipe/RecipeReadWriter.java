package recipe;

import entities.Recipe;
import entities.RecipeList;

import java.io.*;
import java.util.ArrayList;

public class RecipeReadWriter implements RecipeRepoGateway{
    private static final String file = "recipe.sav";
    private static RecipeReadWriter recipeReadWriter;

    private RecipeReadWriter(){}

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

    public static void main(String[] args) throws IOException {
        RecipeReadWriter r = RecipeReadWriter.getRecipeRepo();
        RecipeList recipeList = new RecipeList();
//        ArrayList<String> a = new ArrayList<>();
//        a.add("apple");
//        recipeList.add_recipe("apple pie", "Cut apples and make it a pie",
//                "dessert", a, 1, 2, 3, "Brenden");
//        r.saveRecipe(recipeList);

        for(Recipe recipe : r.getRecipeList()){
            System.out.println(recipe.getRecipeName());
        };
    }

}