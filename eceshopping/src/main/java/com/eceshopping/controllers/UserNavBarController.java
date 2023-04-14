package com.eceshopping.controllers;

import java.util.ArrayList;
import java.util.List;

import com.eceshopping.configs.Routes;
import com.eceshopping.controllers.components.LinkNavBarController;
import com.eceshopping.controllers.components.SearchBarController;
import com.eceshopping.views.components.LinkNavBarView;
import com.eceshopping.views.components.UserNavBarView;

public class UserNavBarController {
    private UserNavBarView view;
    private List<LinkNavBarController> links; 
    private SearchBarController searchBarController;

    public UserNavBarController(UserNavBarView view) {
        this.view = view;
        this.links = new ArrayList<LinkNavBarController>();
        int i = 0;
        for(LinkNavBarView menu : this.view.getLinks()) {
            links.add(new LinkNavBarController(menu, Routes.navBarRoutes.get(i).getPath()));
            i++;
        }
        this.searchBarController = new SearchBarController(this.view.getSearchBar());
    }
}
