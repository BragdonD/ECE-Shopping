package com.eceshopping;

import com.eceshopping.controllers.LoginFormController;
import com.eceshopping.controllers.RegisterFormController;
import com.eceshopping.views.LoginFormView;
import com.eceshopping.views.RegisterFormView;
import com.eceshopping.utils.Router;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;

/**
 * JavaFX App class for eceshopping project 
 */
public class EceShoppingApp extends Application {
    private Router router;

    @Override
    public void start(@SuppressWarnings("exports") Stage s) {
        LoginFormView loginView = new LoginFormView();
        /*new LoginFormController(view);*/
        Scene scene = new Scene(loginView, 400, 400);
        s.setTitle("My JavaFX App");
        s.setScene(scene);
        s.show();

        // Set the main stage inside the router controller
        this.router = Router.getInstance(); 
        RegisterFormView registerView = new RegisterFormView();
        this.router.addRoute("/register", registerView, new RegisterFormController(registerView));
        this.router.addRoute("/login", loginView, new LoginFormController(loginView));
        router.getRouterController().setMainStage(s);
    }

    public static void main(String[] args) {
        launch(args);
    }

}
