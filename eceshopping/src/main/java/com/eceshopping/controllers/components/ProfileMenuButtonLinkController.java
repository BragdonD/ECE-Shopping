package com.eceshopping.controllers.components;

import com.eceshopping.views.components.ProfileMenuButtonLinkView;

public class ProfileMenuButtonLinkController extends ButtonLinkController {
    public ProfileMenuButtonLinkController(String to, ProfileMenuButtonLinkView view) { 
        super(to, view);
        this.view.setOnMouseEntered(e -> {
            /// Apply style
        });
        this.view.setOnMouseExited(e -> {
            /// Apply style
        });
    }
}
