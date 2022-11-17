package entities;

import java.util.ArrayList;
import java.io.Serializable;
import java.util.Objects;

public class Recipe implements Serializable{
    private final String recipe_name;
    private final String procedure;
    private final String cuisine;
    private final ArrayList<String> ingredients;
    private final int calories;
    private final int time;
    private final int difficulty;
    private final String creator;


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

    public String get_procedure(){return this.procedure;}
    public String get_recipe_name(){return this.recipe_name;
    }
    public String get_cuisine(){return this.cuisine;}
    public int get_calories(){return this.calories;}
    public int get_time(){return this.time;}
    public int get_difficulty(){return this.difficulty;}
    public String get_creator(){return this.creator;}

    public ArrayList<String> get_ingredients(){return this.ingredients;}


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Recipe recipe = (Recipe) o;
        return recipe_name.equals(recipe.recipe_name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(recipe_name);
    }

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