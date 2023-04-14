package com.eceshopping.controllers;

import com.eceshopping.configs.AppStyles;
import com.eceshopping.dto.ArticleDto;
import com.eceshopping.events.DisplayProductEvent;
import com.eceshopping.utils.Router;
import com.eceshopping.views.components.ProductOverviewView;

public class ProductOverviewController {
    private ProductOverviewView view;
    private ArticleDto article;

    public ProductOverviewController(ProductOverviewView view, ArticleDto article) {
        this.view = view;
        this.article = article;
        setupStyle();
        setupEvents();
    }

    private void setupStyle() {
        this.view.setOnMouseEntered(e -> {
            this.view.setStyle(AppStyles.PRODUCT_OVERVIEW_STYLE_HOVER);
        });
        this.view.setOnMouseExited(e -> {
            this.view.setStyle(AppStyles.PRODUCT_OVERVIEW_STYLE);
        });
    }

    private void setupEvents() {
        this.view.setOnMouseClicked(e -> {
            Router.getInstance().getRouterController().getMainStage().fireEvent(new DisplayProductEvent(this.article));
        });
    }

}
