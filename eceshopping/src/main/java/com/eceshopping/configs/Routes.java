package com.eceshopping.configs;

import java.util.Arrays;
import java.util.List;

import com.eceshopping.utils.Route;

/**
 * This class is used to configure the routes of the application
 */
public class Routes {

    public static final List<Route> userProfileRoute = Arrays.asList(
            new Route("Orders", 0, "/profile/orders"),
            new Route("Addresses", 1, "/profile/contact"),
            new Route("Payment Methods", 2, "/profile/informations"));

    public static final List<Route> navBarRoutes = Arrays.asList(
            new Route("Home", 0, "/"),
            new Route("Cart", 1, "/cart"),
            new Route("Profile", 2, "/profile"));
}