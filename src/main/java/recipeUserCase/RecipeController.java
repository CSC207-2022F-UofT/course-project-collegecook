package RecipeUserCase;

import java.util.List;

public class RecipeController {

    String result;

    public String getResult(){ return this.result;}

    public void setResult(String result){ this.result = result;}

    public void performCreateRecipe (String recipe_name, String procedure, String cuisine, List<String> ingredients,
                                     int calories, int time, int difficulty){
        RecipeInteractor recipeInteractor = new RecipeInteractor();
        recipeInteractor.createRecipe(recipe_name, procedure, cuisine, ingredients, calories, time, difficulty);
        this.result = "Success!";
    }

    public void performReadRecipe(String recipeName){
        RecipeInteractor recipeInteractor = new RecipeInteractor();
        System.out.println(recipeInteractor.readRecipe(recipeName));
    }
}
