package com.eceshopping.controllers;

import javafx.scene.Scene;
import javafx.stage.Stage;

public class RouterController {
    private Stage mainStage;

    public RouterController() {
        mainStage = new Stage();
    }

    public void setMainStage(Stage stage) {
        this.mainStage = stage;
    }

    public void setScene(Scene scene) {
        mainStage.setScene(scene);
    }

    public void close() {
        mainStage.close();
    }
}
