package com.eceshopping.utils;

import com.eceshopping.controllers.RouterController;

/**
 * Singleton class for the router of the application
 */
public class Router {
    RouterController routerController;
    private static Router instance;

    private Router() {
        routerController = new RouterController();
    }

    public static Router getInstance() {
        if (instance == null) {
            instance = new Router();
        }
        return instance;
    }

    public RouterController getRouterController() {
        return routerController;
    }
}
