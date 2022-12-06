package entities;

import java.io.Serializable;
import java.util.*;

public class RecipeList implements Serializable, Iterable<Recipe>{
    /**
     * This is the class of RecipeList, which is also an entity.
     */
    private final Map<String, Recipe> all_recipe = new HashMap<>() ;
    private int recipe_size;

    public void addRecipe(String recipe_name, String procedure, String cuisine, ArrayList<String> ingredients,
                           int calories, int time, int difficulty, String creator){
        Recipe recipe = new Recipe(recipe_name, procedure, cuisine, ingredients, calories, time, difficulty, creator);
        this.all_recipe.put(recipe_name, recipe);
        this.recipe_size = all_recipe.size();
    }

    /**
     *
     * @param recipeName
     * @return
     */
    public Recipe getRecipe(String recipeName){

        return all_recipe.get(recipeName);
    }

    public Boolean contain(String recipeName){
        return all_recipe.containsKey(recipeName);
    }


    /**
     *
     * @return Return RecipeIterator. Iterator Design Pattern is used here to make the RecipeList iterable. When
     * iterating through the RecipeList, user can get each Recipe in it.
     */
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


