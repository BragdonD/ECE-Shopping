package com.eceshopping.views.components;

import java.util.ArrayList;
import java.util.List;

import com.eceshopping.configs.AppStyles;

import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.layout.HBox;

public class UserNavBarView extends HBox {
    List<LinkNavBarView> links;

    public UserNavBarView() {
        this.links = new ArrayList<>();
        this.setStyle(AppStyles.NAVBAR_STYLE);
    }

    public UserNavBarView(List<LinkNavBarView> links) {
        this.links = links;
    }

    public List<LinkNavBarView> getLinks() {
        return links;
    }

    public void setLinks(List<LinkNavBarView> links) {
        this.links = links;
    }

    public void addLink(LinkNavBarView link) {
        link.setPadding(new Insets(10));
        this.links.add(link);
        this.getChildren().add(link);
    }

    public void addLink(int index, LinkNavBarView link) {
        this.links.add(index, link);
        this.getChildren().add(index, link);
    }

    public void removeLink(LinkNavBarView link) {
        this.links.remove(link);
    }

    public void bindScene(Scene scene) {
        this.prefWidthProperty().bind(scene.widthProperty());
    }
}
