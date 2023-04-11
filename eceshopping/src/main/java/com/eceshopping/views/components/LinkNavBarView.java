package com.eceshopping.views.components;

import com.eceshopping.configs.AppStyles;

import javafx.scene.layout.HBox;
import javafx.scene.text.Text;

/*
 * LinkNavBarView class is a utility class for creating a link in the navigation bar.
 */
public class LinkNavBarView extends HBox {
    String name;
    Text text;

    public LinkNavBarView(String text) {
        this.name = text;
        this.text = new Text(text);
        this.getChildren().add(this.text);
        this.setStyle(AppStyles.NAVBAR_BUTTON_STYLE);
    }

    public void bindHeight(HBox parent) {
        this.prefHeightProperty().bind(parent.heightProperty());
    }
}
