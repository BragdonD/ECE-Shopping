package com.eceshopping.views.components;

import com.eceshopping.views.View;

import javafx.scene.Node;
import javafx.scene.control.Hyperlink;
import javafx.scene.control.Label;
import javafx.scene.control.ScrollPane;
import javafx.scene.layout.GridPane;

public class ManageInvView extends ScrollPane implements View {

    private Hyperlink addArticleButton;
    private Hyperlink backLink;
    private int row = 1;
    private GridPane productsLayout;
    private Label name;
    private GridPane gridPane;

    public ManageInvView() {
        super();
        this.gridPane = new GridPane();
        productsLayout = new GridPane();
        this.addArticleButton = new Hyperlink("Add Article");
        this.backLink = new Hyperlink("Retour");
        this.name = new Label();

        this.gridPane.add(this.backLink, 0, 9, 1, 1);
        this.gridPane.add(this.addArticleButton, 0, 0);
        this.productsLayout.setAlignment(javafx.geometry.Pos.TOP_CENTER);
        this.productsLayout.setPadding(new javafx.geometry.Insets(20.0, 20.0, 20.0, 20.0));
        this.productsLayout.setHgap(20);
        this.productsLayout.setVgap(20);
        this.gridPane.add(productsLayout, row, row);
        this.row++;
        this.setContent(this.gridPane);
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

    /**
     * ADD PRODUCT TO THE GRID LAYOUT
     * 
     * @param product
     */
    public void addProduct(ProductOView product) {
        int col = row % 1; // calculate the column index
        int rowIdx = row / 1; // calculate the row index

        this.productsLayout.add(product, col, rowIdx);
        this.row++;
    }

    /**
     * GET THE GRID LAYOUT
     * 
     * @return
     */
    public GridPane getProductsLayout() {
        return this.productsLayout;
    }

    /**
     * CLEAR THE GRID LAYOUT
     * 
     */
    public void clearProducts() {
        this.productsLayout.getChildren().clear();
        this.row = 0;
    }

    /**
     * REMOVE A PRODUCT FROM THE GRID LAYOUT
     * 
     * @param product
     */
    public void removeProduct(ProductOView product) {
        this.productsLayout.getChildren().remove(product);
    }

    /**
     * Get backLink
     * 
     * @return
     */
    public Hyperlink getBackLink() {
        return backLink;
    }

    /**
     * Set backLink
     * 
     * @param backLink
     */
    public void setBackLink(Hyperlink backLink) {
        this.backLink = backLink;
    }

    @Override
    public Node getRootNode() {
        return this;
    }
}