package com.eceshopping.events;

import com.eceshopping.dto.ArticleDto;

import javafx.event.Event;
import javafx.event.EventType;

public class ModifyInvEvent extends Event {

    public static final EventType<ModifyInvEvent> MODIFY_ARTICLE = new EventType<>(Event.ANY, "MODIFY_ARTICLE");
    private ArticleDto article;
    private boolean isDelete;

    public ModifyInvEvent(ArticleDto article) {
        super(MODIFY_ARTICLE);
        this.article = article;
        this.isDelete = false;
    }

    public ModifyInvEvent(ArticleDto article, boolean isDelete) {
        super(MODIFY_ARTICLE);
        this.article = article;
        this.isDelete = isDelete;
    }

    
    /** 
     * @return ArticleDto
     */
    public ArticleDto getArticle() {
        return article;
    }

    public boolean isDelete() {
        return isDelete;
    }

}
