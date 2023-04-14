package com.eceshopping.controllers.components;

import com.eceshopping.configs.AppStyles;
import com.eceshopping.views.components.ProfileMenuButtonLinkView;

public class ProfileMenuButtonLinkController extends ButtonLinkController {
    public ProfileMenuButtonLinkController(String to, ProfileMenuButtonLinkView view) { 
        super(to, view);
        this.view.setOnMouseEntered(e -> {
            this.view.setStyle(AppStyles.PROFILE_PAGE_BUTTON_STYLE_HOVER);
        });
        this.view.setOnMouseExited(e -> {
            this.view.setStyle(AppStyles.PROFILE_PAGE_BUTTON_STYLE);
        });
    }
}
