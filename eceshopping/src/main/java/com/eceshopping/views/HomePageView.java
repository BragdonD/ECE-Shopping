package com.eceshopping.views;

import com.eceshopping.configs.AppStyles;
import com.eceshopping.views.components.ProductOverviewView;
import com.eceshopping.views.layouts.UserLayoutView;

import javafx.scene.Node;
import javafx.scene.control.ScrollPane;
import javafx.scene.layout.GridPane;

public class HomePageView extends UserLayoutView implements View {
    GridPane productsLayout;
    int row;

    public HomePageView() {
        productsLayout = new GridPane();
        this.productsLayout.prefHeightProperty().bind(this.slot.heightProperty());
        this.productsLayout.prefWidthProperty().bind(this.slot.widthProperty());
        ScrollPane scrollPane = new ScrollPane(productsLayout);
        this.slot.getChildren().add(scrollPane);
        this.productsLayout.setAlignment(javafx.geometry.Pos.TOP_CENTER);
        this.productsLayout.setPadding(new javafx.geometry.Insets(20.0, 20.0, 20.0, 20.0));
        this.productsLayout.setHgap(20);
        this.productsLayout.setVgap(20);
        this.row = 0;
    }

    /**
     * @return GridPane
     */
    public GridPane getProductLayout() {
        return this.productsLayout;
    }

    /**
     * @param product
     */
    public void addProduct(ProductOverviewView product) {
        int col = row % AppStyles.PRODUCT_HOME_PAGE_NUMBER_OF_COLUMNS; // calculate the column index
        int rowIdx = row / AppStyles.PRODUCT_HOME_PAGE_NUMBER_OF_COLUMNS; // calculate the row index

        this.productsLayout.add(product, col, rowIdx);
        this.row++;
    }

    public void clearProducts() {
        this.productsLayout.getChildren().clear();
        this.row = 0;
    }

    @Override
    public Node getRootNode() {
        return this;
    }
}
