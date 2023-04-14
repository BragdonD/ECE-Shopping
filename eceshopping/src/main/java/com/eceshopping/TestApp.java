package com.eceshopping;

import com.eceshopping.views.EceShoppingPane;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class TestApp extends Application {
    @Override
    public void start(@SuppressWarnings("exports") Stage s) {
        EceShoppingPane eceShoppingPane = new EceShoppingPane();
        Scene scene = new Scene(eceShoppingPane, 400, 400);
        s.setScene(scene);
        s.show();
    }

    public static void main(String[] args) {

        launch(args);
    }
}
