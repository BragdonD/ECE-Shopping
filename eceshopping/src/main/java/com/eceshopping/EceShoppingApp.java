package com.eceshopping;

import com.eceshopping.configs.FlywayConfig;
import com.eceshopping.controllers.LoginPageController;
import com.eceshopping.controllers.MainStageController;
import com.eceshopping.controllers.RegisterPageController;
import com.eceshopping.controllers.UserInformationsPageController;
import com.eceshopping.utils.Router;
import com.eceshopping.views.LoginPageView;
import com.eceshopping.views.RegisterPageView;
import com.eceshopping.views.UserInformationsPage;

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
        new MainStageController(s);
        this.router = Router.getInstance();
        this.router.getRouterController().setMainStage(s);
        Scene scene = new Scene(this.router.getRootPane(), 400, 400);
        this.router.getRouterController().setScene(scene);
        this.router.getRouterController().show();

        LoginPageView loginPage = new LoginPageView();
        RegisterPageView registerPage = new RegisterPageView();
        UserInformationsPage userInformationPage = new UserInformationsPage();

        this.router.addRoute("/register", registerPage, new RegisterPageController(registerPage));
        this.router.addRoute("/login", loginPage, new LoginPageController(loginPage));
        this.router.addRoute("/user/informations", userInformationPage,
                new UserInformationsPageController(userInformationPage));

        this.router.navigateTo("/user/informations");
    }

    public static void main(String[] args) {
        FlywayConfig.getInstance();
        launch(args);
    }

}
