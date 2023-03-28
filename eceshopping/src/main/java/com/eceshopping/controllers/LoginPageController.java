package com.eceshopping.controllers;

import com.eceshopping.views.LoginPageView;

/**
 * This class is the controller of the login form view.
 **/
public class LoginPageController implements Controller {
    
    private LoginPageView view;
    

    /**
     * Constructor of the class.
     * 
     * @param view the view of the login form
     **/
    public LoginPageController(LoginPageView view) {
        this.view = view;
        

    }
}
