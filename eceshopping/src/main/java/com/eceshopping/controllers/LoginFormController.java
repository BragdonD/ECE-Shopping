package com.eceshopping.controllers;

import com.eceshopping.utils.EmailValidation;
import com.eceshopping.utils.Router;
import com.eceshopping.views.LoginFormView;

import javafx.scene.Scene;
import javafx.scene.layout.Pane;

/**
 * This class is the controller of the login form view.
 **/
public class LoginFormController {
    private final LoginFormView view;
    private final String textFieldErrorStyle = "-fx-border-radius: 4px; -fx-background-color: wheat; -fx-border-color: red; -fx-border-width: 2px";

    /**
     * Constructor of the class.
     * 
     * @param view the view of the login form
     **/
    public LoginFormController(LoginFormView view) {
        this.view = view;
        
        this.view.getButton().setOnAction(e -> {
            System.out.println("Congrats ! You have successfully logged in");
        });

        this.view.getUserTextField().textProperty().addListener((observable, oldValue, newValue) -> {
            if (EmailValidation.isValid(newValue)) {
                this.view.getUserTextField().setStyle("-fx-border-color: green");
            } else {
                this.view.getUserTextField().setStyle(textFieldErrorStyle);
            }
        });

        this.view.getHyperlink().setOnAction(e -> {
            Pane registerPane = new Pane(); // Need to be changed with the register view
            Scene registerScene = new Scene(registerPane, 400, 400); // Need to be changed with the register controller
            Router.getInstance().getRouterController().setScene(registerScene);
        });
    }

}
