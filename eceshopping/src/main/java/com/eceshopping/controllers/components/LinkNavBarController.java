package com.eceshopping.controllers.components;

import com.eceshopping.utils.Router;
import com.eceshopping.views.components.LinkNavBarView;

public class LinkNavBarController {
    private LinkNavBarView view;
    private String to;

    /*
     * This method is used to navigate to the page
     */
    public LinkNavBarController(LinkNavBarView view, String to) {
        this.view = view;
        this.to = to;
        setupNavigate();
    }

    /*
     * get the view
     */
    public LinkNavBarView getView() {
        return this.view;
    }

    /*
     * set the view
     */
    private void setupNavigate() {
        this.view.setOnAction(e -> {
            Router.getInstance().navigateTo(to);
        });
    }
}
