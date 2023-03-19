package com.eceshopping;

import com.eceshopping.controllers.LoginFormController;
import com.eceshopping.views.LoginFormView;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class EceShoppingApp extends Application {

    @Override
    public void start(@SuppressWarnings("exports") Stage s) {
        LoginFormView view = new LoginFormView();
        new LoginFormController(view);
        Scene scene = new Scene(view, 400, 400);
        s.setTitle("My JavaFX App");
        s.setScene(scene);
        s.show();
    }

    public static void main(String[] args) {
        launch(args);
    }

}
