package com.eceshopping.utils;

import com.eceshopping.controllers.RouterController;

/**
 * Singleton class for the router of the application
 */
public class Router {
    RouterController routerController;
    private static Router instance;

    /**
     * Private constructor for the class Router 
     */
    private Router() {
        routerController = new RouterController();
    }

    /**
     * Get the instance of the router class 
     * @return Router instance 
     */
    public static Router getInstance() {
        if (instance == null) {
            instance = new Router();
        }
        return instance;
    }
    /**
     * Get the router controller 
     * @return RouterController instance 
     */
    public RouterController getRouterController() {
        return routerController;
    }
}
