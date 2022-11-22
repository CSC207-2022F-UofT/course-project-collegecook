package ui;
import rank.*;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class CreateRankingUI extends JFrame{
    JPanel check = new JPanel();
    JTextField ranking = new JTextField(40);
    JLabel rankingQ = new JLabel("How would you like to rank the users? Average Rating, Total Followers, Total Number of Recipe");
    JButton create = new JButton("Sort");
    RankOutputBoundary rankOutputBoundary = new RankPresenter();
    String response;

    public CreateRankingUI(String rank) {
        check.setLayout(new BoxLayout(check, BoxLayout.Y_AXIS));
        rankingQ.setAlignmentX(Component.CENTER_ALIGNMENT);
        check.add(rankingQ);
        ranking.setAlignmentX(Component.CENTER_ALIGNMENT);
        check.add(ranking);
        create.setAlignmentX(Component.CENTER_ALIGNMENT);
        create.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                RankInputBoundary rankInputBoundary = new RankInteractor(rankOutputBoundary);
                RankController rankController = new RankController(rankInputBoundary);
                String ranking = rankingQ.getText();
                response = rankController.sorting(ranking);
            }
        });
        check.add(create);
        this.add(check);
        this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        this.pack();
    }
    public void response(){
        JOptionPane.showMessageDialog(null,response);
    }

    public static void main(String[] args){
        CreateRankingUI m = new CreateRankingUI("Average Rating");
        m.response();
    }
}
