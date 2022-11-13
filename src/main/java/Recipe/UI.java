package Recipe;
import java.util.*;

public class UI {
    public UI(){};

    public void create(){
        Scanner myObj = new Scanner(System.in);
        System.out.println("Enter the name of recipe");
        String recipeName = myObj.nextLine();

        System.out.println("procedure");
        String procedure = myObj.nextLine();

        System.out.println("Enter cuisine type");
        String cuisine = myObj.nextLine();

        System.out.println("Enter ingredients");
        String ingredient = myObj.nextLine();
        String[] ingredients_list = ingredient.split(",");
        List<String> ingredients = new ArrayList<>(Arrays.asList(ingredients_list));

        System.out.println("Enter calories");
        int calories = myObj.nextInt();

        System.out.println("Enter time in minutes");
        int time = myObj.nextInt();

        System.out.println("Enter difficulty");
        int difficulty = myObj.nextInt();

        RecipeController recipeController = new RecipeController();
        recipeController.performCreateRecipe(recipeName, procedure, cuisine , ingredients, calories, time, difficulty);
        System.out.println(recipeController.result);


    }

    public void read(){
        Scanner myObj = new Scanner(System.in);
        System.out.println("Enter name");
        String name = myObj.nextLine();
        RecipeController recipeController = new RecipeController();
        recipeController.performReadRecipe(name);
    }



    public static void main(String[] args) {
        UI ui = new UI();
        Scanner myObj = new Scanner(System.in);
        System.out.println("Create or Read?");
        String step = myObj.nextLine();
        if (Objects.equals(step, "create")){
            ui.create();
        }else{
            ui.read();
        }

    }
}
