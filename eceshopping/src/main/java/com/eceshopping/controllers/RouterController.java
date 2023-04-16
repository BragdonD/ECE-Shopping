package com.eceshopping.controllers;

import javafx.scene.Scene;
import javafx.stage.Stage;

/**
 * Controller for the router of the application.
 */
public class RouterController {
    private Stage mainStage;

    /**
     * Constructor for the router controller.
     */
    public RouterController() {

    }

    /**
     * Set the main stage of the application.
     * 
     * @param stage the main stage of the application.
     */
    public void setMainStage(Stage stage) {
        this.mainStage = stage;
    }

    
    /** 
     * @return Stage
     */
    public Stage getMainStage() {
        return mainStage;
    }

    /**
     * Show the main stage.
     */
    public void show() {
        mainStage.show();
    }

    /**
     * Set the scene of the main stage.
     * 
     * @param scene the scene to set.
     * @throws IllegalStateException if the main stage is not set.
     */
    public void setScene(Scene scene) throws IllegalStateException {
        if (mainStage == null) {
            throw new IllegalStateException("Main stage is not set");
        }
        mainStage.setScene(scene);
    }

    /**
     * Close the main stage.
     */
    public void close() {
        mainStage.close();
    }

    
    /** 
     * @return Scene
     */
    public Scene getScene() {
        return mainStage.getScene();
    }

    public Stage getStage() {
        return mainStage;
    }
}
