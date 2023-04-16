package com.eceshopping.views.components;

import java.time.LocalDate;

import javafx.scene.control.Label;
import javafx.scene.layout.GridPane;

public class PurchaseOverView extends GridPane {

    private Integer purchaseId;
    private LocalDate date;
    private Integer productId;
    private Label purchaseIdLabel;
    private Label dateLabel;
    private Label productIdLabel;
    private Label purchaseIdTitleLabel;
    private Label dateTitleLabel;
    private Label productIdTitleLabel;

    public PurchaseOverView(Integer purchaseId, LocalDate date, Integer productId) {
        super();
        this.purchaseIdTitleLabel = new Label("Purchase ID:");
        this.purchaseIdLabel = new Label(purchaseId.toString());
        this.add(this.purchaseIdTitleLabel, 0, 0);
        this.add(this.purchaseIdLabel, 0, 2);

        this.dateTitleLabel = new Label("Date:");
        this.dateLabel = new Label(date.toString());
        this.add(this.dateTitleLabel, 1, 0);
        this.add(this.dateLabel, 1, 2);

        this.productIdTitleLabel = new Label("Product ID:");
        this.productIdLabel = new Label(productId.toString());
        this.add(this.productIdLabel, 2, 2);
        this.add(this.productIdTitleLabel, 2, 0);

        this.setHgap(20);

        this.purchaseId = purchaseId;
        this.date = date;
        this.productId = productId;
    }

    public Integer getPurchaseId() {
        return purchaseId;
    }

    public void setPurchaseId(Integer purchaseId) {
        this.purchaseId = purchaseId;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public Integer getProductId() {
        return productId;
    }

    public void setProductId(Integer productId) {
        this.productId = productId;
    }

}
