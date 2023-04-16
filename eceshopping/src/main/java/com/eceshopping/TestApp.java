package com.eceshopping;

import com.eceshopping.configs.FlywayConfig;
import com.eceshopping.controllers.AddArticleFormController;
import com.eceshopping.controllers.LoginPageController;
import com.eceshopping.controllers.RegisterPageController;
import com.eceshopping.utils.Router;
import com.eceshopping.views.LoginPageView;
import com.eceshopping.views.RegisterPageView;
import com.eceshopping.views.components.AddArticleFormView;
import com.eceshopping.views.components.LoginFormView;
import com.eceshopping.views.components.RegisterFormView;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;

/**
 * JavaFX App class for eceshopping project 
 */
public class TestApp extends Application {
    private Router router;

    @Override
    public void start(@SuppressWarnings("exports") Stage s) {
        s.setTitle("My JavaFX App");       

        // Set the main stage inside the router controller
        this.router = Router.getInstance(); 
        this.router.getRouterController().setMainStage(s);
        AddArticleFormView addArticleView = new AddArticleFormView();
        LoginPageView loginView = new LoginPageView();
        RegisterPageView registerView = new RegisterPageView();
        // this.router.addRoute("/register", registerView, new RegisterPageController(registerView));
        // this.router.addRoute("/login", loginView, new LoginPageController(loginView));
        this.router.addRoute("/addArticle", addArticleView, new AddArticleFormController(addArticleView));
        
        
        Scene scene = new Scene(this.router.getRootPane(), 400, 400);
        this.router.getRouterController().setScene(scene);
        this.router.getRouterController().show();
        this.router.navigateTo("/addArticle");
    }

    public static void main(String[] args) {
        FlywayConfig.getInstance();
        launch(args);
    }

}