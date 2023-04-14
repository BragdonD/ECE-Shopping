package com.eceshopping.controllers;

import com.eceshopping.dto.ArticleDto;
import com.eceshopping.events.DisplayProductEvent;
import com.eceshopping.utils.Router;
import com.eceshopping.views.ProductPageView;

import javafx.scene.Scene;

public class ProductPageController implements Controller {
    private ProductPageView view;
    private ArticleDto article;
    private UserNavBarController navBarController;
    
    public ProductPageController(ProductPageView view) {
        this.view = view;
        this.navBarController = new UserNavBarController(this.view.getNavBar());
        listenToEvents();
    }

    public void listenToEvents() {
        Router.getInstance().getRouterController().getMainStage().addEventHandler(DisplayProductEvent.DISPLAY_PRODUCT_EVENT, e -> {
            this.article = e.getArticle();
            this.view.setImage(article.getImage());
            this.view.setName(article.getName());
            this.view.setPrice(Double.toString(article.getPrice()));
            this.view.setDescription("description temporaire");    
        });   
    }

    @Override
    public void bindScene(Scene s) {
        this.view.bindScene(s);
    }
}
