package com.eceshopping.controllers;

import com.eceshopping.utils.Session;

import javafx.stage.Stage;

/**
 * This class is used to handle the main stage
 */
public class MainStageController {
    private Stage stage;

    public MainStageController(Stage s) {
        this.stage = s;

        this.stage.setOnCloseRequest(e -> {
            System.out.println("Closing the application");
            if(Session.getInstance() != null) {
                Session.getInstance().clear();
            }
        });
    }
}
