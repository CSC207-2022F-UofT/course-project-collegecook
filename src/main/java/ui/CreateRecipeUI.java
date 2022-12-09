package ui;


import recipe.RecipeController;
import recipe.RecipeCreateBox;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.Arrays;

public class CreateRecipeUI extends JFrame implements RecipeCreateBox {
    RecipeController recipeController;

    JPanel check = new JPanel();
    JTextField name = new JTextField(40);
    JTextArea procedure = new JTextArea(5, 40);
    JTextField cuisine = new JTextField(40);
    JTextField ingredients = new JTextField(40);
    JTextField calories = new JTextField(40);
    JTextField time = new JTextField(40);
    JTextField difficulty = new JTextField(40);
    JLabel nameQ = new JLabel("What's the name of the recipe?");
    JLabel procedureQ = new JLabel("What's the procedure of the recipe?");
    JLabel cuisineQ = new JLabel("What's the cuisine type?");
    JLabel ingredientsQ = new JLabel("What are the ingredients? (Use comma to separate)");
    JLabel caloriesQ = new JLabel("What is the total calories? (Enter an integer)");
    JLabel timeQ = new JLabel("What is the total time required? (Enter an integer)");
    JLabel difficultyQ = new JLabel("What is the difficulty? (1 - 5)");

    JButton create = new JButton("Create");


    public CreateRecipeUI(AppController appController) {
        this.recipeController = appController.getRecipeController();

        check.setLayout(new BoxLayout(check, BoxLayout.Y_AXIS));
        nameQ.setAlignmentX(Component.CENTER_ALIGNMENT);
        check.add(nameQ);
        name.setAlignmentX(Component.CENTER_ALIGNMENT);
        check.add(name);

        procedureQ.setAlignmentX(Component.CENTER_ALIGNMENT);
        check.add(procedureQ);
        procedure.setAlignmentX(Component.CENTER_ALIGNMENT);
        check.add(procedure);

        cuisineQ.setAlignmentX(Component.CENTER_ALIGNMENT);
        check.add(cuisineQ);
        cuisine.setAlignmentX(Component.CENTER_ALIGNMENT);
        check.add(cuisine);

        ingredientsQ.setAlignmentX(Component.CENTER_ALIGNMENT);
        check.add(ingredientsQ);
        ingredients.setAlignmentX(Component.CENTER_ALIGNMENT);
        check.add(ingredients);

        caloriesQ.setAlignmentX(Component.CENTER_ALIGNMENT);
        check.add(caloriesQ);
        calories.setAlignmentX(Component.CENTER_ALIGNMENT);
        check.add(calories);

        timeQ.setAlignmentX(Component.CENTER_ALIGNMENT);
        check.add(timeQ);
        time.setAlignmentX(Component.CENTER_ALIGNMENT);
        check.add(time);

        difficultyQ.setAlignmentX(Component.CENTER_ALIGNMENT);
        check.add(difficultyQ);
        difficulty.setAlignmentX(Component.CENTER_ALIGNMENT);
        check.add(difficulty);


        create.setAlignmentX(Component.CENTER_ALIGNMENT);
        create.addActionListener(e -> {
            try{
                Integer.parseInt(calories.getText());
                Integer.parseInt(time.getText());
                int diff = Integer.parseInt(difficulty.getText());
                String[] difficultyList = {"1", "2", "3", "4", "5"};
                String temp = difficultyList[diff - 1];
                dispose();
                String ingredient = ingredients.getText();
                String[] ingredients_list = ingredient.split(",");
                ArrayList<String> ingredients = new ArrayList<>(Arrays.asList(ingredients_list));
                recipeController.performCreateRecipe(name.getText(), procedure.getText(), cuisine.getText(),
                        ingredients, Integer.parseInt(calories.getText()), Integer.parseInt(time.getText()),
                        Integer.parseInt(temp),
                        appController.getLoginControllor().preformGetLoggedInUser());

            }catch (NumberFormatException | ArrayIndexOutOfBoundsException e1){
                JOptionPane.showMessageDialog(null,
                        "Pleas follow the instructions!");
            }

        });
        check.add(create);


        this.add(check);
        this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        this.pack();
    }
    @Override
    public void success(){
        JOptionPane.showMessageDialog(null, "Success");
        this.setVisible(false);
    }
    @Override
    public void fail(){
        JOptionPane.showMessageDialog(null,
                "Sorry, the recipe's name already exists.");
    }


}
