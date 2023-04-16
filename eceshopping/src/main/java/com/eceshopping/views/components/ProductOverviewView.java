package com.eceshopping.views.components;

import com.eceshopping.configs.AppStyles;

import javafx.geometry.HPos;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.GridPane;

public class ProductOverviewView extends GridPane {
    private ImageView image;
    private Label title;
    private Label price;

    public ProductOverviewView(Image image, String title, Double price) {
        super();
        this.title = new Label(title);
        this.price = new Label(Double.toString(price) + " €");
        this.image = new ImageView(image);
        this.image.setFitHeight(100);
        this.image.setFitWidth(100);
        this.add(this.image, 0, 0);
        this.add(this.title, 0, 1);
        this.add(this.price, 0, 2);
        this.image.setFitHeight(170);
        this.image.setFitWidth(170);
        GridPane.setHalignment(this.image, HPos.CENTER);
        GridPane.setHalignment(this.title, HPos.CENTER);
        GridPane.setHalignment(this.price, HPos.CENTER);
        this.title.setStyle(AppStyles.PRODUCT_OVERVIEW_TITLE_STYLE);
        this.setStyle(AppStyles.PRODUCT_OVERVIEW_STYLE);
    }

    /**
     * @return ImageView
     */
    public ImageView getImage() {
        return this.image;
    }

    /**
     * @return Label
     */
    public Label getTitle() {
        return this.title;
    }

    public Label getPrice() {
        return this.price;
    }
}
