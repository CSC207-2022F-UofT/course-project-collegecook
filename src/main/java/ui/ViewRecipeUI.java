package ui;

import recipe.*;
import review.ReviewController;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

public class ViewRecipeUI extends JFrame implements RecipeViewBox {
    JPanel view = new JPanel();
    JLabel all = new JLabel();
    JLabel user;
    JPanel buttonPanel = new JPanel();
    JButton review = new JButton("Review");
    JButton mealPlan = new JButton("Add to My Meal Plan");
    JButton folllow = new JButton("Follow");

    JButton reviews = new JButton("View Reviews");
    AppController appController;

    public ViewRecipeUI(AppController appController){
        this.appController = appController;
        view.setLayout(new BoxLayout(view, BoxLayout.Y_AXIS));
        view.add(all);
        folllow.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String readRecipe = appController.getRecipeController().getReadingRecipe();
                String creator = appController.getRecipeController().getRecipe(readRecipe).getCreator();
                String user = appController.getLoginControllor().preformGetLoggedInUser();
                try {
                    appController.getLoginControllor().PreformFollow(user,creator);
                } catch (IOException ex) {
                    JOptionPane.showMessageDialog(null,"You have followed the creator.");;
                }
            }
        });
        mealPlan.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                AddMealplanUI addMealplanUI = new AddMealplanUI(appController,
                        appController.getRecipeController().getReadingRecipe());
                addMealplanUI.setVisible(true);
            }
        });

        review.addActionListener(e -> {
            CreateReviewUI createReviewUI = new CreateReviewUI(appController);
            createReviewUI.setVisible(true);
        });

        reviews.addActionListener(e -> {
            ReviewController reviewController = appController.getReviewController();
            reviewController.performViewReviews(appController.getRecipeController().getReadingRecipe());
        });

        buttonPanel.add(review);
        buttonPanel.add(mealPlan);

        buttonPanel.add(folllow);
        buttonPanel.add(reviews);
        view.add(buttonPanel);
        this.add(view);
    }
    @Override
    public void success(String result){
        all.setText(result);
        all.setText("<html>" + result.replaceAll("<", "&lt;").replaceAll(">", "&gt;").
                    replaceAll("\n", "<br/>") + "</html>");
        all.setAlignmentX(Component.CENTER_ALIGNMENT);
        all.setFont(new Font("Monaco", Font.PLAIN, 15));

        this.add(view);
        this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        this.pack();
        this.setVisible(true);
    }
    @Override
    public void failure(){
        JOptionPane.showMessageDialog(null,"Sorry, the recipe doesn't exist");
    }

    @Override
    public void followSuccess() {
        JOptionPane.showMessageDialog(null,"You have followed the creator.");
    }

    @Override
    public void followFailure() {
        JOptionPane.showMessageDialog(null,"You have already followed the creator.");
    }

}
