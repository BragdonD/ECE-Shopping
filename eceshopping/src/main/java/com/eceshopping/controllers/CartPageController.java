package com.eceshopping.controllers;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import com.eceshopping.controllers.components.CartItemController;
import com.eceshopping.dto.ArticleDto;
import com.eceshopping.dto.PurchaseDto;
import com.eceshopping.dto.PurchasedItemDto;
import com.eceshopping.events.AddToBasketEvent;
import com.eceshopping.events.DeleteFromBasketEvent;
import com.eceshopping.events.PaymentEvent;
import com.eceshopping.services.ArticleService;
import com.eceshopping.services.PurchaseService;
import com.eceshopping.utils.Router;
import com.eceshopping.utils.Session;
import com.eceshopping.views.CartPageView;
import com.eceshopping.views.PaymentPageView;
import com.eceshopping.views.components.CartItemView;

import javafx.concurrent.Task;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class CartPageController implements Controller {
    private CartPageView view;
    private Double totalPrice;
    private List<CartItemController> cartItemsControllers;
    private PurchaseService purchaseService;

    public CartPageController(CartPageView view) {
        this.view = view;
        this.purchaseService = new PurchaseService();
        new UserNavBarController(this.view.getNavBar());
        this.totalPrice = 0.0;
        this.cartItemsControllers = new ArrayList<CartItemController>();

        if (this.totalPrice == 0.0)
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
                        this.totalPrice -= cartItemController.getArticle().getPrice()
                                * (cartItemController.getQuantity() - quantity);
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

                    if (this.totalPrice == 0.0)
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
                            if (cartItemController.getQuantity() == 9)
                                this.totalPrice -= cartItemController.getArticle().getBulkprice();
                            else
                                this.totalPrice -= cartItemController.getArticle().getPrice();
                        } else
                            this.totalPrice -= cartItemController.getPrice();
                        this.cartItemsControllers.remove(cartItemController);
                        this.view.removeProductFromCart(cartItemController.getView());
                    } else {
                        if ((cartItemController.getQuantity() + 1) % 10 == 0) {
                            this.totalPrice -= cartItemController.getArticle().getBulkprice()
                                    * (cartItemController.getQuantity() + 1);
                            this.totalPrice += cartItemController.getArticle().getPrice()
                                    * cartItemController.getQuantity();
                        } else
                            this.totalPrice -= cartItemController.getArticle().getPrice() * quantity;
                    }

                    if (this.totalPrice == 0.0)
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
            Router.getInstance().getRouterController().getMainStage().addEventHandler(PaymentEvent.PAYMENT_EVENT,
                    e1 -> {
                        savePurchase();
                        this.totalPrice = 0.0;
                        this.view.setTotalPrice(Double.toString(totalPrice));
                        this.deactivatePaymentButton();
                        paymentStage.close();
                        this.cartItemsControllers.clear();
                        this.view.clearCart();
                    });
        });
    }

    private void savePurchase() {
        PurchaseDto purchase = new PurchaseDto(-1, LocalDate.now(), Session.getInstance().getUser(), this.totalPrice);
        for (CartItemController cartItemController : this.cartItemsControllers) {
            PurchasedItemDto purchasedItem = new PurchasedItemDto(-1, cartItemController.getArticle(), purchase,
                    cartItemController.getQuantity());
            purchase.addPurchasedItem(purchasedItem);
        }
        Task<PurchaseDto> savePurchasetask = this.purchaseService.savePurchaseAsync(purchase);
        savePurchasetask.setOnSucceeded(e -> {
            PurchaseDto savePurchase = savePurchasetask.getValue();
            System.out.println(savePurchase);
            ArticleService articleService = new ArticleService();
            for (PurchasedItemDto purchaseitem : savePurchase.getPurchasedItems()) {
                Task<Void> updateArticleTask = articleService.updateStockAsync(purchaseitem.getArticle().getId(),
                        purchaseitem.getArticle().getStock());
                updateArticleTask.setOnSucceeded(e1 -> {
                    System.out.println("Stock updated");
                });
                updateArticleTask.setOnFailed(e1 -> {
                    System.out.println(updateArticleTask.getException().getMessage());
                });
                new Thread(updateArticleTask).start();
            }
        });
        savePurchasetask.setOnFailed(e -> {
            System.out.println(savePurchasetask.getException().getMessage());
        });
        new Thread(savePurchasetask).start();
    }

    /**
     * @param s
     */
    @Override
    public void bindScene(Scene s) {
        this.view.bindScene(s);
    }
}