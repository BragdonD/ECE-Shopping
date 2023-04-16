package com.eceshopping.events;

import com.eceshopping.dto.ArticleDto;

import javafx.event.Event;
import javafx.event.EventType;

public class AddToBasketEvent extends Event {
    public static final EventType<AddToBasketEvent> ADD_TO_CART_EVENT = new EventType<>(Event.ANY, "ADD_TO_CART_EVENT");
    private int quantity;
    private ArticleDto article;

    /**
     * Constructor of AddToBasketEvent
     * 
     * @param article
     * @param quantity
     */
    public AddToBasketEvent(ArticleDto article, int quantity) {
        super(ADD_TO_CART_EVENT);
        this.quantity = quantity;
        this.article = article;
    }

    /**
     * @return ArticleDto
     */
    public ArticleDto getArticle() {
        return article;
    }

    /**
     * @return int
     */
    public int getQuantity() {
        return quantity;
    }
}
