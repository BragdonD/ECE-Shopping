package com.eceshopping.controllers;

import javafx.scene.Scene;
import javafx.stage.Stage;

/**
 * Router controller class for the application
 */
public class RouterController {
    private Stage mainStage;

    /**
     * Constructor for the class RouterController
     */
    public RouterController() {
        mainStage = new Stage();
    }

    /**
     * Set the main stage of the application
     * @param stage Stage instance
     */
    public void setMainStage(Stage stage) {
        this.mainStage = stage;
    }

    /**
     * Get the main stage of the application
     * @return Stage instance
     */
    public void setScene(Scene scene) {
        mainStage.setScene(scene);
    }

    /**
     * Close the main stage of the application
     */
    public void close() {
        mainStage.close();
    }
}
