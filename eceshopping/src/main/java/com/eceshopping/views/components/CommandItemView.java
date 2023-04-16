package com.eceshopping.views.components;

import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.GridPane;

public class CommandItemView extends GridPane {
    private Button display;
    private Label date;
    private Label price;

    public CommandItemView() {
        this.setHgap(10);
        this.setVgap(10);
        this.setPadding(new javafx.geometry.Insets(10, 10, 10, 10));
        this.setStyle("-fx-background-color: #F5F5F5; -fx-padding: 10;");
        this.display = new Button("Display");
        this.add(this.display, 0, 0);
        this.date = new Label();
        this.add(this.date, 1, 0);
        this.price = new Label();
        this.add(this.price, 2, 0);
    }

    /**
     * Get the value of display
     * 
     * @return
     */
    public Button getDisplay() {
        return this.display;
    }

    /**
     * Get the value of date
     */
    public Label getDate() {
        return this.date;
    }
    
    /**
      * Get the value of price
      * 
      * @return
      */
    public Label getPrice() {
        return this.price;
    }
}
     