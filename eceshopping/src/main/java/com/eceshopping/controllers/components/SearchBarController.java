package com.eceshopping.controllers.components;

import java.util.ArrayList;
import java.util.List;

import com.eceshopping.configs.AppStyles;
import com.eceshopping.views.components.SearchBarView;

import javafx.beans.property.SimpleStringProperty;
import javafx.beans.value.ChangeListener;
import javafx.scene.input.KeyCode;
import javafx.scene.input.MouseEvent;

public class SearchBarController {
    private SearchBarView view;
    private boolean isFocused = false;
    private SimpleStringProperty searchQuery;
    private List<ChangeListener<String>> searchQueryListeners;

    public SearchBarController(SearchBarView view) {
        this.view = view;
        this.searchQuery = new SimpleStringProperty();
        this.searchQueryListeners = new ArrayList<ChangeListener<String>>();
        setupSearchButton();
        setupSearchBar();
    }

    public void addSearchQueryListener(ChangeListener<String> listener) {
        this.searchQueryListeners.add(listener);
        this.searchQuery.addListener(listener);
    }

    public void removeSearchQueryListener(ChangeListener<String> listener) {
        this.searchQueryListeners.remove(listener);
        this.searchQuery.removeListener(listener);
    }

    private void notifyListeners() {
        for (ChangeListener<String> listener : this.searchQueryListeners) {
            listener.changed(this.searchQuery, null, this.searchQuery.get());
        }
    }

    private void setupSearchButton() {
        this.view.getSearchButton().setOnMouseEntered(e -> {
            this.view.getSearchButton().setStyle(AppStyles.PRIMARY_BUTTON_STYLE_HOVER); 
        });
        this.view.getSearchButton().setOnMouseExited(e -> {
            this.view.getSearchButton().setStyle(AppStyles.PRIMARY_BUTTON_STYLE); 
        });
    }

    private void setupSearchBar() {
        this.view.getSearchBar().setOnMouseEntered(e -> {
            this.view.getSearchBar().setStyle(AppStyles.SEARCH_BAR_TEXT_FIELD_STYLE_HOVER); 
        });
        this.view.getSearchBar().setOnMouseExited(e -> {
            if (!isFocused) {
                this.view.getSearchBar().setStyle(AppStyles.SEARCH_BAR_TEXT_FIELD_STYLE); 
            }
        });
        this.view.getSearchBar().setOnMouseClicked(e -> {
            isFocused = true;
            this.view.getSearchBar().setStyle(AppStyles.SEARCH_BAR_TEXT_FIELD_STYLE_FOCUS); 
        });

        this.view.getSearchBar().setOnKeyPressed(e -> {
            if(e.getCode() == KeyCode.ENTER)
                search();
            if(e.getCode() == KeyCode.ESCAPE) {
                isFocused = false;
                this.view.getSearchBar().getParent().requestFocus();
                this.view.getSearchBar().setStyle(AppStyles.SEARCH_BAR_TEXT_FIELD_STYLE); 
            }
        });
    }

    private void search() {
        notifyListeners();
        System.out.println("Search for: " + this.view.getSearchBar().getText());
    }
}
