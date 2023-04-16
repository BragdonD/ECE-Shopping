package com.eceshopping.views.components;

import com.eceshopping.configs.AppStyles;

import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.layout.GridPane;

public class CartItemView extends GridPane {
    private ProductOverviewView productOverviewView;
    private Label quantity;
    private Button removeButton;
    private Button deleteButton;

    public CartItemView(Image image, String title, Double price, Integer quantity) {
        this.productOverviewView = new ProductOverviewView(image, title, price);
        this.removeButton = new Button("Remove");
        this.quantity = new Label(quantity.toString());
        this.deleteButton = new Button("Delete");
        this.add(this.productOverviewView, 0, 0);
        this.add(this.quantity, 1, 0);
        this.add(this.removeButton, 2, 0);
        this.add(this.deleteButton, 3, 0);
        this.setHgap(30);
        this.setStyle(AppStyles.CART_ITEM_STYLE);
    }

    /**
     * @return ProductOverviewView
     */
    public ProductOverviewView getProductOverviewView() {
        return this.productOverviewView;
    }

    /**
     * @return Label
     */
    public Label getQuantity() {
        return this.quantity;
    }

    public Button getRemoveButton() {
        return this.removeButton;
    }

    public Button getDeleteButton() {
        return this.deleteButton;
    }
}