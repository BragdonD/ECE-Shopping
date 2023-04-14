package com.eceshopping.controllers;

import com.eceshopping.views.HomePageView;

import javafx.scene.Scene;

public class HomePageController implements Controller {
    private final HomePageView view;
    private UserNavBarController navBarController;

    public HomePageController(HomePageView view) {
        this.view = view;
        this.navBarController = new UserNavBarController(this.view.getNavBar());
    }

    @Override
    public void bindScene(Scene s) {
        this.view.bindScene(s);
    }
}
