package com.eceshopping.events;

import com.eceshopping.dto.ArticleDto;

import javafx.event.Event;
import javafx.event.EventType;

public class DisplayProductEvent extends Event {
    public static final EventType<DisplayProductEvent> DISPLAY_PRODUCT_EVENT = new EventType<>(Event.ANY,
            "DISPLAY_PRODUCT_EVENT");
    private ArticleDto article;

    public DisplayProductEvent(ArticleDto article) {
        super(DISPLAY_PRODUCT_EVENT);
        this.article = article;
    }

    public ArticleDto getArticle() {
        return this.article;
    }
}
