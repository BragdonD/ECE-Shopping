package com.eceshopping.controllers;

import com.eceshopping.dto.PurchaseDto;
import com.eceshopping.dto.PurchasedItemDto;
import com.eceshopping.views.components.PurchaseOverView;

import javafx.scene.Scene;

public class PurchaseOviewController implements Controller {

    PurchaseDto purchase;
    PurchasedItemDto purchasedItem;
    private PurchaseOverView view;

    public PurchaseOviewController(PurchaseOverView view, PurchaseDto purchase, PurchasedItemDto purchasedItem)
            throws IllegalArgumentException {
        this.view = view;
        this.purchase = purchase;
        this.purchasedItem = purchasedItem;
    }

    @Override
    public void bindScene(Scene scene) {

    }
}