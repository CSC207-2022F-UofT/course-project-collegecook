package recipe;

import java.util.List;

public class RecipeController {

    String result;
    RecipeInputBoundry recipeInputBoundry;

    public RecipeController(RecipeInputBoundry recipeInputBoundry) {
        this.recipeInputBoundry = recipeInputBoundry;
    }

    public String getResult() {
        return this.result;
    }

    public void setResult(String result) {
        this.result = result;
    }

    public void performCreateRecipe(String recipe_name, String procedure, String cuisine, List<String> ingredients,
                                    int calories, int time, int difficulty) {
        recipeInputBoundry.createRecipe(recipe_name, procedure, cuisine, ingredients, calories, time, difficulty);
    }

    public void performReadRecipe(String recipeName) {
        recipeInputBoundry.readRecipe(recipeName);
    }

    public void performReadAllName() {
        System.out.println(recipeInputBoundry.getAll());
    }


}