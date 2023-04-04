package com.eceshopping;

import java.util.List;

import com.eceshopping.components.Form;
import com.eceshopping.components.InputField;
import com.eceshopping.configs.FlywayConfig;
import com.eceshopping.controllers.Controller;
import com.eceshopping.controllers.LoginPageController;
import com.eceshopping.controllers.RegisterPageController;
import com.eceshopping.controllers.components.InputFieldController;
import com.eceshopping.factories.component.FormFactory;
import com.eceshopping.factories.component.InputFieldFactory;
import com.eceshopping.models.component.input.InputModel;
import com.eceshopping.utils.Router;
import com.eceshopping.utils.validator.EmailValidator;
import com.eceshopping.utils.validator.PasswordValidator;
import com.eceshopping.views.LoginPageView;
import com.eceshopping.views.RegisterPageView;
import com.eceshopping.views.components.LoginFormView;
import com.eceshopping.views.components.RegisterFormView;
import com.eceshopping.views.components.InputFieldView;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

/**
 * JavaFX App class for eceshopping project
 */
public class EceShoppingApp extends Application {
    private Router router;

    @Override
    public void start(@SuppressWarnings("exports") Stage s) {
        LoginPageView loginPage = new LoginPageView();
        RegisterPageView registerPage = new RegisterPageView();
        // Set the main stage inside the router controller
        this.router = Router.getInstance();
        this.router.addRoute("/register", registerPage, new RegisterPageController(registerPage));
        this.router.addRoute("/login", loginPage, new LoginPageController(loginPage));
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
