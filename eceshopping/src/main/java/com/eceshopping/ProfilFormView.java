package com.eceshopping;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Border;
import javafx.scene.layout.BorderStroke;
import javafx.scene.layout.BorderStrokeStyle;
import javafx.scene.layout.BorderWidths;
import javafx.scene.layout.CornerRadii;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class ProfilFormView extends Application {

  
  @Override
  public void start(Stage stage) {
    HBox contentContainer = new HBox(50d, createNormalButton());
    contentContainer.setAlignment(Pos.CENTER);
    Scene scene = new Scene(contentContainer, 500, 500);
    stage.setTitle("JavaFX Button Tutorial");
    stage.setScene(scene);
    stage.show();
  }

  private StackPane createNormalButton() {
    StackPane button = new StackPane();
    GridPane layout = new GridPane();
    GridPane column1 = new GridPane();
    GridPane column2 = new GridPane();
    final Image image = new Image(this.getClass().getResource("/images/Box.png").toExternalForm());
    final ImageView icon = new ImageView(image);
    icon.setFitHeight(80);
    icon.setFitWidth(80);
    final HBox box = new HBox();
    box.getChildren().add(icon);
    final Text title = new Text("My Orders");
    final Text description = new Text("View your orders");   
    column1.add(icon, 0, 0);
    column2.add(title, 0, 0);
    column2.add(description, 0, 1);

    column2.setVgap(10);

    layout.add(column1, 0, 0);
    layout.add(column2, 1, 0);
    layout.setHgap(10);

    layout.setBorder(new Border(new BorderStroke(Color.GREY,
        BorderStrokeStyle.SOLID, CornerRadii.EMPTY, BorderWidths.DEFAULT)));

    layout.setOnMouseEntered(e -> {
      layout.setStyle("-fx-background-color: #f5f5f5;");
    });

    layout.setOnMouseExited(e -> {
      layout.setStyle("-fx-background-color: #ffffff;");
    });

    button.getChildren().add(layout);

    button.setMaxHeight(100);
    StackPane.setMargin(layout, new Insets(10));

    return button;
  }

  public static void main(String[] args) {
    launch(args);
  }
}