package com.eceshopping.controllers;

import com.eceshopping.views.LoginFormView;

public class LoginFormController {
    private final LoginFormView view;

    public LoginFormController(LoginFormView view) {
        this.view = view;
        this.view.getBtn().setOnAction(e -> {
            System.out.println("Congrats ! You have successfully logged in");
        });
    }
}