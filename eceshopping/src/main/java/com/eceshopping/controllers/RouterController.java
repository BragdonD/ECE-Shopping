package com.eceshopping.controllers;

import javafx.scene.Scene;
import javafx.stage.Stage;

public class RouterController {
    private Stage mainStage;

    public RouterController() {

    }

    public void setMainStage(Stage stage) {
        this.mainStage = stage;
    }

    public void setScene(Scene scene) throws IllegalStateException {
        if(mainStage == null) {
            throw new IllegalStateException("Main stage is not set");
        }
        mainStage.setScene(scene);
    }

    public void close() {
        mainStage.close();
    }
}
