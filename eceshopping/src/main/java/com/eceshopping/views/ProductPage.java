package com.eceshopping.views;

import com.eceshopping.views.components.SearchBarView;
import com.eceshopping.views.layouts.UserLayoutView;

import javafx.scene.Node;
import javafx.scene.layout.GridPane;

public class ProductPage extends UserLayoutView implements View {
    private GridPane slotLayout;
    private GridPane productLayout;
    private GridPane controlLayout;

    public ProductPage() {
        this.slotLayout = new GridPane();
        this.productLayout = new GridPane();
        this.controlLayout = new GridPane();
        this.slotLayout.prefHeightProperty().bind(this.slot.heightProperty());
        this.slotLayout.prefWidthProperty().bind(this.slot.widthProperty());
        this.productLayout.prefHeightProperty().bind(this.slot.heightProperty());
        this.productLayout.prefWidthProperty().bind(this.slot.widthProperty());
        this.controlLayout.prefHeightProperty().bind(this.slot.heightProperty());
        this.controlLayout.prefWidthProperty().bind(this.slot.widthProperty());
        this.slotLayout.add(this.controlLayout, 0, 0);
        this.slotLayout.add(this.productLayout, 1, 0);
        this.slot.getChildren().add(slotLayout);
    }

    public GridPane getSlotLayout() {
        return this.slotLayout;
    }

    public GridPane getProductLayout() {
        return this.productLayout;
    }

    public GridPane getControlLayout() {
        return this.controlLayout;
    }

    @Override
    public Node getRootNode() {
        return this;
    }
}
