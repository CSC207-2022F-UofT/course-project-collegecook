package ui;
import rank.RankResultBox;
import javax.swing.*;
import java.util.ArrayList;


public class RankingUI extends JFrame implements RankResultBox{
    JPanel rankResultsPanel = new JPanel();
    AppController appController;
    public RankingUI(AppController appController){
        this.appController = appController;
        rankResultsPanel.setLayout(new BoxLayout(rankResultsPanel, BoxLayout.Y_AXIS));
        this.add(rankResultsPanel);
    }
    @Override
    public void success(ArrayList<String> users, String rank) {
        rankResultsPanel = new JPanel();
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





