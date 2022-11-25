package ui;

import javax.swing.*;

public class CreateReviewUI extends JFrame {

    AppController appController;

    JPanel view = new JPanel();

    public CreateReviewUI(AppController appController){
        this.appController = appController;
        view.setLayout(new BoxLayout(view, BoxLayout.Y_AXIS));
    }
}
