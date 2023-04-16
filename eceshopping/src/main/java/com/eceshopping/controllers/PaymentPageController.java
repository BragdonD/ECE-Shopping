package com.eceshopping.controllers;

import com.eceshopping.views.PaymentPageView;

import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;

public class PaymentPageController implements Controller {

    private PaymentPageView view;

    public PaymentPageController(PaymentPageView view) {
        this.view = view;

        // Get the form fields from the PaymentPage class
        TextField nameField = (TextField) this.view.getChildren().get(1);
        TextField cardField = (TextField) this.view.getChildren().get(3);
        TextField expiryField = (TextField) this.view.getChildren().get(5);
        TextField cvvField = (TextField) this.view.getChildren().get(7);
        Button payButton = (Button) this.view.getChildren().get(8);

        // Set the action for the "Pay Now" button
        payButton.setOnAction(e -> {
            if (!validateNameField(nameField.getText())) {
                showAlert("Invalid Name", "Please enter a valid name on the card.");
            } else if (!validateCardField(cardField.getText())) {
                showAlert("Invalid Card Number", "Please enter a valid card number.");
            } else if (!validateExpiryField(expiryField.getText())) {
                showAlert("Invalid Expiry Date", "Please enter a valid expiry date.");
            } else if (!validateCVVField(cvvField.getText())) {
                showAlert("Invalid CVV", "Please enter a valid CVV number.");
            } else {
                showAlert("Payment Successful", "Thank you for your payment!");
            }
        });
    }

    /**
     * Validate the name field (must not be empty)
     * @param name
     * @return
     */
    private boolean validateNameField(String name) {
        return !name.isEmpty();
    }

    /**
     * Validate the card field (must be a number with 16 digits)
     * @param card
     * @return
     */
    private boolean validateCardField(String card) {
        return card.matches("\\d{16}");
    }

    /**
     * Validate the expiry field (must be a number with 2 digits for month and 2 digits for year)
     * @param expiry
     * @return
     */
    private boolean validateExpiryField(String expiry) {
        return expiry.matches("\\d{2}/\\d{2}");
    }

    /**
     * Validate the CVV field (must be a number with 3 digits)
     * @param cvv
     * @return
     */
    private boolean validateCVVField(String cvv) {
        return cvv.matches("\\d{3}");
    }

    /**
     * Show an alert dialog with the given title and message
     * @param title
     * @param message
     */
    private void showAlert(String title, String message) {
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle(title);
        alert.setHeaderText(null);
        alert.setContentText(message);
        alert.showAndWait();
    }

    @Override
    public void bindScene(Scene scene) {
        // Do nothing
    }
}
