package com.eceshopping.controllers.components;

import com.eceshopping.dto.PurchaseDto;
import com.eceshopping.views.components.CommandItemView;
import com.eceshopping.views.components.CommandView;

import javafx.scene.Scene;
import javafx.stage.Stage;

public class CommandItemController {
    private CommandItemView view;
    private PurchaseDto purchaseDto;

    public CommandItemController(CommandItemView view, PurchaseDto purchaseDto) {
        this.view = view;
        this.view.getDate().setText(purchaseDto.getDate().toString());
        this.view.getPrice().setText(purchaseDto.getAmountPayed().toString());
        this.purchaseDto = purchaseDto;
        listenToEvent();
    }

    private void listenToEvent() {
        this.view.getDisplay().setOnAction(e -> {
            Stage stage = new Stage();
            stage.setTitle("Command");
            CommandView commandView = new CommandView(purchaseDto);
            stage.setScene(new Scene(commandView, 500, 500));
            stage.show();
        });
    }
}
