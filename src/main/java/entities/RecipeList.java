package entities;


import java.io.Serializable;
import java.util.*;

public class RecipeList implements Serializable, Iterable<Recipe>{
    private final Map<String, Recipe> all_recipe = new HashMap<>() ;
    private int recipe_size;

    public void add_recipe(String recipe_name, String procedure, String cuisine, ArrayList<String> ingredients,
                           int calories, int time, int difficulty, String creator){
        Recipe recipe = new Recipe(recipe_name, procedure, cuisine, ingredients, calories, time, difficulty, creator);
        this.all_recipe.put(recipe_name, recipe);
        this.recipe_size = all_recipe.size();
    }
    public Recipe get_recipe(String recipeName){

        return all_recipe.get(recipeName);
    }

    public Boolean contain(String recipeName){
        return all_recipe.containsKey(recipeName);
    }


    @Override
    public Iterator<Recipe> iterator() {
        return new RecipeIterator();
    }

    private class RecipeIterator implements Iterator<Recipe>{
        int curr = 0;
        int max = recipe_size;
        Recipe[] recipes = all_recipe.values().toArray(new Recipe[max]);

        @Override
        public boolean hasNext() {
            return curr < recipe_size;
        }

        @Override
        public Recipe next() {
            return recipes[curr++];
        }
    }
}


