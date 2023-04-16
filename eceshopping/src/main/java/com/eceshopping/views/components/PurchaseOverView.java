package com.eceshopping.views.components;

import java.time.LocalDate;

import com.eceshopping.dto.UserDto;

import javafx.scene.control.Label;
import javafx.scene.layout.GridPane;

public class PurchaseOverView extends GridPane {

    private Integer purchaseId;
    private LocalDate date;
    private Integer productId;
    private Label purchaseIdLabel;
    private Label dateLabel;
    private Label productIdLabel;

    public PurchaseOverView(Integer purchaseId, LocalDate date, Integer productId) {
        super();
        this.purchaseIdLabel = new Label(purchaseId.toString());
        this.add(this.purchaseIdLabel, 0, 2);

       this.dateLabel = new Label(date.toString());
        this.add(this.dateLabel, 1, 2);
        this.productIdLabel = new Label(productId.toString());
        this.add(this.productIdLabel, 2, 2);
        
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
