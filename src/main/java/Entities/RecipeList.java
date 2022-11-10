package Entities;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;

public class RecipeList implements Serializable{
    private final Map<String, Recipe> all_recipe = new HashMap<>() ;

    public void add_recipe(Recipe recipe){
        this.all_recipe.put(recipe.get_recipe_name(), recipe);
    }
    public Recipe get_recipe(String recipename){
        return all_recipe.get(recipename);
    }

}
