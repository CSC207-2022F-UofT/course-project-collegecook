package mealplan;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import entities.Mealplan;
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
    List<JButton> listOfBreakfast = new ArrayList<>();
    List<JButton> listOfLunch = new ArrayList<>();
    List<JButton> listOfDinner = new ArrayList<>();
    public MealplanBoxUI(AppController appController) throws IOException {
        this.appController= appController;

        JButton button_b = new JButton( new AbstractAction("delete") {
            @Override
            public void actionPerformed( ActionEvent e ) {
                appController.getMealplanController().deleteMealplan(0);
                for(JButton b:listOfBreakfast){
                    panel_b.remove(b);
                    b = null;
                }
                panel_b.revalidate();
                panel_b.repaint();

            }

        });
        button_b.setBackground(Color.RED);
        button_b.setOpaque(true);

        JButton button_l = new JButton( new AbstractAction("delete") {
            @Override
            public void actionPerformed( ActionEvent e ) {

                appController.getMealplanController().deleteMealplan(1);
                for(JButton l:listOfLunch){
                    panel_l.remove(l);
                    l = null;
                }
                panel_l.revalidate();
                panel_l.repaint();
            }
        });
        button_l.setBackground(Color.RED);
        button_l.setOpaque(true);

        JButton button_d = new JButton( new AbstractAction("delete") {
            @Override
            public void actionPerformed( ActionEvent e ) {
                appController.getMealplanController().deleteMealplan(2);
                for(JButton d:listOfDinner){
                    panel_d.remove(d);
                    d = null;
                }
                panel_d.revalidate();
                panel_d.repaint();
            }
        });
        button_d.setBackground(Color.RED);
        button_d.setOpaque(true);

        JButton button_cal = new JButton( new AbstractAction("calculate calories") {
            @Override
            public void actionPerformed( ActionEvent e ) {
                try {
                    String username = appController.getLoginControllor().preformGetLoggedInUser();
                    appController.getMealplanController().getCalories(username);
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

        ArrayList<ArrayList<String>>  mealplan =
                appController.getMealplanController().mealplanInputBoundary.getMealplan().returnMealPlan();

        for (String recipe: mealplan.get(0)){
            JButton button_m = new JButton( new AbstractAction(recipe) {
                @Override
                public void actionPerformed( ActionEvent e ) {
                    appController.getMealplanController().displayRecipe(recipe);
                }
            });

            panel_b.add(button_m);
            listOfBreakfast.add(button_m);
        }

        for (String recipe: mealplan.get(1)){
            JButton button_m = new JButton( new AbstractAction(recipe) {
                @Override
                public void actionPerformed( ActionEvent e ) {
                    appController.getMealplanController().displayRecipe(recipe);
                }
            });

            panel_l.add(button_m);
            listOfLunch.add(button_m);
        }

        for (String recipe: mealplan.get(2)){
            JButton button_m = new JButton( new AbstractAction(recipe) {
                @Override
                public void actionPerformed( ActionEvent e ) {
                    appController.getMealplanController().displayRecipe(recipe);
                }
            });

            panel_d.add(button_m);
            listOfDinner.add(button_m);
        }

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


    public void setCalories(List<Integer> cal){

        JOptionPane.showMessageDialog(null, "Recommended:" + cal.get(0) + "cal; " +
                "Total:" + cal.get(1));
    }

}