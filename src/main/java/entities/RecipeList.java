package entities;

import java.io.Serializable;
import java.util.*;

public class RecipeList implements Serializable{
    private final Map<String, Recipe> all_recipe = new HashMap<>() ;

    public void add_recipe(String recipe_name, String procedure, String cuisine, ArrayList<String> ingredients,
                           int calories, int time, int difficulty){
        Recipe recipe = new Recipe(recipe_name, procedure, cuisine, ingredients, calories, time, difficulty);
        this.all_recipe.put(recipe_name, recipe);
    }
    public Recipe get_recipe(String recipeName){

        return all_recipe.get(recipeName);
    }

    public Boolean contain(String recipeName){
        return all_recipe.containsKey(recipeName);
    }

}
