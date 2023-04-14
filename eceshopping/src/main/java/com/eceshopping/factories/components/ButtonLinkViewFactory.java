package com.eceshopping.factories.components;

import com.eceshopping.controllers.components.ButtonLinkController;
import com.eceshopping.views.components.ButtonLinkView;

import javafx.util.Pair;

public class ButtonLinkViewFactory {
    public static Pair<ButtonLinkView, ButtonLinkController> createButtonLink(String to) {
        ButtonLinkView view = new ButtonLinkView();
        ButtonLinkController controller = new ButtonLinkController(to, view);
        return new Pair<>(view, controller);
    }
}