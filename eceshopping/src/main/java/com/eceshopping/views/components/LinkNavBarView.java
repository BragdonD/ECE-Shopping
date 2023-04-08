package com.eceshopping.views.components;

import javafx.scene.control.Menu;

public class LinkNavBarView extends Menu {
    String name;

    public LinkNavBarView(String text) {
        super(text);
        this.name = text;
    }
}
