package ui;

import review.ReviewController;
import review.ReviewCreateBox;

import javax.swing.*;
import java.awt.*;

public class CreateReviewUI extends JFrame implements ReviewCreateBox {

    AppController appController;
    ReviewController reviewController;
    JTextField rating = new JTextField(40);
    JTextArea content = new JTextArea(5, 40);
    JLabel ratingQ = new JLabel("Please give your rating of the recipe (from 1-5)");
    JLabel contentQ = new JLabel("Optionally, leave a review of the recipe here");

    JPanel view = new JPanel();
    JButton save = new JButton("Save");

    public CreateReviewUI(AppController appController){
        this.appController = appController;
        this.reviewController = appController.getReviewController();
        view.setLayout(new BoxLayout(view, BoxLayout.Y_AXIS));

        ratingQ.setAlignmentX(Component.CENTER_ALIGNMENT);
        view.add(ratingQ);
        rating.setAlignmentX(Component.CENTER_ALIGNMENT);
        view.add(rating);

        view.setLayout(new BoxLayout(view, BoxLayout.Y_AXIS));
        contentQ.setAlignmentX(Component.CENTER_ALIGNMENT);
        view.add(contentQ);
        content.setAlignmentX(Component.CENTER_ALIGNMENT);
        view.add(content);
        String user = appController.getLoginControllor().preformGetLoggedInUser();
        String recipe = appController.getRecipeController().getReadingRecipe();

        save.addActionListener(e -> {

            try{
                Integer.parseInt(rating.getText());
            }catch (NumberFormatException e1){
                JOptionPane.showMessageDialog(null,
                        "Please enter an INTEGER for rating!");
            }
            int ratenum = Integer.parseInt(rating.getText());
            if (content.getText().equals("")){
                reviewController.performCreateReview(user, recipe, ratenum);
            } else {
                reviewController.performCreateReview(user, recipe, content.getText(), ratenum);
            }

            dispose();
        });
        view.add(save);

        this.add(view);
        this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        this.pack();

    }
    public void success() {
        JOptionPane.showMessageDialog(null, "Success");
        this.setVisible(false);
    }
}
