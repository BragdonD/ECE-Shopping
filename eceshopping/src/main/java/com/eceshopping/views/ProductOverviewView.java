package com.example;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class MyApplication extends Application {
    
    @Override
    public void start(Stage stage) {
        AnchorPane root = new AnchorPane();
        root.setPrefSize(521, 382);
        
        Rectangle rectangle = new Rectangle(252, 307);
        rectangle.setLayoutX(39);
        rectangle.setLayoutY(38);
        rectangle.setArcWidth(5);
        rectangle.setArcHeight(5);
        rectangle.setFill(Color.web("#ff621f"));
        rectangle.setStroke(Color.BLACK);
        rectangle.setStrokeType(javafx.scene.shape.StrokeType.INSIDE);
        
        Text text1 = new Text("Sac 1");
        text1.setFont(Font.font("Geneva", 13));
        text1.setLayoutX(146);
        text1.setLayoutY(289);
        text1.setWrappingWidth(36.4619140625);
        text1.setStrokeWidth(0);
        text1.setUnderline(true);
        
        Text text2 = new Text("39,99€");
        text2.setFont(Font.font("Geneva", 13));
        text2.setLayoutX(142);
        text2.setLayoutY(315);
        text2.setStrokeWidth(0);
        
        ImageView imageView = new ImageView(new Image("Image/és.png"));
        imageView.setLayoutX(64);
        imageView.setLayoutY(78);
        imageView.setFitWidth(202);
        imageView.setFitHeight(202);
        imageView.setPreserveRatio(true);
        imageView.setPickOnBounds(true);
        
        Text text3 = new Text("4,5");
        text3.setFont(Font.font("Geneva", 13));
        text3.setLayoutX(252);
        text3.setLayoutY(333);
        text3.setStrokeWidth(0);
        
        ImageView imageView2 = new ImageView(new Image("Image/Etoile.png"));
        imageView2.setLayoutX(226);
        imageView2.setLayoutY(319);
        imageView2.setFitWidth(20);
        imageView2.setFitHeight(27);
        imageView2.setPreserveRatio(true);
        imageView2.setPickOnBounds(true);
        
        root.getChildren().addAll(rectangle, text1, text2, imageView, text3, imageView2);
        
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }
    
    public static void main(String[] args) {
        launch(args);
    }
}
