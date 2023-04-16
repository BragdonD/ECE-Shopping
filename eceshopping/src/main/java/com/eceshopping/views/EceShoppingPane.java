package com.eceshopping.views;

import javafx.geometry.Insets;
import javafx.scene.control.ScrollBar;
import javafx.scene.control.SplitPane;
import javafx.scene.control.TitledPane;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.layout.StackPane;

public class EceShoppingPane extends TitledPane {

    public EceShoppingPane() {
        super("ECE-Shopping", null);
        setPrefSize(765, 532);

        SplitPane splitPane = new SplitPane();
        splitPane.setDividerPositions(0.29797979797979796);
        splitPane.setPrefSize(200, 160);

        AnchorPane anchorPane1 = new AnchorPane();
        anchorPane1.setPrefSize(100, 160);
        splitPane.getItems().add(anchorPane1);

        AnchorPane anchorPane2 = new AnchorPane();
        anchorPane2.setPrefSize(100, 160);

        StackPane stackPane1 = new StackPane();
        stackPane1.setPrefSize(522, 151);
        stackPane1.setLayoutX(11);
        stackPane1.setLayoutY(55);

        HBox hbox1 = new HBox();
        hbox1.setPrefSize(550, 150);

        Pane pane1 = new Pane();
        pane1.setPrefSize(200, 200);
        pane1.setStyle("-fx-background-color: green;");
        pane1.setPadding(new Insets(0, 0, 15, 0));

        Pane pane2 = new Pane();
        pane2.setPrefSize(200, 200);
        pane2.setStyle("-fx-background-color: bl;");
        pane2.setPadding(new Insets(0, 15, 15, 15));

        Pane pane3 = new Pane();
        pane3.setPrefSize(200, 200);
        pane3.setStyle("-fx-background-color: red;");
        pane3.setPadding(new Insets(0, 15, 15, 15));
        pane3.setOpaqueInsets(new Insets(0));

        Pane pane4 = new Pane();
        pane4.setPrefSize(189, 136);
        pane4.setStyle("-fx-background-color: yellow;");
        pane4.setPadding(new Insets(0, 15, 15, 15));

        Pane pane5 = new Pane();
        pane5.setPrefSize(137, 200);
        pane5.setStyle("-fx-background-color: blue;");
        pane5.setPadding(new Insets(0, 15, 15, 15));

        hbox1.getChildren().addAll(pane1, pane2, pane3, pane4, pane5);
        stackPane1.getChildren().addAll(new ScrollBar(), hbox1);

        StackPane stackPane2 = new StackPane();
        stackPane2.setPrefSize(522, 151);
        stackPane2.setLayoutX(10);
        stackPane2.setLayoutY(277);

        HBox hbox2 = new HBox();
        hbox2.setPrefSize(550, 150);

        Pane pane6 = new Pane();
        pane6.setPrefSize(200, 200);
        pane6.setStyle("-fx-background-color: green;");
        pane6.setPadding(new Insets(0, 0, 15, 0));

        Pane pane7 = new Pane();
        pane7.setPrefSize(200, 200);
        pane7.setStyle("-fx-background-color: red;");
        pane7.setPadding(new Insets(0, 15, 0, 0));
    }
}
