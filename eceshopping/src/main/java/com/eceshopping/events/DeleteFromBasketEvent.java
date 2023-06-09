package com.eceshopping.events;

import com.eceshopping.dto.ArticleDto;

import javafx.event.Event;
import javafx.event.EventType;

public class DeleteFromBasketEvent extends Event {
    public static final EventType<DeleteFromBasketEvent> DELETE_FROM_CART_EVENT = new EventType<>(Event.ANY,
            "DELETE_FROM_CART_EVENT");
    private int quantity;
    private ArticleDto article;
    private boolean isDeleteAll;

    public DeleteFromBasketEvent(ArticleDto article, int quantity, boolean isDeleteAll) {
        super(DELETE_FROM_CART_EVENT);
        this.quantity = quantity;
        this.article = article;
        this.isDeleteAll = isDeleteAll;
    }

    /**
     * @return ArticleDto
     */
    public ArticleDto getArticle() {
        return article;
    }

    /**
     * @return boolean
     */
    public boolean isDeleteAll() {
        return isDeleteAll;
    }

    /**
     * Getter of Quantity
     * 
     * @return
     */
    public int getQuantity() {
        return quantity;
    }
}