package com.eceshopping.controllers;

import com.eceshopping.utils.EmailValidation;
import com.eceshopping.utils.Router;
import com.eceshopping.views.LoginFormView;
import com.eceshopping.views.RegisterFormView;

import javafx.scene.Scene;
import javafx.scene.layout.Pane;

/**
 * This class is the controller of the login form view.
 **/
public class RegisterFormController {
    private final RegisterFormView view;
    private final String textFieldErrorStyle = "-fx-border-radius: 4px; -fx-background-color: wheat; -fx-border-color: red; -fx-border-width: 2px";

    /**
     * Constructor of the class.
     * 
     * @param view the view of the login form
     **/
    public RegisterFormController(RegisterFormView view) {
        this.view = view;
        
        this.view.getRegisterButton().setOnAction(e -> {
            System.out.println("Congrats ! You have successfully logged in");
        });

        this.view.getEmailField().textProperty().addListener((observable, oldValue, newValue) -> {
            if (EmailValidation.isValid(newValue)) {
                this.view.getEmailField().setStyle("-fx-border-color: green");
            } else {
                this.view.getEmailField().setStyle(textFieldErrorStyle);
            }
        });

        this.view.getHyperlink().setOnAction(e -> {
            System.out.println("test");
            LoginFormView loginView = new LoginFormView();
            new LoginFormController(loginView);
            Router.getInstance().getRouterController().setScene(loginView.getScene());
        });
    }

}
