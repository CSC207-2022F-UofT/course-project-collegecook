package ui;

import entities.Recipe;
import search.SearchController;

import javax.swing.*;

public class SearchSortRecipesResultsUI extends JFrame{
    JPanel searchResultsPanel = new JPanel();
    SearchController searchController;

    public SearchSortRecipesResultsUI(AppController appController, Recipe[] searchResults){
        for (Recipe recipe: searchResults){
            searchResultsPanel.add(new JLabel(recipe.getRecipeName()));
        }
    }

}
