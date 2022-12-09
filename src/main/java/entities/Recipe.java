
package entities;

import java.util.ArrayList;
import java.io.Serializable;
import java.util.Objects;

public class Recipe implements Serializable{
    /**
     * This is the class of Recipe, which is an entity.
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
     * @param recipe_name The name of the recipe.
     * @param procedure The procedure of the recipe
     * @param cuisine The cuisine type of the recipe
     * @param ingredients The ingredients required for the recipe.
     * @param calories The total calories of the recipe.
     * @param time The time required in making the cuisine.
     * @param difficulty The difficulty of making the cuisine.
     * @param creator The creator of the recipe
     */
    public Recipe(String recipe_name, String procedure, String cuisine, ArrayList      <String> ingredients,
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
    public String getRecipeName(){return this.recipe_name;}
    public String getCuisine(){return this.cuisine;}
    public int getCalories(){return this.calories;}
    public int getTime(){return this.time;}
    public int getDifficulty(){return this.difficulty;}
    public String getCreator(){return this.creator;}
    public ArrayList<String> getIngredients(){return this.ingredients;}

    /**
     *
     * @param o Arbitrary object
     * @return Return whether o is a recipe with the same name.
     */
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Recipe recipe = (Recipe) o;
        return recipe_name.equals(recipe.recipe_name);
    }

    /**
     *
     * @return The hashcode of the recipe_name
     */
    @Override
    public int hashCode() {
        return Objects.hash(recipe_name);
    }

    /**
     *
     * @return Return a string which has all the information of the recipe.
     */
    @Override
    public String toString(){
        return "Recipe: " + recipe_name + "\n"  +
                "Creator: " + creator + "\n" +
                "Procedure: " + procedure + "\n" +
                "Cuisine: " + cuisine + "\n" +
                "Ingredients: " + ingredients.toString() + "\n" +
                "Calories: " + calories + "\n" +
                "Time Required: " + time + " minutes \n" +
                "Difficulty (out of 5): " + difficulty + "\n";
    }
}