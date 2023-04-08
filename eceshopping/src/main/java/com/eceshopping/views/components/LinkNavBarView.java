package com.eceshopping.views.components;

import javafx.scene.control.Menu;

/*
 * LinkNavBarView class is a utility class for creating a link in the navigation bar.
 */
public class LinkNavBarView extends Menu {
    String name;

    public LinkNavBarView(String text) {
        super(text);
        this.name = text;
    }
}
