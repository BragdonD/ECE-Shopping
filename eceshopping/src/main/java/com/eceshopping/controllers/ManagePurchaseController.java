package com.eceshopping.controllers;

import java.util.List;

import com.eceshopping.dto.PurchaseDto;
import com.eceshopping.dto.PurchasedItemDto;
import com.eceshopping.services.PurchaseService;
import com.eceshopping.services.PurchasedItemService;
import com.eceshopping.utils.Router;
import com.eceshopping.views.components.ManagePurchaseView;
import com.eceshopping.views.components.PurchaseOverView;

import javafx.concurrent.Task;

public class ManagePurchaseController implements Controller {

    private ManagePurchaseView view;
    PurchaseService purchaseService;
    PurchasedItemService purchasedItemService;
    private List<PurchaseDto> purchases;
    private List<PurchasedItemDto> purchasedItems;

    public ManagePurchaseController(ManagePurchaseView view) throws IllegalArgumentException {
        this.view = view;
        this.purchaseService = new PurchaseService();
        this.purchasedItemService = new PurchasedItemService();
        LoadPurchases();
        setupHyperlink();

    }

    private void LoadPurchases() {
        Task<List<PurchaseDto>> getAllPurchaseTask = this.purchaseService.getAllPurchases();
        getAllPurchaseTask.setOnSucceeded(e -> {
            this.purchases = getAllPurchaseTask.getValue();
            displayPurchases();
            // this.view.loadPurchases(Purchases);

        });
        getAllPurchaseTask.setOnFailed(e -> {
            System.out.println(e.getSource().getException().getMessage());
        });

        new Thread(getAllPurchaseTask).start();
    }

    private void displayPurchases() {
        if (this.purchases == null) {
            return;
        }
        for (PurchaseDto purchase : this.purchases) {
            purchasedItems = purchase.getPurchasedItems();
            for (PurchasedItemDto purchasedItem : purchasedItems) {
                PurchaseOverView purch = new PurchaseOverView(purchase.getId(), purchase.getDate(),
                        purchasedItem.getId());
                new PurchaseOviewController(purch, purchase, purchasedItem);
                this.view.addPurchase(purch);
            }
        }
    }
/**
 * Setup the hyperlink to go back to the admin menu
 */
    public void setupHyperlink() {
        this.view.getBackLink().setOnAction(e -> {
            Router.getInstance().navigateTo("/adminMenu");
        });
    }
/**
 * @param scene
 */
    @Override
    public void bindScene(javafx.scene.Scene scene) {
    }
}
