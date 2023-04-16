package com.eceshopping.events;

import com.eceshopping.dto.ArticleDto;

import javafx.event.Event;
import javafx.event.EventType;

public class DisplayArticleEvent extends Event {

    public static final EventType<DisplayArticleEvent> DISPLAY_ARTICLE = new EventType<>(Event.ANY, "DISPLAY_ARTICLE");
    private ArticleDto article;

    /**
     * Constructor of DisplayArticleEvent
     * 
     * @param article
     */
    public DisplayArticleEvent(ArticleDto article) {
        super(DISPLAY_ARTICLE);
        this.article = article;
    }

    /**
     * @return ArticleDto
     */
    public ArticleDto getArticle() {
        return article;
    }

}
