package com.eceshopping.views.components;

import com.eceshopping.configs.AppStyles;
import com.eceshopping.configs.AppSvg;
import com.eceshopping.configs.AppText;

import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;
import javafx.scene.shape.SVGPath;

public class SearchBarView extends HBox {
    private TextField searchBar;
    private Button searchButton;

    public SearchBarView() {
        this.searchBar = new TextField();
        this.searchButton = new Button();
        SVGPath svgPath = new SVGPath();
        svgPath.setContent(AppSvg.SEARCH_ICON);
        this.searchButton.setGraphic(svgPath);
        this.searchBar.setStyle(AppStyles.SEARCH_BAR_TEXT_FIELD_STYLE);
        this.searchBar.setPromptText(AppText.SEARCH_BAR_PLACEHOLDER);
        this.searchBar.setFocusTraversable(false);
        this.searchButton.setStyle(AppStyles.PRIMARY_BUTTON_STYLE);
        HBox.setHgrow(this.searchBar, javafx.scene.layout.Priority.ALWAYS);
        this.getChildren().addAll(this.searchBar, this.searchButton);
        this.setStyle(AppStyles.SEARCH_BAR_STYLE);
    }

    /**
     * @return TextField
     */
    public TextField getSearchBar() {
        return this.searchBar;
    }

    /**
     * @return Button
     */
    public Button getSearchButton() {
        return this.searchButton;
    }
}
