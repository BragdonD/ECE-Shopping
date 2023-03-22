package com.eceshopping.utils;

import java.util.ArrayList;
import java.util.HashMap;

import com.eceshopping.controllers.Controller;
import com.eceshopping.controllers.RouterController;
import com.eceshopping.views.View;

/**
 * Singleton class for the router of the application
 */
public class Router {
    RouterController routerController;
    private static Router instance;
    private ArrayList<String> routes;
    private HashMap<String, View> views;
    private HashMap<String, Controller> controllers;


    private Router() {
        routerController = new RouterController();
    }

    public static Router getInstance() {
        if (instance == null) {
            instance = new Router();
        }
        return instance;
    }

    public void addRoute(String route, View view, Controller controller) throws IllegalArgumentException {
        if(routes.contains(route)) {
            throw new IllegalArgumentException("Route already exists");
        }
        routes.add(route);
        views.put(route, view);
        controllers.put(route, controller);
    }

    public void removeRoute(String route) throws IllegalArgumentException {
        if(!routes.contains(route)) {
            throw new IllegalArgumentException("Route does not exist");
        }
        routes.remove(route);
        views.remove(route);
        controllers.remove(route);
    }

    public void navigateTo(String route) throws IllegalArgumentException {
        if(!routes.contains(route)) {
            throw new IllegalArgumentException("Route does not exist");
        }
        routerController.setScene(views.get(route).getScene());
    }

    public ArrayList<String> getRoutes() {
        return routes;
    }

    public RouterController getRouterController() {
        return routerController;
    }
}
