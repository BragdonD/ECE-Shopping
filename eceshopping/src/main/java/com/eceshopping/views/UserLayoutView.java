package com.eceshopping.views;

import com.eceshopping.factories.components.NavBarFactory;
import com.eceshopping.views.components.UserNavBarView;

import javafx.scene.Scene;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.StackPane;

/*
 * UserLayoutView class is a utility class for creating a layout for the user.
 * It will display the navigation bar.
 *  It will also handle the layout of the layout.
 */
public class UserLayoutView extends GridPane {

    UserNavBarView navBar;
    StackPane slot;

    /*
     * This method will initialize the layout of the layout.
     * It will also initialize the navigation bar.
     *  It will also initialize the slot.
     */
    public UserLayoutView() {
        this.navBar = NavBarFactory.createUserNavBarView();
        this.add(navBar, 0, 0);
        this.slot = new StackPane(navBar);
        this.add(slot, 0, 1);
        this.setStyle("-fx-background-color: red;");
    }
    
    /*
     * This method will bind the layout to the scene.
     * It will also bind the navigation bar to the scene.
     */
    public void bindScene(Scene scene) {
        this.prefWidthProperty().bind(scene.widthProperty());
        this.prefHeightProperty().bind(scene.heightProperty());
        this.navBar.bindScene(scene);
    }
}
