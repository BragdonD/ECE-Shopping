package com.eceshopping.controllers;

import com.eceshopping.configs.AppStyles;
import com.eceshopping.views.components.ProductOverviewView;

public class ProductOverviewController {
    private ProductOverviewView view;

    public ProductOverviewController(ProductOverviewView view) {
        this.view = view;
        setupStyle();
    }

    private void setupStyle() {
        this.view.setOnMouseEntered(e -> {
            this.view.setStyle(AppStyles.PRODUCT_OVERVIEW_STYLE_HOVER);
        });
        this.view.setOnMouseExited(e -> {
            this.view.setStyle(AppStyles.PRODUCT_OVERVIEW_STYLE);
        });
    }     


}
