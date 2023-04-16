package com.eceshopping.controllers.components;

import com.eceshopping.dto.ArticleDto;
import com.eceshopping.events.DeleteFromBasketEvent;
import com.eceshopping.utils.Router;
import com.eceshopping.views.components.CartItemView;

public class CartItemController {
    private CartItemView view;
    private Integer quantity;
    private ArticleDto article;
    private Double price;

    public CartItemController(CartItemView view, ArticleDto article, Integer quantity) {
        this.view = view;
        this.quantity = quantity;
        this.article = article;
        this.price = article.getPrice() * quantity;
        this.view.getQuantity().setText(quantity.toString());
        this.view.getProductOverviewView().getTitle().setText(article.getName());
        this.view.getProductOverviewView().getImage().setImage(article.getImage());
        setupDeleteArticle();
    }

    public void updateQuantity(Integer quantity) {
        this.quantity = quantity;
        if (quantity >= 10) {
            int bulkSets = quantity / 10;
            int remainingArticles = quantity % 10;
            this.price = bulkSets * article.getBulkprice() * 10;
            if (remainingArticles > 0) {
                this.price += remainingArticles * article.getPrice();
            }
        } else {
            this.price = quantity * article.getPrice();
        }
        this.view.getQuantity().setText(quantity.toString());
    }

    public ArticleDto getArticle() {
        return this.article;
    }

    public Double getPrice() {
        return this.price;
    }

    public Integer getQuantity() {
        return this.quantity;
    }

    public CartItemView getView() {
        return this.view;
    }

    private void setupDeleteArticle() {
        this.view.getRemoveButton().setOnAction(e -> {
            if (quantity > 0) {
                updateQuantity(quantity - 1);
                if (quantity == 0) {
                    Router.getInstance().getRouterController().getMainStage()
                            .fireEvent(new DeleteFromBasketEvent(article, 1, true));
                } else {
                    Router.getInstance().getRouterController().getMainStage()
                            .fireEvent(new DeleteFromBasketEvent(article, 1, false));
                }
            }
        });

        this.view.getDeleteButton().setOnAction(e -> {
            Router.getInstance().getRouterController().getMainStage()
                    .fireEvent(new DeleteFromBasketEvent(article, quantity, true));
        });
    }
}