package recipe;

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

    /**
     *
     * @param recipe_name The name of the recipe
     * @param procedure The procedure of the recipe
     * @param cuisine The cuisine type of the recipe.
     * @param ingredients The ingredients of the recipe.
     * @param calories The calories of the recipe.
     * @param time The time required to cook.
     * @param difficulty The difficulty of cooking.
     * @param creator The name of the creator.
     */
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

    /**
     * Get the procedure.
     * @return The procedure of the recipe.
     */
    public String getProcedure(){return this.procedure;}

    /**
     * Get the name of the recipe.
     * @return The name of the recipe.
     */
    public String getRecipeName(){return this.recipe_name;}

    /**
     * Get the cuisine type of the recipe.
     * @return The cuisine type of the recipe.
     */
    public String getCuisine(){return this.cuisine;}

    /**
     * Get the calories of the recipe.
     * @return The calories of the recipe.
     */
    public int getCalories(){return this.calories;}

    /**
     * Get the time required for cooking.
     * @return The time required for cooking.
     */
    public int getTime(){return this.time;}

    /**
     * Get the difficulty of cooking.
     * @return The difficulty of cooking.
     */
    public int getDifficulty(){return this.difficulty;}

    /**
     * Get the ingredients of the recipe.
     * @return An arrayList including all the ingredients.
     */
    public ArrayList<String> getIngredients(){return this.ingredients;}

    /**
     * get the creator of the recipe.
     * @return The creator of the recipe.
     */
    public String getCreator(){return this.creator;}
}
