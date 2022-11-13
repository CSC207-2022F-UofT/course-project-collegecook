package Recipe;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
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

//        System.out.println("Enter ingredients");
//        String ingredients = myObj.nextLine();

        System.out.println("Enter calories");
        int calories = myObj.nextInt();

        System.out.println("Enter time in minutes");
        int time = myObj.nextInt();

        System.out.println("Enter difficulty");
        int difficulty = myObj.nextInt();

        List<String> ingredients = new ArrayList<>();
        ingredients.add("aa");

        RecipeController recipeController = new RecipeController();
        recipeController.performCreateRecipe(recipeName, procedure, cuisine , ingredients, calories, time, difficulty);
        System.out.println(recipeController.result);


    }

    public void read(){
        Scanner myObj = new Scanner(System.in);
        System.out.println("Enter name");
        String name = myObj.nextLine();
        RecipeInteractor recipeInteractor = new RecipeInteractor();
        System.out.println(recipeInteractor.readRecipe(name));
    }



    public static void main(String[] args) {
        UI ui = new UI();
        ui.read();

    }
}
