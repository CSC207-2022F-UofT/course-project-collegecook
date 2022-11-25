package ui;
import entities.User;
import rank.RankController;
import rank.RankResultBox;
import javax.swing.*;


public class RankingUI extends JFrame implements RankResultBox{
    JPanel rankResultsPanel = new JPanel();
    AppController appController;
    public RankingUI(AppController appController){
        this.appController = appController;
        rankResultsPanel.setLayout(new BoxLayout(rankResultsPanel, BoxLayout.Y_AXIS));
    }
    @Override
    public void success(User[] users) {
        for (User user: users){
            rankResultsPanel.add(new JLabel(user.getUsername()));
        }}
    @Override
    public void failure(String error) {
        rankResultsPanel.add(new JLabel(error));
    }
            }




