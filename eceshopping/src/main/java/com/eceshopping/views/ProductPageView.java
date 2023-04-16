package com.eceshopping.views;

import com.eceshopping.views.layouts.UserLayoutView;

import javafx.geometry.HPos;
import javafx.geometry.Pos;
import javafx.geometry.VPos;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.ColumnConstraints;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.RowConstraints;

public class ProductPageView extends UserLayoutView implements View {
    private ImageView image;
    private Label name;
    private Label price;
    private Label priceBulk;
    private Label description;
    private Label stock;
    private Button addToCart;
    private TextField quantity;
    private GridPane gridPane;
    GridPane productDetails;

    public ProductPageView() {
        this.gridPane = new GridPane();
        this.productDetails = new GridPane();
        this.slot.getChildren().add(gridPane);
        this.image = new ImageView();
        this.name = new Label();
        this.price = new Label();
        this.description = new Label();
        this.quantity = new TextField();
        this.stock = new Label();
        this.priceBulk = new Label();
        this.setLayout();
    }

    public void setLayout() {
        this.gridPane.setAlignment(javafx.geometry.Pos.TOP_CENTER);
        this.gridPane.setPadding(new javafx.geometry.Insets(20.0, 20.0, 20.0, 20.0));
        this.gridPane.setHgap(20);
        this.gridPane.setVgap(20);
        productDetails.setHgap(20);
        productDetails.setVgap(20);
        this.addToCart = new Button("Add to cart"); 
        this.image.setFitHeight(300);
        this.image.setFitWidth(300);
        this.image.setPreserveRatio(true);
        ColumnConstraints column1 = new ColumnConstraints();
        column1.setPercentWidth(40);
        ColumnConstraints column2 = new ColumnConstraints();
        column2.setPercentWidth(40);
        RowConstraints row1 = new RowConstraints();
        row1.setPercentHeight(100);
        this.gridPane.getRowConstraints().addAll(row1);
        gridPane.getColumnConstraints().addAll(column1, column2);
        GridPane.setHalignment(this.image, HPos.CENTER);
        GridPane.setValignment(this.image, VPos.CENTER);
        GridPane.setHalignment(productDetails, HPos.CENTER);
        GridPane.setValignment(productDetails, VPos.CENTER);
        gridPane.add(productDetails, 1, 0);
        gridPane.prefHeightProperty().bind(this.slot.heightProperty());
        gridPane.prefWidthProperty().bind(this.slot.widthProperty());
        Label productType = new Label("Product Details");
        productDetails.add(productType, 0, 0);
        GridPane.setHalignment(productType, HPos.LEFT);
        Label name = new Label("Name:");
        productDetails.add(name, 0, 1);
        GridPane.setHalignment(name, HPos.LEFT);
        Label description = new Label("Description:");
        productDetails.add(description, 0, 2);
        GridPane.setHalignment(description, HPos.LEFT);
        Label price = new Label("Price (U):");
        productDetails.add(price, 0, 4);
        GridPane.setHalignment(price, HPos.LEFT);
        Label quantity = new Label("Stock:");
        productDetails.add(quantity, 0, 3);   
        Label priceBulk = new Label("Price (Bulk - 10):");
        productDetails.add(priceBulk, 0, 5);
        Label wantedQuantity = new Label("Wanted Quantity:");
        productDetails.add(wantedQuantity, 0, 6);
        GridPane.setHalignment(wantedQuantity, HPos.LEFT);
        productDetails.add(this.quantity, 1, 6);
        productDetails.add(this.addToCart, 1, 7);
        productDetails.setAlignment(Pos.CENTER_LEFT);
    }

    public void clearLayout() {
        this.gridPane.getChildren().clear();
        this.productDetails.getChildren().clear();
    }

    public void setImage(Image image) {
        this.gridPane.getChildren().remove(this.image);
        this.image.setImage(image);
        this.gridPane.add(this.image, 0, 0);
    }

    public void setName(String name) {
        this.productDetails.getChildren().remove(this.name);
        this.name.setText(name);
        productDetails.add(this.name, 1, 1);
    }

    public void setPrice(String price) {
        this.productDetails.getChildren().remove(this.price);
        this.price.setText(price);
        productDetails.add(this.price, 1, 4);
    }

    public void setPriceBulk(String price) {
        this.productDetails.getChildren().remove(this.priceBulk);
        this.priceBulk.setText(price);
        productDetails.add(this.priceBulk, 1, 5);
    }

    public void setDescription(String description) {
        this.productDetails.getChildren().remove(this.description);
        this.description.setText(description);
        productDetails.add(this.description, 1, 2);
    }

    public void setQuantity(String quantity) {
        this.productDetails.getChildren().remove(this.stock);
        this.stock.setText(quantity);
        productDetails.add(this.stock, 1, 3);
    }

    public Button getAddToCart() {
        return this.addToCart;
    }

    public TextField getQuantity() {
        return this.quantity;
    }

    @Override
    public Node getRootNode() {
        return this;
    }
}
