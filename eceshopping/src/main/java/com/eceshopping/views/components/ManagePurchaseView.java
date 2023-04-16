package com.eceshopping.views.components;

import com.eceshopping.views.View;

import javafx.scene.control.Hyperlink;
import javafx.scene.layout.GridPane;

public class ManagePurchaseView extends GridPane implements View {

    GridPane purchasesLayout;
    int row = 1;
    private Hyperlink backLink;

    public ManagePurchaseView() {
        super();
        purchasesLayout = new GridPane();
        this.purchasesLayout.setAlignment(javafx.geometry.Pos.TOP_CENTER);
        this.purchasesLayout.setPadding(new javafx.geometry.Insets(20.0, 20.0, 20.0, 20.0));
        this.purchasesLayout.setHgap(20);
        this.purchasesLayout.setVgap(20);
        this.add(purchasesLayout, row, row);
        this.backLink = new Hyperlink("Retour");
        this.add(backLink, 0, 9, 1, 1);
    }

    public void addPurchase(PurchaseOverView purchase) {
        int col = row % 1; // calculate the column index
        int rowIdx = row / 1; // calculate the row index

        this.purchasesLayout.add(purchase, col, rowIdx);

        row++;
    }

    public Hyperlink getBackLink() {
        return backLink;
    }

    public void setBackLink(Hyperlink backLink) {
        this.backLink = backLink;
    }

    @Override
    public javafx.scene.Node getRootNode() {
        // TODO Auto-generated method stub
        return this;
    }

}
