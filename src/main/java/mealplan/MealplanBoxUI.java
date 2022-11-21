package mealplan;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.io.IOException;
import java.util.List;

import profile.ProfileInputBoundary;
import profile.ProfileInteractor;
import profile.ProfilePresenter;
import recipe.*;
import ui.AppController;

public class MealplanBoxUI extends JFrame implements MealplanBox{
    AppController appController;

    JPanel panel_b = new JPanel();
    JPanel panel_l = new JPanel();
    JPanel panel_d = new JPanel();
    JPanel panel_s = new JPanel();
    JLabel label_b = new JLabel("Breakfast");
    JLabel label_l = new JLabel("Lunch");
    JLabel label_d = new JLabel("Dinner");
    public MealplanBoxUI(AppController appController){
        this.appController= appController;

        JButton button_b = new JButton( new AbstractAction("delete") {
            @Override
            public void actionPerformed( ActionEvent e ) {
                appController.getMealplanController().deleteMealplan(0);
            }


        });

        JButton button_l = new JButton( new AbstractAction("delete") {
            @Override
            public void actionPerformed( ActionEvent e ) {
                appController.getMealplanController().deleteMealplan(1);
            }
        });

        JButton button_d = new JButton( new AbstractAction("delete") {
            @Override
            public void actionPerformed( ActionEvent e ) {
                appController.getMealplanController().deleteMealplan(2);
            }
        });

        JButton button_cal = new JButton( new AbstractAction("calculate calories") {
            @Override
            public void actionPerformed( ActionEvent e ) {
                try {
                    appController.getMealplanController().getCalories();
                } catch (IOException ex) {
                    throw new RuntimeException(ex);
                }
            }
        });

        JButton button_save = new JButton( new AbstractAction("Save") {
            @Override
            public void actionPerformed( ActionEvent e ) {
                try {
                    appController.getMealplanController().saveMealplan();
                } catch (IOException ex) {
                    throw new RuntimeException(ex);
                }
            }
        });


        panel_b.setBackground(Color.ORANGE);
        panel_l.setBackground(Color.YELLOW);
        panel_d.setBackground(Color.PINK);

        panel_b.add(label_b);
        panel_l.add(label_l);
        panel_d.add(label_d);

        panel_b.add(button_b);
        panel_l.add(button_l);
        panel_d.add(button_d);
        panel_s.add(button_cal);
        panel_s.add(button_save);

        this.add(panel_b);
        this.add(panel_l);
        this.add(panel_d);
        this.add(panel_s);

        this.setLayout(new GridLayout(4,0));

        this.setSize(600,600);
    }

    public void setMealplan(String recipe, int meal){

        JButton button_m = new JButton( new AbstractAction(recipe) {
            @Override
            public void actionPerformed( ActionEvent e ) {
                appController.getMealplanController().displayRecipe(recipe);
            }
        });

        if (meal == 0){
            panel_b.add(button_m);

        } else if (meal == 1) {
            panel_l.add(button_m);
        } else {
            panel_d.add(button_m);
        }
    }

    public void setCalories(List<Integer> cal){
        JLabel label_cal = new JLabel("Recommended:" + cal.get(0) + "cal; " +
                "Total:" + cal.get(1));

        panel_s.add(label_cal);
    }


}