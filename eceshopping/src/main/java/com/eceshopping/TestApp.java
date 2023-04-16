package com.eceshopping;

import com.eceshopping.configs.FlywayConfig;
import com.eceshopping.controllers.AddArticleFormController;
import com.eceshopping.controllers.PaymentPageController;
import com.eceshopping.utils.Router;
import com.eceshopping.views.PaymentPageView;
import com.eceshopping.views.components.AddArticleFormView;

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
        PaymentPageView paymentPageView = new PaymentPageView();
        this.router.addRoute("/addArticle", paymentPageView, new PaymentPageController(paymentPageView));

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