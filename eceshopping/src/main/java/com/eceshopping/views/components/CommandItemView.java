package com.eceshopping.views.components;

import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.GridPane;

public class CommandItemView {
    private GridPane layout;
    private Button display;
    private Label date;
    private Label price;

    public CommandItemView() {
        this.layout = new GridPane();
        this.layout.setHgap(10);
        this.layout.setVgap(10);
        this.layout.setPadding(new javafx.geometry.Insets(10, 10, 10, 10));
        this.layout.setStyle("-fx-background-color: #F5F5F5; -fx-padding: 10;");
        this.display = new Button("Display");
        this.layout.add(this.display, 0, 0);
        this.date = new Label();
        this.layout.add(this.date, 1, 0);
        this.price = new Label();
        this.layout.add(this.price, 2, 0);
    }

    public GridPane getLayout() {
        return this.layout;
    }

    public Button getDisplay() {
        return this.display;
    }

    public Label getDate() {
        return this.date;
    }

    public Label getPrice() {
        return this.price;
    }
}
