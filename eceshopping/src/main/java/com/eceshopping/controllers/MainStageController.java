package com.eceshopping.controllers;

import com.eceshopping.dto.BasketItemDto;
import com.eceshopping.events.AddToBasketEvent;
import com.eceshopping.events.DeleteFromBasketEvent;
import com.eceshopping.utils.Session;

import javafx.stage.Stage;

/**
 * This class is used to handle the main stage
 */
public class MainStageController {
    private Stage stage;

    public MainStageController(Stage s) {
        this.stage = s;

        this.stage.addEventHandler(AddToBasketEvent.ADD_TO_CART_EVENT, e -> {
            if (Session.getInstance() != null) {
                BasketItemDto item = new BasketItemDto()
                        .product(e.getArticle())
                        .quantity(e.getQuantity());
                Session.getInstance().addItemToCart(item);
            }
        });

        this.stage.addEventHandler(DeleteFromBasketEvent.DELETE_FROM_CART_EVENT, e -> {
            if (Session.getInstance() != null) {
                for (BasketItemDto item : Session.getInstance().getItems()) {
                    if (item.getProduct().getId() == e.getArticle().getId()) {
                        if (e.isDeleteAll()) {
                            Session.getInstance().removeItemFromCart(item);
                        } else {
                            item.setQuantity(item.getQuantity() - e.getQuantity());
                        }
                        break;
                    }
                }
            }
        });

        this.stage.setOnCloseRequest(e -> {
            System.out.println("Closing the application");
            if (Session.getInstance() != null) {
                Session.getInstance().clear();
            }
        });
    }
}
