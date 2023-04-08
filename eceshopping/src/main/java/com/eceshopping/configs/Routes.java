package com.eceshopping.configs;

import java.util.Arrays;
import java.util.List;

import com.eceshopping.utils.Route;

/**
 * This class is used to configure the routes of the application
 */
public class Routes {
    public static final List<Route> routes = Arrays.asList(
        new Route("Home", 0, "/"),
        new Route("Products", 1, "/products"),
        new Route("Cart", 2, "/cart"),
        new Route("Login", 3, "/login"),
        new Route("Register", 4, "/register")
    );
}