package com.eceshopping;

import com.eceshopping.configs.FlywayConfig;
import com.eceshopping.controllers.LoginFormController;
import com.eceshopping.controllers.RegisterFormController;
import com.eceshopping.utils.Router;
import com.eceshopping.views.components.LoginFormView;
import com.eceshopping.views.components.RegisterFormView;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

/**
 * JavaFX App class for eceshopping project 
 */
public class EceShoppingApp extends Application {
    private Router router;

    @Override
    public void start(@SuppressWarnings("exports") Stage s) {
        s.setTitle("My JavaFX App");       

        // Set the main stage inside the router controller
        this.router = Router.getInstance(); 

        LoginFormView loginView = new LoginFormView();
        RegisterFormView registerView = new RegisterFormView();
        this.router.addRoute("/register", registerView, new RegisterFormController(registerView));
        this.router.addRoute("/login", loginView, new LoginFormController(loginView));
        this.router.getRouterController().setMainStage(s);

        Scene scene = new Scene(this.router.getRootPane(), 400, 400);
        this.router.getRouterController().setScene(scene);
        this.router.getRouterController().show();
        this.router.navigateTo("/login");
    }

    public static void main(String[] args) {
        FlywayConfig.getInstance();
        launch(args);
    }

}
