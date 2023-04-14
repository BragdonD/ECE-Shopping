package com.eceshopping;

import com.eceshopping.configs.AppSvg;
import com.eceshopping.controllers.components.SearchBarController;
import com.eceshopping.events.FocusSearchEvent;
import com.eceshopping.events.LooseFocusEvent;
import com.eceshopping.events.SearchEvent;
import com.eceshopping.factories.components.NavBarFactory;
import com.eceshopping.utils.Router;
import com.eceshopping.views.EceShoppingPane;
import com.eceshopping.views.HomePageView;
import com.eceshopping.views.components.SearchBarView;
import com.eceshopping.views.components.UserNavBarView;

import javafx.application.Application;
import javafx.beans.property.BooleanProperty;
import javafx.beans.property.SimpleBooleanProperty;
import javafx.scene.Scene;
import javafx.scene.input.KeyCode;
import javafx.scene.layout.GridPane;
import javafx.scene.shape.SVGPath;
import javafx.stage.Stage;

public class TestApp extends Application {
    final BooleanProperty ctrlPressed = new SimpleBooleanProperty(false);
    final BooleanProperty kPressed = new SimpleBooleanProperty(false);
    private Router router;

    @Override
    public void start(@SuppressWarnings("exports") Stage s) {
        this.router = Router.getInstance();
        this.router.getRouterController().setMainStage(s);


        GridPane grid = new GridPane();
        UserNavBarView eceShoppingPane = NavBarFactory.createUserNavBarView();
        SearchBarController searchBarController = new SearchBarController(eceShoppingPane.getSearchBar());
        
        grid.add(eceShoppingPane, 0, 0);
        Scene scene = new Scene(grid, 400, 400);
        scene.setOnKeyPressed(e -> {
            if(e.getCode() == KeyCode.CONTROL)
                ctrlPressed.set(true);
            if(e.getCode() == KeyCode.K)
                kPressed.set(true);
            if(ctrlPressed.get() && kPressed.get()) {
                s.fireEvent(new FocusSearchEvent(true));
            }
            if(e.getCode() == KeyCode.ESCAPE) {
                s.fireEvent(new LooseFocusEvent());
                s.fireEvent(new FocusSearchEvent(false));
            }
        });
        grid.prefWidthProperty().bind(scene.widthProperty());
        eceShoppingPane.bindScene(scene);
        s.setScene(scene);
        s.show();

        s.addEventHandler(SearchEvent.SEARCH_EVENT, e -> {
            System.out.println(e.getQuery());
        });

        this.router.getRouterController().setScene(scene);
        this.router.getRouterController().show();
    }

    public static void main(String[] args) {

        launch(args);
    }
}
