package ui;

import entities.Recipe;
import search.SearchController;
import search.SearchResultsBox;

import javax.swing.*;

public class SearchSortRecipesResultsUI extends JFrame implements SearchResultsBox {
    JPanel searchResultsPanel = new JPanel();
    AppController appController;

    public SearchSortRecipesResultsUI(AppController appController){
        this.appController = appController;
        searchResultsPanel.setLayout(new BoxLayout(searchResultsPanel, BoxLayout.Y_AXIS));
    }

    @Override
    public void success(Recipe[] matchingRecipes) {
        for (Recipe recipe: matchingRecipes){
            searchResultsPanel.add(new JLabel(recipe.getRecipeName()));
        }
        this.add(searchResultsPanel);
        this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        this.pack();
        this.setVisible(true);
    }

    @Override
    public void failure(String error) {
        JOptionPane.showMessageDialog(null,"Sorry, no results were found.");
    }

    //    }
}
