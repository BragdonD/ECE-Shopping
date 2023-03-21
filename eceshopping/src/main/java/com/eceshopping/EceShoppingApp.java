package com.eceshopping;

import com.eceshopping.utils.Router;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

public class EceShoppingApp extends Application {
    private Router router;

    @Override
    public void start(Stage s) {
        // Create the scene
        StackPane root = new StackPane();
        Scene scene = new Scene(root, 400, 400);
        s.setTitle("My JavaFX App");
        s.setScene(scene);
        s.show();

        // Set the main stage inside the router controller
        this.router = Router.getInstance(); 
        router.getRouterController().setMainStage(s);
    }

    public static void main(String[] args) {
        launch(args);
    }

}
