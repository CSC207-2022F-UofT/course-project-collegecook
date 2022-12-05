package ui;
import entities.AverageRatings;
import entities.Profile;
import entities.User;
import rank.RankResultBox;
import javax.swing.*;
import java.util.ArrayList;


public class RankingUI extends JFrame implements RankResultBox{
    JPanel rankResultsPanel = new JPanel();
    AppController appController;
    public RankingUI(AppController appController){
        this.appController = appController;
        rankResultsPanel.setLayout(new BoxLayout(rankResultsPanel, BoxLayout.Y_AXIS));
    }
    @Override
    public void success(ArrayList<String> users, String rank) {
        for (String user: users){
                rankResultsPanel.add(new JLabel(user));
            }

        this.add(rankResultsPanel);
        this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        this.pack();
        this.setVisible(true);
    }
    @Override
    public void failure(String error) {
        rankResultsPanel.add(new JLabel(error));
    }
            }




