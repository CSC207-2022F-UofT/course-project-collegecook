package ui;
import rank.*;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class RankUI extends JFrame{
    RankController rankController;
    JPanel view = new JPanel();
    JTextField ranking = new JTextField(40);
    JButton read = new JButton("Sort");


    public RankUI(AppController appController){
        this.rankController = appController.getRankController();
        view.setLayout(new BoxLayout(view, BoxLayout.Y_AXIS));
        ranking.setAlignmentX(Component.CENTER_ALIGNMENT);
        view.add(ranking);

        read.setAlignmentX(Component.CENTER_ALIGNMENT);
        read.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                rankController.sorting(ranking.getText());
            }
        });
        view.add(read);
        this.add(view);
        this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        this.pack();
    }


}
