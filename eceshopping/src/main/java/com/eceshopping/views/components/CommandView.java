package com.eceshopping.views.components;

import com.eceshopping.dto.PurchaseDto;
import com.eceshopping.dto.PurchasedItemDto;
import javafx.geometry.Insets;
import javafx.scene.control.Label;
import javafx.scene.layout.GridPane;

public class CommandView extends GridPane {

    private Label purchaseIdLabel;
    private Label purchaseDateLabel;
    private Label purchaseUserLabel;
    private Label purchaseAmountPayedLabel;
    private Label purchasedItemsLabel;

    private Label purchasedItemIdLabel;
    private Label purchasedItemArticleLabel;
    private Label purchasedItemQuantityLabel;

    public CommandView(PurchaseDto purchaseDto) {
        this.purchaseIdLabel = new Label("Purchase ID: " + purchaseDto.getId());
        this.purchaseDateLabel = new Label("Purchase Date: " + purchaseDto.getDate().toString());
        this.purchaseUserLabel = new Label("Purchase User: " + purchaseDto.getUser().getEmail());
        this.purchaseAmountPayedLabel = new Label("Amount Payed: " + purchaseDto.getAmountPayed());
        this.purchasedItemsLabel = new Label("Purchased Items:");
        this.purchasedItemIdLabel = new Label();
        this.purchasedItemArticleLabel = new Label();
        this.purchasedItemQuantityLabel = new Label();

        this.setPadding(new Insets(10));
        this.setHgap(10);
        this.setVgap(10);

        this.add(purchaseIdLabel, 0, 0);
        this.add(purchaseDateLabel, 0, 1);
        this.add(purchaseUserLabel, 0, 2);
        this.add(purchaseAmountPayedLabel, 0, 3);
        this.add(purchasedItemsLabel, 0, 4);

        int rowIndex = 5;
        for (PurchasedItemDto purchasedItemDto : purchaseDto.getPurchasedItems()) {
            this.purchasedItemIdLabel.setText("Item ID: " + purchasedItemDto.getId());
            this.purchasedItemArticleLabel.setText("Article: " + purchasedItemDto.getArticle().getName());
            this.purchasedItemQuantityLabel.setText("Quantity: " + purchasedItemDto.getQuantity().toString());

            this.add(purchasedItemIdLabel, 0, rowIndex);
            this.add(purchasedItemArticleLabel, 0, rowIndex + 1);
            this.add(purchasedItemQuantityLabel, 0, rowIndex + 2);

            rowIndex += 3;
        }
    }
}
