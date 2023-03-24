package com.eceshopping.controllers;

import com.eceshopping.utils.EmailValidator;
import com.eceshopping.utils.Router;
import com.eceshopping.views.RegisterFormView;


/**
 * This class is the controller of the login form view.
 **/
public class RegisterFormController implements Controller {
    private final RegisterFormView view;
    private final String textFieldErrorStyle = "-fx-border-radius: 4px; -fx-background-color: wheat; -fx-border-color: red; -fx-border-width: 2px";

    private String email;
    private String password;

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
            if (EmailValidator.validate(newValue)) {
                this.view.getEmailField().setStyle("-fx-border-color: green");
            } else {
                this.view.getEmailField().setStyle(textFieldErrorStyle);
            }
        });

        this.view.getHyperlink().setOnAction(e -> {
            Router.getInstance().navigateTo("/login");

        });
    }

}
