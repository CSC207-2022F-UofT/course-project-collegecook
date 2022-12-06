package ui;

import entities.Recipe;
import entities.Review;
import entities.ReviewDatabase;
import recipe.RecipeController;
import review.ReviewInteractor;
import search.SearchController;
import search.SearchRequestModel;
import search.SearchResponseModel;
import search.SearchResultsBox;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Objects;

public class SearchSortRecipesResultsUI extends JFrame implements SearchResultsBox {
    JPanel searchResultsPanel = new JPanel();
    AppController appController;

    public SearchSortRecipesResultsUI(AppController appController){
        this.appController = appController;
        searchResultsPanel.setLayout(new BoxLayout(searchResultsPanel, BoxLayout.Y_AXIS));
    }

    @Override
    public void success(SearchResponseModel searchResponseModel) {
        searchResultsPanel.removeAll();
        RecipeController recipeController = appController.getRecipeController();
        SearchRequestModel searchCriteria = searchResponseModel.getSearchRequestModel();
        ReviewDatabase reviewDatabase = ReviewInteractor.loadReviewDatabase();
        for (Recipe recipe: searchResponseModel.getMatchingRecipes()){
            JButton recipeButton = new JButton(recipe.getRecipeName());
            searchResultsPanel.add(recipeButton);
            recipeButton.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    recipeController.performReadRecipe(recipe.getRecipeName());
                }
            });
            if (Objects.equals(searchCriteria.getSortType(), "t")) {
                searchResultsPanel.add(new JLabel(recipe.getTime() + " minutes"));
            }
            else if (Objects.equals(searchCriteria.getSortType(), "n")){
                ArrayList<Review> reviews = reviewDatabase.getRecipeReviews(recipe);
                searchResultsPanel.add(new JLabel(reviews.size() + " reviews"));
            }
            else {
                ArrayList<Review> reviews = reviewDatabase.getRecipeReviews(recipe);
                if (reviews.size() == 0){
                    searchResultsPanel.add(new JLabel("no reviews"));
                }
                else{
                    double avgRating = (reviews.stream().mapToDouble(Review::getRating).sum())/ reviews.size();
                    searchResultsPanel.add(new JLabel("Average Rating: " + avgRating));
                    searchResultsPanel.add(new JLabel(reviews.size()+" reviews"));
                }

            }


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
