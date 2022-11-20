package ui;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Menu extends JFrame {
    JPanel menu = new JPanel();
    JButton create_recipe = new JButton("Create Recipe");
    JButton search_recipe = new JButton("Search Recipe");
    JButton mealPlan = new JButton("My Meal Plan");
    JButton ranking = new JButton("Ranking");
    JButton profile = new JButton("My Profile");
    JLabel title = new JLabel("CollegeCook");

    JPanel buttonPanel = new JPanel();
    JLabel userName;

    public Menu(String user){
        menu.setLayout(new BoxLayout(menu, BoxLayout.Y_AXIS));

        title.setAlignmentX(Component.CENTER_ALIGNMENT);
        title.setFont(new Font("Serif", Font.PLAIN, 100));
        menu.add(title);
        menu.add(new JLabel(""));
        userName = new JLabel("User: " + user);
        userName.setAlignmentX(Component.CENTER_ALIGNMENT);
        menu.add(userName);
        create_recipe.setAlignmentX(Component.CENTER_ALIGNMENT);
        create_recipe.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
//                CreateRecipeUI createRecipeUI = new CreateRecipeUI(user);
//                createRecipeUI.setVisible(true);
            }
        });

        menu.add(create_recipe);
        search_recipe.setAlignmentX(Component.CENTER_ALIGNMENT);

        search_recipe.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // SearchRecipeUI searchRecipeUI = new SearchRecipeUI();
                // searchRecipeUI.setVisible(true);
            }
        });
        menu.add(search_recipe);
        mealPlan.setAlignmentX(Component.CENTER_ALIGNMENT);
        menu.add(mealPlan);
        ranking.setAlignmentX(Component.CENTER_ALIGNMENT);
        menu.add(ranking);
        profile.setAlignmentX(Component.CENTER_ALIGNMENT);
        menu.add(profile);



        this.add(menu);
        this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        this.pack();
    }

    private static void addAButton(String text, Container container) {
        JButton button = new JButton(text);
        button.setAlignmentX(Component.CENTER_ALIGNMENT);
        container.add(button);
    }

    public static void main(String[] args){
        Menu m = new Menu("Brenden");
        m.setVisible(true);
    }
}
