package com.eceshopping.controllers.components;

import com.eceshopping.configs.AppStyles;
import com.eceshopping.events.FocusSearchEvent;
import com.eceshopping.events.SearchEvent;
import com.eceshopping.utils.Router;
import com.eceshopping.views.components.SearchBarView;

import javafx.scene.input.KeyCode;

/**
 * SearchBarController class is the controller for the SearchBarView class.
 */
public class SearchBarController {
    private SearchBarView view;
    private boolean isFocused = false; // Represents if the search bar is focused or not
    private String query; // Represents the query of the search bar

    /**
     * Constructor of the SearchBarController class.
     * 
     * @param view The view of the search bar
     */
    public SearchBarController(SearchBarView view) {
        this.view = view;
        this.query = "";
        setupSearchButton();
        setupSearchBar();
        Router.getInstance().getRouterController().getStage().addEventHandler(FocusSearchEvent.FOCUS_SEARCH_EVENT,
                e -> {
                    System.out.println("Focus search event");
                    if (e.getFocus()) {
                        focus();
                    } else {
                        unfocus();
                    }
                    e.consume();
                });
    }

    /**
     * Setup the search button style and action.
     */
    private void setupSearchButton() {
        this.view.getSearchButton().setOnMouseEntered(e -> {
            this.view.getSearchButton().setStyle(AppStyles.PRIMARY_BUTTON_STYLE_HOVER);
        });
        this.view.getSearchButton().setOnMouseExited(e -> {
            this.view.getSearchButton().setStyle(AppStyles.PRIMARY_BUTTON_STYLE);
        });
        this.view.getSearchButton().setOnMouseClicked(e -> {
            search();
            unfocus();
        });
    }

    /**
     * Setup the search bar text field style and action.
     */
    private void setupSearchBar() {
        this.view.getSearchBar().textProperty().addListener((observable, oldValue, newValue) -> {
            this.query = newValue;
            search();
        });
        this.view.getSearchBar().setOnMouseEntered(e -> {
            this.view.getSearchBar().setStyle(AppStyles.SEARCH_BAR_TEXT_FIELD_STYLE_HOVER);
        });
        this.view.getSearchBar().setOnMouseExited(e -> {
            if (!isFocused) {
                this.view.getSearchBar().setStyle(AppStyles.SEARCH_BAR_TEXT_FIELD_STYLE);
            }
        });
        this.view.getSearchBar().setOnMouseClicked(e -> {
            focus();
        });

        this.view.getSearchBar().setOnKeyPressed(e -> {
            if (e.getCode() == KeyCode.ENTER) {
                search();
                unfocus();
            }
            if (e.getCode() == KeyCode.ESCAPE) {
                unfocus();
            }
        });
    }

    /**
     * Focus the search bar.
     */
    private void focus() {
        this.view.getSearchBar().requestFocus();
        this.view.getSearchBar().setStyle(AppStyles.SEARCH_BAR_TEXT_FIELD_STYLE_FOCUS);
        isFocused = true;
        if (!Router.getInstance().getCurrentRoute().equals("/")) {
            Router.getInstance().navigateTo("/");
        }
    }

    /**
     * Unfocus the search bar.
     */
    private void unfocus() {
        isFocused = false;
        this.view.getSearchBar().getParent().requestFocus();
        this.view.getSearchBar().setStyle(AppStyles.SEARCH_BAR_TEXT_FIELD_STYLE);
    }

    /**
     * Search the query.
     */
    private void search() {
        Router.getInstance().getRouterController().getStage().fireEvent(new SearchEvent(query));
    }
}
