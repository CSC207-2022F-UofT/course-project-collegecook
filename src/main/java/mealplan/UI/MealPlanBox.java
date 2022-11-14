package mealplan.UI;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MealPlanBox implements ActionListener{
   JFrame mealplanbox = new JFrame("Meal Plan");
    JPanel panel_b = new JPanel();
    JPanel panel_l = new JPanel();
    JPanel panel_d = new JPanel();
    JPanel panel_cal = new JPanel();
    JLabel label_b = new JLabel("Breakfast");
    JLabel label_l = new JLabel("Lunch");
    JLabel label_d = new JLabel("Dinner");
    JButton button_b = new JButton( new AbstractAction("delete") {
        @Override
        public void actionPerformed( ActionEvent e ) {
            // add Action
        }
    });

    JButton button_l = new JButton( new AbstractAction("delete") {
        @Override
        public void actionPerformed( ActionEvent e ) {
            // add Action
        }
    });

    JButton button_d = new JButton( new AbstractAction("delete") {
        @Override
        public void actionPerformed( ActionEvent e ) {
            // add Action
        }
    });

    JButton button_cal = new JButton( new AbstractAction("calculate calories") {
        @Override
        public void actionPerformed( ActionEvent e ) {
            // add Action
        }
    });

    public void createMealPlanBox(){
        panel_b.setBackground(Color.ORANGE);
        panel_l.setBackground(Color.YELLOW);
        panel_d.setBackground(Color.PINK);

        panel_b.add(label_b);
        panel_l.add(label_l);
        panel_d.add(label_d);

        panel_b.add(button_b);
        panel_l.add(button_l);
        panel_d.add(button_d);
        panel_d.add(button_cal);

        mealplanbox.add(panel_b);
        mealplanbox.add(panel_l);
        mealplanbox.add(panel_d);
        mealplanbox.add(panel_cal);

        mealplanbox.setLayout(new GridLayout(4,0));

        mealplanbox.setSize(400,400);
        mealplanbox.setVisible(true);
    }

    private void setCalories(String recommended, String intake){
        JLabel label_rec = new JLabel(recommended);
        JLabel label_int = new JLabel(intake);

        panel_cal.add(label_rec);
        panel_cal.add(label_int);
    }

    @Override
    public void actionPerformed(ActionEvent e) {

    }
}
