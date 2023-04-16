package com.eceshopping.controllers;

import com.eceshopping.utils.Router;
import com.eceshopping.views.components.AdminMenuView;

import javafx.scene.Scene;

public class AdminMenuController implements Controller {

    private AdminMenuView view;

    public AdminMenuController(AdminMenuView view) throws IllegalArgumentException {
        this.view = view;
        setupHyperlink();
    }

    private void setupHyperlink() {
        this.view.getManageInvButton().setOnAction(e -> {
            Router.getInstance().navigateTo("/manageInv");
        });

        this.view.getManageUsersButton().setOnAction(e -> {
            Router.getInstance().navigateTo("/manageUsers");
        });

        this.view.getManageOrdersButton().setOnAction(e -> {
            Router.getInstance().navigateTo("/manageOrders");
        });
    }

    /**
     * @param scene
     */
    @Override
    public void bindScene(Scene scene) {

    }
}
