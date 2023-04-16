package com.eceshopping.views.components;

import com.eceshopping.views.ProductOView;
import com.eceshopping.views.View;

import javafx.scene.Node;
import javafx.scene.control.Hyperlink;
import javafx.scene.control.Label;
import javafx.scene.layout.GridPane;

public class ManageInvView extends GridPane implements View {

    private Hyperlink addArticleButton;
    private int row = 1;
    private GridPane productsLayout;
    private Label name;

    public ManageInvView() {
        super();
        productsLayout = new GridPane();
        this.addArticleButton = new Hyperlink("Add Article");
        this.name = new Label();

        this.add(this.addArticleButton, 0, 0);
        this.productsLayout.setAlignment(javafx.geometry.Pos.TOP_CENTER);
        this.productsLayout.setPadding(new javafx.geometry.Insets(20.0, 20.0, 20.0, 20.0));
        this.productsLayout.setHgap(20);
        this.productsLayout.setVgap(20);
        this.add(productsLayout, row, row);
        this.row++;
    }

    
    /** 
     * @param name
     */
    public void setName(String name) {
        this.productsLayout.getChildren().remove(this.name);
        this.name.setText(name);
    }

    
    /** 
     * @return Hyperlink
     */
    public Hyperlink getAddArticleButton() {
        return this.addArticleButton;
    }

    public void addProduct(ProductOView product) {
        int col = row % 1; // calculate the column index
        int rowIdx = row / 1; // calculate the row index

        this.productsLayout.add(product, col, rowIdx);
        this.row++;
    }

    public GridPane getProductsLayout() {
        return this.productsLayout;
    }

    public void clearProducts() {
        this.productsLayout.getChildren().clear();
        this.row = 0;
    }

    public void removeProduct(ProductOView product) {
        this.productsLayout.getChildren().remove(product);
    }

    @Override
    public Node getRootNode() {
        return this;
    }

}