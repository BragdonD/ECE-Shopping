package com.eceshopping.views;

import com.eceshopping.views.layouts.UserLayoutView;

import javafx.scene.layout.GridPane;

public class MyCommandsPageView extends UserLayoutView implements View {
    GridPane layout;

    public MyCommandsPageView() {
        this.layout = new GridPane();
        this.layout.setHgap(10);
        this.layout.setVgap(10);
        this.layout.setPadding(new javafx.geometry.Insets(10, 10, 10, 10));
        this.layout.setStyle("-fx-background-color: #F5F5F5; -fx-padding: 10;");
        this.layout.add(new javafx.scene.control.Label("My Commands"), 0, 0);
        this.slot.getChildren().add(this.layout);
    }

    public void addCommand(javafx.scene.Node command) {
        this.layout.add(command, 0, this.layout.getChildren().size());
    }

    @Override
    public javafx.scene.Node getRootNode() {
        return this.layout;
    }
}
