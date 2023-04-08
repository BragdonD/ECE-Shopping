package com.eceshopping.factories.components;

import com.eceshopping.configs.Routes;
import com.eceshopping.utils.Route;
import com.eceshopping.views.components.LinkNavBarView;
import com.eceshopping.views.components.UserNavBarView;

public class NavBarFactory {
    public static UserNavBarView createUserNavBarView() {
        UserNavBarView navBar = new UserNavBarView();
        for (Route route : Routes.routes) {
            LinkNavBarView link = new LinkNavBarView(route.getName());
            navBar.addLink(link);
        }
        return navBar;
    }
}
