package ui;

import rank.RankController;

import javax.swing.*;
import java.awt.*;
import java.io.IOException;

public class RankingSortUI extends JFrame {
    JTextField nameInput = new JTextField(100);
    JLabel nameLabel = new JLabel("Sort by average rating, total number of recipe or total followers");
    JLabel title = new JLabel("Ranking Users");
    // search button
    JButton rankButton = new JButton("Rank");
    // search panel
    JPanel rankPanel = new JPanel();
    RankController rankController;
    public RankingSortUI(AppController appController){
        this.rankController = appController.getRankController();
        title.setAlignmentX(Component.CENTER_ALIGNMENT);
        nameInput.setAlignmentX(Component.CENTER_ALIGNMENT);
        nameLabel.setAlignmentX(Component.CENTER_ALIGNMENT);
        rankPanel.add(nameInput);
        rankPanel.add(nameLabel);
        rankButton.setAlignmentX(Component.CENTER_ALIGNMENT);
        rankButton.addActionListener(e -> {
                rankController.sorting(nameInput.getText());
            });
        rankPanel.add(rankButton);
        this.add(rankPanel);
        this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        this.pack();
}}
