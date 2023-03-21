package com.eceshopping.controllers;

import com.eceshopping.views.LoginFormView;

/**
 * This class is the controller of the login form view.
 **/
public class LoginFormController {
    private final LoginFormView view;

    /**
     * Constructor of the class.
     * @param view the view of the login form
     **/
    public LoginFormController(LoginFormView view) {
        this.view = view;
        this.view.getButton().setOnAction(e -> {
            System.out.println("Congrats ! You have successfully logged in");
        });
    }
}