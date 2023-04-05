package com.eceshopping.controllers;

import com.eceshopping.views.ProfilePageView;
import com.eceshopping.views.components.ProfileMenuButtonLinkView;

public class ProfilePageController implements Controller {
    private final ProfilePageView view;

    public ProfilePageController(ProfilePageView view) {
        this.view = view;
        for(ProfileMenuButtonLinkView button : this.view.getButtons()) {
            button.setOnMouseEntered(e -> {
                button.setStyle("-fx-background-color: lightblue;");
            });

            button.setOnMouseExited(e -> {
                button.setStyle("-fx-background-color: #ffffff;");
            });
        }
    }
}
