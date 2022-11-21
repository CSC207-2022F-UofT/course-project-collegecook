package recipe;

import entities.User;

import java.util.ArrayList;

public class RecipeRequestModel {
    /**
     * This is a RequestModel, which is used to combine user input together to avoid data clump(code smell).
     */
    private final String recipe_name;
    private final String procedure;
    private final String cuisine;
    private final ArrayList<String> ingredients;
    private final int calories;
    private final int time;
    private final int difficulty;
    private final String creator;

    public RecipeRequestModel(String recipe_name, String procedure, String cuisine, ArrayList      <String> ingredients,
                  int calories, int time, int difficulty, String creator){
        this.procedure = procedure;
        this.recipe_name = recipe_name;
        this.cuisine = cuisine;
        this.ingredients = ingredients;
        this.calories = calories;
        this.time = time;
        this.difficulty = difficulty;
        this.creator = creator;
    }

    public String getProcedure(){return this.procedure;}
    public String getRecipeName(){return this.recipe_name;
    }
    public String getCuisine(){return this.cuisine;}
    public int getCalories(){return this.calories;}
    public int getTime(){return this.time;}
    public int getDifficulty(){return this.difficulty;}
    public ArrayList<String> getIngredients(){return this.ingredients;}
    public String getCreator(){return this.creator;}
}
