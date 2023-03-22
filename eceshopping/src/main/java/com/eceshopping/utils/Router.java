package com.eceshopping.utils;


import java.util.ArrayList;
import java.util.HashMap;

import com.eceshopping.controllers.Controller;
import com.eceshopping.controllers.RouterController;
import com.eceshopping.views.View;

/**
 * Singleton class for the router of the application (used to navigate between views).
 */
public class Router {
    RouterController routerController;
    private static Router instance;
    private ArrayList<String> routes;
    private HashMap<String, View> views;
    private HashMap<String, Controller> controllers;
    
    /**
     * Private constructor for the router.
     */
    private Router() {
        routerController = new RouterController();
        routes = new ArrayList<String>();
        views = new HashMap<String, View>();
        controllers = new HashMap<String, Controller>();
    }

    /**
     * Get the instance of the router.
     * @return the instance of the router.
     */
    public static Router getInstance() {
        if (instance == null) {
            instance = new Router();
        }
        return instance;
    }

    /**
     * Add a route to the application.
     * @param route the route to add. 
     * @param view the view of the route.
     * @param controller the controller of the route.
     * @throws IllegalArgumentException if the route already exists.
     */
    public void addRoute(String route, View view, Controller controller) throws IllegalArgumentException {
        if(routes.contains(route)) {
            throw new IllegalArgumentException("Route already exists");
        }
        routes.add(route);
        views.put(route, view);
        controllers.put(route, controller);
    }

    /**
     * Remove a route from the application.
     * @param route the route to remove.
     * @throws IllegalArgumentException if the route does not exist.
     */
    public void removeRoute(String route) throws IllegalArgumentException {
        if(!routes.contains(route)) {
            throw new IllegalArgumentException("Route does not exist");
        }
        routes.remove(route);
        views.remove(route);
        controllers.remove(route);
    }

    /**
     * Navigate to a route. 
     * @param route the route to navigate to.
     * @throws IllegalArgumentException if the route does not exist.
     */
    public void navigateTo(String route) throws IllegalArgumentException {
        if(!routes.contains(route)) {
            throw new IllegalArgumentException("Route does not exist");
        }
        routerController.setScene(views.get(route).getScene());
    }

    /**
     * Get the routes of the application. 
     * @return the routes of the application.
     */
    public ArrayList<String> getRoutes() {
        return routes;
    }

    /**
     * Get the router controller of the application (used to set the main stage).
     * @return the router controller of the application.
     */
    public RouterController getRouterController() {
        return routerController;
    }
}
