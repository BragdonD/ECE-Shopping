package com.eceshopping.views;

import javafx.geometry.Insets;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

public class PaymentPageView extends GridPane implements View {

    public PaymentPageView() {
        // Set the padding and gap between elements in the grid
        setPadding(new Insets(10));
        setHgap(10);
        setVgap(10);

        // Add the payment form elements to the grid
        Label nameLabel = new Label("Name on Card:");
        TextField nameField = new TextField();
        add(nameLabel, 0, 0);
        add(nameField, 1, 0);

        Label cardLabel = new Label("Card Number:");
        TextField cardField = new TextField();
        add(cardLabel, 0, 1);
        add(cardField, 1, 1);

        Label expiryLabel = new Label("Expiry Date:");
        TextField expiryField = new TextField();
        add(expiryLabel, 0, 2);
        add(expiryField, 1, 2);

        Label cvvLabel = new Label("CVV:");
        TextField cvvField = new TextField();
        add(cvvLabel, 0, 3);
        add(cvvField, 1, 3);

        Button payButton = new Button("Pay Now");
        add(payButton, 1, 4);

        // Set the style of the payment page
        setStyle("-fx-background-color: #F5F5F5; -fx-padding: 10;");
    }

    @Override
    public Node getRootNode() {
        return this;
    }
}