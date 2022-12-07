package ui;
import rank.*;

import javax.swing.*;
import java.awt.*;
import java.io.IOException;

public class RankUI extends JFrame{
    RankController rankController;
    JPanel view = new JPanel();
    JTextField ranking = new JTextField(40);
    JLabel rankingQ = new JLabel("Sort by \"average rating\", \"total number of recipe\" or \"total followers\"");
    JButton read = new JButton("Sort");


    public RankUI(AppController appController){
        this.rankController = appController.getRankController();
        view.setLayout(new BoxLayout(view, BoxLayout.Y_AXIS));

        rankingQ.setAlignmentX(Component.CENTER_ALIGNMENT);
        view.add(rankingQ);
        ranking.setAlignmentX(Component.CENTER_ALIGNMENT);
        view.add(ranking);


        read.setAlignmentX(Component.CENTER_ALIGNMENT);
        read.addActionListener(e -> {
            try {
                rankController.sorting(ranking.getText());
            } catch (IOException ex) {
                throw new RuntimeException(ex);
            }
        });
        view.add(read);
        this.add(view);
        this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        this.pack();
    }


}
