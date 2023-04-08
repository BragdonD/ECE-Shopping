package com.eceshopping.controllers.components;

import com.eceshopping.configs.AppStyles;
import com.eceshopping.utils.Router;
import com.eceshopping.views.components.LinkNavBarView;

public class LinkNavBarController {
    private LinkNavBarView view;
    private String to;

    public LinkNavBarController(LinkNavBarView view, String to) {
        this.view = view;
        this.to = to;
        setupNavigate();
        setupHover();
    }

    public LinkNavBarView getView() {
        return this.view;
    }

    private void setupNavigate() {
        System.out.println("Setting up navigate");
        this.view.setOnMouseClicked(e -> {
            System.out.println("Navigating to " + to);
            Router.getInstance().navigateTo(to);
        });
    }

    private void setupHover() {
        this.view.setOnMouseEntered(e -> {
            this.view.setStyle(AppStyles.NAVBAR_BUTTON_STYLE_HOVER);
        });
        this.view.setOnMouseExited(e -> {
            this.view.setStyle(AppStyles.NAVBAR_BUTTON_STYLE);
        });
    }
}
