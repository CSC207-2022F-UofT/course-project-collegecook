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
    AppController appController;

    public Menu(AppController appController){
        this.appController = appController;
        menu.setLayout(new BoxLayout(menu, BoxLayout.Y_AXIS));

        title.setAlignmentX(Component.CENTER_ALIGNMENT);
        title.setFont(new Font("Serif", Font.PLAIN, 100));
        menu.add(title);
        menu.add(new JLabel(""));
        userName = new JLabel("User: " + appController.getLoginControllor().preformGetLoggedInUser());
        userName.setAlignmentX(Component.CENTER_ALIGNMENT);
        menu.add(userName);
        create_recipe.setAlignmentX(Component.CENTER_ALIGNMENT);
        create_recipe.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                CreateRecipeUI createRecipeUI = new CreateRecipeUI(appController);
                createRecipeUI.setVisible(true);
            }
        });

        menu.add(create_recipe);
        search_recipe.setAlignmentX(Component.CENTER_ALIGNMENT);

        search_recipe.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                 SearchRecipeUI searchRecipeUI = new SearchRecipeUI(appController);
                 searchRecipeUI.setVisible(true);
            }
        });
        menu.add(search_recipe);
        mealPlan.setAlignmentX(Component.CENTER_ALIGNMENT);
        menu.add(mealPlan);
        ranking.setAlignmentX(Component.CENTER_ALIGNMENT);
        menu.add(ranking);
        profile.setAlignmentX(Component.CENTER_ALIGNMENT);
        menu.add(profile);

        profile.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                ProfileUI profileUI = new ProfileUI(appController);

            }
        });



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
//        UserGateWay userGateWay = UserRepoImpl.getUserRepoImpl();
//        LoginOutputBound loginOutputBound = new LoginPresenter();
//        UserManager userManager = new UserManager(loginOutputBound, userGateWay);
//        LoginControllor loginControllor = new LoginControllor(userManager);
//
//        RecipeOutputBoundary recipeOutputBoundary = new RecipePresenter();
//        RecipeRepoGateway recipeRepoGateway = RecipeReadWriter.getRecipeRepo();
//        RecipeInputBoundary recipeInputBoundary = new RecipeInteractor(recipeOutputBoundary, recipeRepoGateway);
//        RecipeController recipeController = new RecipeController(recipeInputBoundary);
//
//        AppController appController1 = new AppController(recipeController, loginControllor);
//        Menu m = new Menu(appController1);
//        m.setVisible(true);
    }
}
