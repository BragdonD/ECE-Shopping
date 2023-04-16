package com.eceshopping.controllers;

import java.util.List;

import com.eceshopping.dto.ArticleDto;
import com.eceshopping.events.DisplayArticleEvent;
import com.eceshopping.events.ModifyInvEvent;
import com.eceshopping.services.ArticleService;
import com.eceshopping.utils.Router;
import com.eceshopping.views.ModifyArticleFormView;
import com.eceshopping.views.ProductOView;

import javafx.concurrent.Task;
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

    private void setupRemoveButton() {
        this.view.getRemoveArticleButton().setOnAction(e -> {

            articleService.delete(this.view.getTitle());

        });
    }

    private void setupModifyButton() {
        this.view.getModifyArticleButton().setOnAction(e -> {

            Router.getInstance().getRouterController().getMainStage().fireEvent(new DisplayArticleEvent(this.article));
            Router.getInstance().navigateTo("/modifyArticle");

        });
    }

    @Override
    public void bindScene(Scene scene) {
        // TODO Auto-generated method stub

    }
}