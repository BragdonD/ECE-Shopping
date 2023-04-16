package com.eceshopping.factories.components;

import com.eceshopping.configs.Routes;
import com.eceshopping.utils.Route;
import com.eceshopping.views.components.LinkNavBarView;
import com.eceshopping.views.components.UserNavBarView;

/**
 * This class is used to create the navbar
 */
public class NavBarFactory {

    /**
     * @return UserNavBarView
     */
    public static UserNavBarView createUserNavBarView() {
        UserNavBarView navBar = new UserNavBarView();
        for (Route route : Routes.navBarRoutes) {
            LinkNavBarView link = new LinkNavBarView(route.getName());
            navBar.addLink(link);
        }
        return navBar;
    }
}
