package com.eceshopping.events;

import com.eceshopping.dto.ArticleDto;

import javafx.event.Event;
import javafx.event.EventType;

public class ModifyInvEvent extends Event {

    public static final EventType<ModifyInvEvent> MODIFY_ARTICLE = new EventType<>(Event.ANY, "MODIFY_ARTICLE");
    private ArticleDto article;

    public ModifyInvEvent(ArticleDto article) {
        super(MODIFY_ARTICLE);
        this.article = article;
    }

    public ArticleDto getArticle() {
        return article;
    }

}
