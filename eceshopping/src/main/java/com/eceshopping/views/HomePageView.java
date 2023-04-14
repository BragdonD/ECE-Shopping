package com.eceshopping.views;

import com.eceshopping.views.components.ProductOverviewView;
import com.eceshopping.views.layouts.UserLayoutView;

import javafx.scene.Node;
import javafx.scene.layout.GridPane;

public class HomePageView extends UserLayoutView implements View {
    GridPane productsLayout;
    int row;

    public HomePageView()  {
        productsLayout = new GridPane();
        this.productsLayout.prefHeightProperty().bind(this.slot.heightProperty());
        this.productsLayout.prefWidthProperty().bind(this.slot.widthProperty());
        this.slot.getChildren().add(productsLayout);
        this.productsLayout.setAlignment(javafx.geometry.Pos.TOP_CENTER);
        this.productsLayout.setPadding(new javafx.geometry.Insets(20.0, 20.0, 20.0, 20.0));
        this.productsLayout.setHgap(20);
        this.productsLayout.setVgap(20);
        this.row = 0;
    }

    public GridPane getProductLayout() {
        return this.productsLayout;
    }

    public void addProduct(ProductOverviewView product) {
        int col = row % 5; // calculate the column index
        int rowIdx = row / 5; // calculate the row index
        
        this.productsLayout.add(product, col, rowIdx);
        this.row++;
    }

    @Override
    public Node getRootNode() {
        return this;
    }
}
