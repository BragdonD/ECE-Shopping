package com.eceshopping.views;

import com.eceshopping.views.components.ProductOverviewView;
import com.eceshopping.views.layouts.UserLayoutView;

import javafx.scene.Node;
import javafx.scene.layout.GridPane;

public class HomePageView extends UserLayoutView implements View {
    GridPane productsLayout;

    public HomePageView()  {
        productsLayout = new GridPane();
        this.productsLayout.prefHeightProperty().bind(this.slot.heightProperty());
        this.productsLayout.prefWidthProperty().bind(this.slot.widthProperty());
        this.slot.getChildren().add(productsLayout);
    }

    public GridPane getProductLayout() {
        return this.productsLayout;
    }

    public void addProduct(ProductOverviewView product) {
        this.productsLayout.getChildren().add(product);
    }

    @Override
    public Node getRootNode() {
        return this;
    }
}
