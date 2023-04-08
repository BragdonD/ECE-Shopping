package com.eceshopping.views;

import com.eceshopping.factories.components.NavBarFactory;
import com.eceshopping.views.components.UserNavBarView;

import javafx.geometry.HPos;
import javafx.geometry.VPos;
import javafx.scene.Scene;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Priority;
import javafx.scene.layout.RowConstraints;
import javafx.scene.layout.StackPane;

public class UserLayoutView extends GridPane {

    private UserNavBarView navBar;
    protected StackPane slot;

    public UserLayoutView() {
        this.navBar = NavBarFactory.createUserNavBarView();
        this.add(navBar, 0, 0);
        this.slot = new StackPane();
        this.add(slot, 0, 1);
        RowConstraints row1 = new RowConstraints();
        row1.setVgrow(Priority.NEVER);
        this.getRowConstraints().add(row1);

        RowConstraints row2 = new RowConstraints();
        row2.setVgrow(Priority.ALWAYS);
        this.getRowConstraints().add(row2);
        this.setStyle("-fx-background-color: red;");
    }

    public void bindScene(Scene scene) {
        this.prefWidthProperty().bind(scene.widthProperty());
        this.prefHeightProperty().bind(scene.heightProperty());
        this.navBar.bindScene(scene);
    }
}
