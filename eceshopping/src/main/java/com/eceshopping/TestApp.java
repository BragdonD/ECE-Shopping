package com.eceshopping;

import java.util.List;

import com.eceshopping.configs.FlywayConfig;
import com.eceshopping.controllers.AddArticleFormController;
import com.eceshopping.controllers.PaymentPageController;
import com.eceshopping.daos.ArticleDao;
import com.eceshopping.daos.PurchaseDAO;
import com.eceshopping.daos.PurchaseItemDAO;
import com.eceshopping.models.ArticleModel;
import com.eceshopping.models.PurchaseModel;
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
        List<ArticleModel> temp = new ArticleDao().getAll();
        List<PurchaseModel> temp1 = new PurchaseDAO().getAll();
        System.out.println(new PurchaseItemDAO().getAll());
    }

    public static void main(String[] args) {
        FlywayConfig.getInstance();
        launch(args);
    }

}