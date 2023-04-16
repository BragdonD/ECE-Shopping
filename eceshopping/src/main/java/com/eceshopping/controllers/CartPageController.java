package com.eceshopping.controllers;

import java.util.ArrayList;
import java.util.List;

import com.eceshopping.controllers.components.CartItemController;
import com.eceshopping.dto.ArticleDto;
import com.eceshopping.events.AddToBasketEvent;
import com.eceshopping.events.DeleteFromBasketEvent;
import com.eceshopping.events.PaymentEvent;
import com.eceshopping.utils.Router;
import com.eceshopping.views.CartPageView;
import com.eceshopping.views.PaymentPageView;
import com.eceshopping.views.components.CartItemView;

import javafx.scene.Scene;
import javafx.stage.Stage;

public class CartPageController implements Controller {
    private CartPageView view;
    private Double totalPrice;
    private List<CartItemController> cartItemsControllers;

    public CartPageController(CartPageView view) {
        this.view = view;
        new UserNavBarController(this.view.getNavBar());
        this.totalPrice = 0.0;
        this.cartItemsControllers = new ArrayList<CartItemController>();

        if(this.totalPrice == 0.0)
            this.deactivatePaymentButton();
        else
            this.activatePaymentButton();

        Router.getInstance().getRouterController().getMainStage().addEventHandler(AddToBasketEvent.ADD_TO_CART_EVENT,
                e -> {
                    ArticleDto article = e.getArticle();
                    Integer quantity = e.getQuantity();
                    if (quantity == 0)
                        return;

                    boolean ifExists = false;

                    CartItemController cartItemController = this.cartItemsControllers.stream()
                            .filter(c -> c.getArticle().getId() == article.getId())
                            .findFirst()
                            .orElse(null);

                    if (cartItemController != null) {
                        cartItemController.updateQuantity(cartItemController.getQuantity() + quantity);
                        ifExists = true;
                        this.totalPrice -= cartItemController.getArticle().getPrice() * (cartItemController.getQuantity() - quantity);
                    }

                    if (cartItemController == null || ifExists == false) {
                        CartItemView cartItemView = new CartItemView(article.getImage(), article.getName(),
                                article.getPrice(), quantity);
                        cartItemController = new CartItemController(cartItemView, article, quantity);
                        cartItemController.updateQuantity(quantity);
                        this.cartItemsControllers.add(cartItemController);
                        this.view.addProductToCart(cartItemView);
                    }

                    this.totalPrice += cartItemController.getPrice();
                    this.view.setTotalPrice(Double.toString(totalPrice));

                    if(this.totalPrice == 0.0)
                        this.deactivatePaymentButton();
                    else
                        this.activatePaymentButton();
                });

        Router.getInstance().getRouterController().getMainStage()
                .addEventHandler(DeleteFromBasketEvent.DELETE_FROM_CART_EVENT, e -> {
                    ArticleDto article = e.getArticle();
                    Integer quantity = e.getQuantity();
                    if (quantity == 0)
                        return;

                    CartItemController cartItemController = this.cartItemsControllers.stream()
                            .filter(c -> c.getArticle().getId() == article.getId())
                            .findFirst()
                            .orElse(null);

                    if (cartItemController == null)
                        return;

                    if (e.isDeleteAll() == true) {
                        if (quantity == 1) {
                            System.out.println("quantity: " + cartItemController.getQuantity());
                            if(cartItemController.getQuantity() == 9)
                                this.totalPrice -= cartItemController.getArticle().getBulkprice();
                            else
                                this.totalPrice -= cartItemController.getArticle().getPrice();
                        } else
                            this.totalPrice -= cartItemController.getPrice();
                        this.cartItemsControllers.remove(cartItemController);
                        this.view.removeProductFromCart(cartItemController.getView());
                    } else {
                        if((cartItemController.getQuantity() + 1) % 10 == 0) {
                            this.totalPrice -= cartItemController.getArticle().getBulkprice() * (cartItemController.getQuantity() + 1);
                            this.totalPrice += cartItemController.getArticle().getPrice() * cartItemController.getQuantity();
                        }
                        else
                            this.totalPrice -= cartItemController.getArticle().getPrice() * quantity;
                    }

                    if(this.totalPrice == 0.0)
                        this.deactivatePaymentButton();
                    else
                        this.activatePaymentButton();

                    this.view.setTotalPrice(Double.toString(totalPrice));
                });

        listenToPaymentButton();
    }

    private void activatePaymentButton() {
        this.view.getPaymentButton().setDisable(false);
    }

    private void deactivatePaymentButton() {
        this.view.getPaymentButton().setDisable(true);
    }

    private void listenToPaymentButton() {
        this.view.getPaymentButton().setOnAction(e -> {
            Stage paymentStage = new Stage();
            paymentStage.setTitle("Payment");
            paymentStage.setResizable(false);
            paymentStage.setWidth(600);
            paymentStage.setHeight(400);
            paymentStage.show();
            PaymentPageView paymentPageView = new PaymentPageView();
            new PaymentPageController(paymentPageView);
            paymentStage.setScene(new Scene(paymentPageView));
            Router.getInstance().getRouterController().getMainStage().addEventHandler(PaymentEvent.PAYMENT_EVENT, e1 -> {
                this.cartItemsControllers.clear();
                this.view.clearCart();
                this.totalPrice = 0.0;
                this.view.setTotalPrice(Double.toString(totalPrice));
                this.deactivatePaymentButton();
                paymentStage.close();
            });
        });
    }

    /**
     * @param s
     */
    @Override
    public void bindScene(Scene s) {
        this.view.bindScene(s);
    }
}