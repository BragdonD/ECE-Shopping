package com.eceshopping.views;

import com.eceshopping.factories.components.NavBarFactory;
import com.eceshopping.views.components.UserNavBarView;

import javafx.beans.binding.Binding;
import javafx.beans.binding.Bindings;
import javafx.beans.binding.BooleanBinding;
import javafx.geometry.NodeOrientation;
import javafx.geometry.Orientation;
import javafx.scene.Scene;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.StackPane;

public class UserLayoutView extends GridPane {

    UserNavBarView navBar;
    StackPane slot;

    public UserLayoutView() {
        this.navBar = NavBarFactory.createUserNavBarView();
        this.add(navBar, 0, 0);
        this.slot = new StackPane(navBar);
        this.add(slot, 0, 1);
        this.setStyle("-fx-background-color: red;");
    }

    public void bindScene(Scene scene) {
        this.prefWidthProperty().bind(scene.widthProperty());
        this.prefHeightProperty().bind(scene.heightProperty());
        this.navBar.bindScene(scene);
    }
}
