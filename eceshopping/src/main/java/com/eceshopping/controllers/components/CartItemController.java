package com.eceshopping.controllers.components;

import com.eceshopping.dto.ArticleDto;
import com.eceshopping.events.DeleteFromBasketEvent;
import com.eceshopping.utils.Router;
import com.eceshopping.views.components.CartItemView;

/**
 * Controller class for CartItemView. This class is used to handle
 * the events of the CartItemView.
 */
public class CartItemController {
    private CartItemView view;
    private Integer quantity;
    private ArticleDto article;
    private Double price;

    /**
     * Constructor for CartItemController class.
     * @param view The view to be controlled.
     * @param article The article to be displayed.
     * @param quantity The quantity of the article.
     */
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

    /**
     * Update the quantity of the article.
     * @param quantity The new quantity of the article.
     */
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

    /**
     * Get the article.
     * @return The article.
     */
    public ArticleDto getArticle() {
        return this.article;
    }

    /**
     * Get the price of the article.
     * @return The price of the article.
     */
    public Double getPrice() {
        return this.price;
    }

    /**
     * Get the quantity of the article.
     * @return The quantity of the article.
     */
    public Integer getQuantity() {
        return this.quantity;
    }

    /**
     * Get the view to be controlled.
     * @return The view to be controlled.
     */
    public CartItemView getView() {
        return this.view;
    }

    /**
     * Set the event handlers for the delete buttons. 
     */
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