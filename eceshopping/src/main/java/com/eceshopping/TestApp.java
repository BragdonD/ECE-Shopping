package com.eceshopping;

import com.eceshopping.configs.AppSvg;
import com.eceshopping.controllers.SearchBarController;
import com.eceshopping.views.EceShoppingPane;
import com.eceshopping.views.HomePageView;
import com.eceshopping.views.components.SearchBarView;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.shape.SVGPath;
import javafx.stage.Stage;

public class TestApp extends Application {
    @Override
    public void start(@SuppressWarnings("exports") Stage s) {
       
        SearchBarView eceShoppingPane = new SearchBarView();
        SearchBarController searchBarController = new SearchBarController(eceShoppingPane);
        Scene scene = new Scene(eceShoppingPane, 400, 400);
        s.setScene(scene);
        s.show();
    }

    public static void main(String[] args) {

        launch(args);
    }
}
