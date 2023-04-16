package com.eceshopping.views;

import javafx.scene.Node;
import javafx.scene.Scene;

/**
 * Interface for views in the application.
 */
public interface View {
    public Scene getScene();

    public Node getRootNode();
}
