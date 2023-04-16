package com.eceshopping.controllers;

import com.eceshopping.dto.ArticleDto;
import com.eceshopping.events.DisplayArticleEvent;
import com.eceshopping.events.ModifyInvEvent;
import com.eceshopping.services.ArticleService;
import com.eceshopping.utils.Router;
import com.eceshopping.views.ProductOView;

import javafx.scene.Scene;

public class ProductOviewController implements Controller {
    ArticleService articleService = new ArticleService();
    ArticleDto article;
    private ProductOView view;

    public ProductOviewController(ProductOView view, ArticleDto article) throws IllegalArgumentException {

        this.view = view;
        this.articleService = new ArticleService();
        setupRemoveButton();
        setupModifyButton();
        this.article = article;

    }

    public ProductOView getView() {
        return this.view;
    }

    private void setupRemoveButton() {
        this.view.getRemoveArticleButton().setOnAction(e -> {
            Router.getInstance().getRouterController().getMainStage().fireEvent(new ModifyInvEvent(this.article, true));
            articleService.delete(this.view.getTitle());
        });
    }

    private void setupModifyButton() {
        this.view.getModifyArticleButton().setOnAction(e -> {

            Router.getInstance().getRouterController().getMainStage().fireEvent(new DisplayArticleEvent(this.article));
            Router.getInstance().navigateTo("/modifyArticle");

        });
    }

    public void updateView(ArticleDto article) {
        this.article = article;
        this.view.setTitle(article.getName());
    }
    
    /** 
     * @param scene
     */
    @Override
    public void bindScene(Scene scene) {
    }
}