package com.eceshopping.views.components;

import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.ColumnConstraints;
import javafx.scene.layout.GridPane;

public class ProductOverviewView extends GridPane {
    private ImageView image;
    private ImageView star;
    private Label rating;
    private Label title;
    private Label price;

    public ProductOverviewView(Image image, String title, Double price, Double rating) {
        super();
        this.title = new Label(title);
        this.price = new Label(Double.toString(price) + " €");
        this.image = new ImageView(image);
        this.prefHeight(200);
        this.prefWidth(100);
        this.image.setFitHeight(100);
        this.image.setFitWidth(100);
        this.add(this.image, 0, 0);
        this.add(this.title, 0, 1);
        this.add(this.price, 0, 2);
        GridPane lastRow = new GridPane();
        this.star = new ImageView(new Image("images/star.png"));
        this.star.setFitHeight(20);
        this.star.setFitWidth(20);
        this.rating = new Label(Double.toString(rating));
        lastRow.add(this.price, 0, 0);
        ColumnConstraints columnConstraints = new ColumnConstraints();
        columnConstraints.setPercentWidth(50);
        lastRow.getColumnConstraints().add(columnConstraints);
        GridPane ratingLayout = new GridPane();
        ratingLayout.add(this.star, 1, 0);
        ratingLayout.add(this.rating, 0, 0);
        lastRow.add(ratingLayout, 1, 0);
        this.add(lastRow, 0, 3);
    }

    public ImageView getImage() {
        return this.image;
    }

    public Label getTitle() {
        return this.title;
    }

    public Label getPrice() {
        return this.price;
    }
}   
