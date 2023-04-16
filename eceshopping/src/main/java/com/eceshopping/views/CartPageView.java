package com.eceshopping.views;

import com.eceshopping.configs.AppStyles;
import com.eceshopping.views.components.CartItemView;
import com.eceshopping.views.layouts.UserLayoutView;

import javafx.geometry.HPos;
import javafx.scene.Node;
import javafx.scene.control.Label;
import javafx.scene.layout.ColumnConstraints;
import javafx.scene.layout.GridPane;

public class CartPageView extends UserLayoutView implements View {
    private GridPane cartLayout;
    private Label totalPrice;
    int item;

    public CartPageView() {
        this.item = 1;
        this.cartLayout = new GridPane();
        this.totalPrice = new Label();
        GridPane priceLayout = new GridPane();
        Label price = new Label("Total price: ");
        this.totalPrice.setText("0");
        price.setStyle(AppStyles.CART_TOTAL_PRICE_STYLE);
        this.totalPrice.setStyle(AppStyles.CART_TOTAL_PRICE_STYLE);
        priceLayout.add(price, 0, 0);
        priceLayout.add(totalPrice, 1, 0);
        this.cartLayout.add(priceLayout, 0, 0);
        ColumnConstraints column1 = new ColumnConstraints();
        column1.setPercentWidth(80);
        column1.setMinWidth(400);
        column1.setHalignment(HPos.CENTER);
        this.cartLayout.setAlignment(javafx.geometry.Pos.TOP_CENTER);
        this.cartLayout.getColumnConstraints().add(column1);
        this.slot.getChildren().add(cartLayout);
    }

    public void setLayout() {
        this.cartLayout.setAlignment(javafx.geometry.Pos.TOP_CENTER);
        this.cartLayout.setPadding(new javafx.geometry.Insets(20.0, 20.0, 20.0, 20.0));
        this.cartLayout.setHgap(20);
        this.cartLayout.setVgap(20);
    }

    
    /** 
     * @return GridPane
     */
    public GridPane getCartLayout() {
        return cartLayout;
    }

    
    /** 
     * @param cartItemView
     */
    public void addProductToCart(CartItemView cartItemView) {
        this.cartLayout.add(cartItemView, 0, item);
        item++;
    }

    public Label getTotalPrice() {
        return totalPrice;
    }

    public void setTotalPrice(String totalPrice) {
        this.totalPrice.setText(totalPrice + " €");
        ;
    }

    public void removeProductFromCart(CartItemView cartItemView) {
        this.cartLayout.getChildren().remove(cartItemView);
        item--;
    }

    @Override
    public Node getRootNode() {
        return this;
    }
}