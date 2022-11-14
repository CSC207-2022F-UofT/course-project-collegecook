package Entities;

import java.io.Serializable;
<<<<<<< HEAD
import java.util.HashMap;
import java.util.Map;
=======
import java.util.*;
>>>>>>> e753dc391b5bd7aff111f4a1a626ee89c178afb9

public class RecipeList implements Serializable{
    private final Map<String, Recipe> all_recipe = new HashMap<>() ;

<<<<<<< HEAD
    public void add_recipe(Recipe recipe){
        this.all_recipe.put(recipe.get_recipe_name(), recipe);
    }
    public Recipe get_recipe(String recipename){
        return all_recipe.get(recipename);
=======
    public void add_recipe(String recipe_name, String procedure, String cuisine, List<String> ingredients,
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

    public String get_all_name(){
        return all_recipe.keySet().toString();
>>>>>>> e753dc391b5bd7aff111f4a1a626ee89c178afb9
    }

}
