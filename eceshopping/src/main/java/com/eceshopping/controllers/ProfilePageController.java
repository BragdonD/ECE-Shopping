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
/**
 * Constructor of ProfilePageController
 * @param view
 */
    public ProfilePageController(ProfilePageView view) {
        this.view = view;
        this.controllers = new ArrayList<>();
        new UserNavBarController(this.view.getNavBar());
        int i = 0;
        for (ProfileMenuButtonLinkView button : this.view.getButtons()) {
            System.out.println(Routes.userProfileRoute.get(i).getPath());
            this.controllers.add(new ProfileMenuButtonLinkController(Routes.userProfileRoute.get(i).getPath(), button));
            i++;
        }
    }

    /**
     * @param s
     */

    @Override
    public void bindScene(Scene s) {
        this.view.bindScene(s);
    }
}
