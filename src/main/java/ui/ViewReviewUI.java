package ui;

import review.ReviewViewBox;

import javax.swing.*;
import java.awt.*;

public class ViewReviewUI extends JFrame implements ReviewViewBox {

    AppController appController;
    JPanel view = new JPanel();

    JTextArea reviewList;

    public ViewReviewUI(AppController appController){
        this.appController = appController;
        view.setLayout(new BoxLayout(view, BoxLayout.Y_AXIS));

    }

    @Override
    public void success(String reviews) {
        view.removeAll();
        reviewList = new JTextArea(reviews);
        reviewList.setEditable(false);
        reviewList.setAlignmentX(Component.CENTER_ALIGNMENT);
        view.add(reviewList);

        this.add(view);
        this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        this.pack();
        this.setVisible(true);
    }

    @Override
    public void fail() {
        JOptionPane.showMessageDialog(null,"Sorry, the recipe doesn't exist");
    }

    @Override
    public void noReviews() {
        JOptionPane.showMessageDialog(null,"This recipe has no reviews");
    }
}
