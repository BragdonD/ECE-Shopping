package com.eceshopping;

import com.eceshopping.configs.AppSvg;
import com.eceshopping.controllers.components.SearchBarController;
import com.eceshopping.factories.components.NavBarFactory;
import com.eceshopping.views.EceShoppingPane;
import com.eceshopping.views.HomePageView;
import com.eceshopping.views.components.SearchBarView;
import com.eceshopping.views.components.UserNavBarView;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.GridPane;
import javafx.scene.shape.SVGPath;
import javafx.stage.Stage;

public class TestApp extends Application {
    @Override
    public void start(@SuppressWarnings("exports") Stage s) {
        GridPane grid = new GridPane();
        UserNavBarView eceShoppingPane = NavBarFactory.createUserNavBarView();
        SearchBarController searchBarController = new SearchBarController(eceShoppingPane.getSearchBar());
        grid.add(eceShoppingPane, 0, 0);
        Scene scene = new Scene(grid, 400, 400);
        grid.prefWidthProperty().bind(scene.widthProperty());
        eceShoppingPane.bindScene(scene);
        s.setScene(scene);
        s.show();
    }

    public static void main(String[] args) {

        launch(args);
    }
}
