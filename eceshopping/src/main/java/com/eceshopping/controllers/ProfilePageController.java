package com.eceshopping.controllers;

import java.util.ArrayList;
import java.util.List;

import com.eceshopping.configs.Routes;
import com.eceshopping.controllers.components.ProfileMenuButtonLinkController;
import com.eceshopping.views.ProfilePageView;
import com.eceshopping.views.components.ProfileMenuButtonLinkView;

import javafx.scene.Scene;

public class ProfilePageController implements Controller {
    private final ProfilePageView view;
    private List<ProfileMenuButtonLinkController> controllers;

    public ProfilePageController(ProfilePageView view) {
        this.view = view;
        this.controllers = new ArrayList<>();
        int i = 0;
        for(ProfileMenuButtonLinkView button : this.view.getButtons()) {
            this.controllers.add(new ProfileMenuButtonLinkController(Routes.userProfileRoute.get(i).getPath(), button));
            i++;
        }
    }

    @Override
    public void bindScene(Scene s) {
        this.view.prefWidthProperty().bind(s.widthProperty());
        this.view.prefHeightProperty().bind(s.heightProperty());
    }
}
