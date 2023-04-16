package com.eceshopping.controllers;

import java.util.ArrayList;
import java.util.List;

import com.eceshopping.controllers.components.CartItemController;
import com.eceshopping.dto.ArticleDto;
import com.eceshopping.events.AddToBasketEvent;
import com.eceshopping.events.DeleteFromBasketEvent;
import com.eceshopping.utils.Router;
import com.eceshopping.views.CartPageView;
import com.eceshopping.views.components.CartItemView;

import javafx.scene.Scene;

public class CartPageController implements Controller {
    private CartPageView view;
    private UserNavBarController navBarController;
    private Double totalPrice;
    private List<CartItemController> cartItemsControllers;

    public CartPageController(CartPageView view) {
        this.view = view;
        this.navBarController = new UserNavBarController(this.view.getNavBar());
        this.totalPrice = 0.0;
        this.cartItemsControllers = new ArrayList<CartItemController>();

        Router.getInstance().getRouterController().getMainStage().addEventHandler(AddToBasketEvent.ADD_TO_CART_EVENT, e -> {
            ArticleDto article = e.getArticle();
            Integer quantity = e.getQuantity();
            if(quantity == 0) return;

            boolean ifExists = false;

            CartItemController cartItemController = this.cartItemsControllers.stream()
                .filter(c -> c.getArticle().getId() == article.getId())
                .findFirst()
                .orElse(null);

            if(cartItemController != null) {
                cartItemController.updateQuantity(cartItemController.getQuantity() + quantity);
                ifExists = true;
                this.totalPrice -= cartItemController.getPrice();
            }

            if(cartItemController == null || ifExists == false) {
                CartItemView cartItemView = new CartItemView(article.getImage(), article.getName(), article.getPrice(), quantity);
                cartItemController = new CartItemController(cartItemView, article, quantity);
                cartItemController.updateQuantity(quantity);
                this.cartItemsControllers.add(cartItemController);
                this.view.addProductToCart(cartItemView);
            }
            
            this.totalPrice += cartItemController.getPrice();
            this.view.setTotalPrice(Double.toString(totalPrice));
        });

        Router.getInstance().getRouterController().getMainStage().addEventHandler(DeleteFromBasketEvent.DELETE_FROM_CART_EVENT, e -> {
            ArticleDto article = e.getArticle();
            Integer quantity = e.getQuantity();
            if(quantity == 0) return;

            CartItemController cartItemController = this.cartItemsControllers.stream()
                .filter(c -> c.getArticle().getId() == article.getId())
                .findFirst()
                .orElse(null);

            if(cartItemController == null) return;

            if(e.isDeleteAll() == true) {
                if(quantity == 1)
                    this.totalPrice -= cartItemController.getArticle().getPrice() * quantity;
                else 
                    this.totalPrice -= cartItemController.getPrice();
                this.cartItemsControllers.remove(cartItemController);
                this.view.removeProductFromCart(cartItemController.getView());
            } else {
                this.totalPrice -= cartItemController.getArticle().getPrice() * quantity;
            }
            
            this.view.setTotalPrice(Double.toString(totalPrice));
        });
    }

    @Override
    public void bindScene(Scene s) {
        this.view.bindScene(s);
    }
}
