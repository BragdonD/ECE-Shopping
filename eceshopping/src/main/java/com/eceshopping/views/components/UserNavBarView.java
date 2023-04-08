package com.eceshopping.views.components;

import java.util.ArrayList;
import java.util.List;

import javafx.scene.Scene;
import javafx.scene.control.MenuBar;


public class UserNavBarView extends MenuBar {
    List<LinkNavBarView> links;

    public UserNavBarView() {
        this.links = new ArrayList<>();
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
        this.links.add(link);
        this.getMenus().add(link);
    }

    public void addLink(int index, LinkNavBarView link) {
        this.links.add(index, link);
        this.getMenus().add(index, link);
    }

    public void removeLink(LinkNavBarView link) {
        this.links.remove(link);
    }

    public void bindScene(Scene scene) {
        this.prefWidthProperty().bind(scene.widthProperty());
    }
}
