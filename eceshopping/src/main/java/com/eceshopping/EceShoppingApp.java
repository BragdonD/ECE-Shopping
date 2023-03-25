package com.eceshopping;



import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

public class EceShoppingApp extends Application {

    @Override
    public void start(Stage s) {
        StackPane root = new StackPane();
        Scene scene = new Scene(root, 400, 400);
        s.setTitle("My JavaFX App");
        s.setScene(scene);
        s.show();
    }

    public static void main(String[] args) {
        launch(args);
    }

}
