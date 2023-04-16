package com.eceshopping.controllers;

import java.util.List;

import com.eceshopping.controllers.components.CommandItemController;
import com.eceshopping.dto.PurchaseDto;
import com.eceshopping.services.PurchaseService;
import com.eceshopping.views.MyCommandsPageView;
import com.eceshopping.views.components.CommandItemView;

import javafx.concurrent.Task;
import javafx.scene.Scene;

public class MyCommandPageController implements Controller {
    private MyCommandsPageView view;
    private List<PurchaseDto> purchases;
    private PurchaseService purchaseService;

    public MyCommandPageController(MyCommandsPageView view) {
        this.view = view;
        this.purchaseService = new PurchaseService();
        new UserNavBarController(this.view.getNavBar());
        loadPurchases();
    }

    private void loadPurchases() {
        Task<List<PurchaseDto>> getAllPurchaseTask = this.purchaseService.getAllPurchases();
        getAllPurchaseTask.setOnSucceeded(e -> {
            this.purchases = getAllPurchaseTask.getValue();
            this.purchases.forEach(purchase -> {
                CommandItemView commandItemView = new CommandItemView();
                new CommandItemController(commandItemView, purchase);
                this.view.addCommand(commandItemView);
            });
        });
        new Thread(getAllPurchaseTask).start();
    }

    @Override
    public void bindScene(Scene scene) {
        this.view.bindScene(scene);
    }
}
