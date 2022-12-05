package ui;

import mealplan.MealplanBoxUI;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

/**
 * Main menu screen once a user is logged in
 */
public class Menu extends JFrame {
    JPanel menu = new JPanel();
    JButton create_recipe = new JButton("Create Recipe");
    JButton search_recipe = new JButton("Search Recipe");
    JButton searchSortRecipe = new JButton("Search and Sort for Recipes");
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

        // title: CollegeCook
        title.setAlignmentX(Component.CENTER_ALIGNMENT);
        title.setFont(new Font("Serif", Font.PLAIN, 100));
        menu.add(title);
        menu.add(new JLabel(""));

        // user: username
        userName = new JLabel("User: " + appController.getLoginControllor().preformGetLoggedInUser());
        userName.setAlignmentX(Component.CENTER_ALIGNMENT);
        menu.add(userName);

        // create recipe button
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

        // read one recipe button
        search_recipe.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                 SearchRecipeUI searchRecipeUI = new SearchRecipeUI(appController);
                 searchRecipeUI.setVisible(true);
            }
        });
        menu.add(search_recipe);

        // search and sort for recipes button
        searchSortRecipe.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                SearchSortRecipesUI searchSortRecipesUI = new SearchSortRecipesUI(appController);
                searchSortRecipesUI.setVisible(true);
            }
        });
        menu.add(searchSortRecipe);
        searchSortRecipe.setAlignmentX(Component.CENTER_ALIGNMENT);

        // my meal plan button
        mealPlan.setAlignmentX(Component.CENTER_ALIGNMENT);
        mealPlan.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                MealplanBoxUI mealplanBoxUI = null;
                try {
                    mealplanBoxUI = new MealplanBoxUI(appController);
                } catch (IOException ex) {
                    throw new RuntimeException(ex);
                }
                mealplanBoxUI.setVisible(true);
            }
        });
        menu.add(mealPlan);

        // ranking button
        ranking.setAlignmentX(Component.CENTER_ALIGNMENT);


        menu.add(ranking);

        // my profile button
        profile.setAlignmentX(Component.CENTER_ALIGNMENT);
        menu.add(profile);
        profile.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                ProfileUI profileUI = new ProfileUI(appController);
                profileUI.setVisible(true);
            }
        });

        // add entire menu to screen
        this.add(menu);
        this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        this.pack();

        ranking.setAlignmentX(Component.CENTER_ALIGNMENT);

        ranking.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                RankUI rankUI = new RankUI(appController);
                rankUI.setVisible(true);
            }
        });
        menu.add(ranking);
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
