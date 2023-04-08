package com.eceshopping.configs;

import java.util.Arrays;
import java.util.List;

import com.eceshopping.utils.Route;

public class Routes {

    public static final List<Route> userProfileRoute = Arrays.asList(
        new Route("Orders", 0, "/profile/orders"),
        new Route("Addresses", 1, "/profile/contact"),
        new Route("Payment Methods", 2, "/profile/informations")
    );

    public static final List<Route> routes = Arrays.asList(
        new Route("Home", 0, "/"),
        new Route("Products", 1, "/products"),
        new Route("Cart", 2, "/cart"),
        new Route("Profile", 3, "/profile")
    );
}