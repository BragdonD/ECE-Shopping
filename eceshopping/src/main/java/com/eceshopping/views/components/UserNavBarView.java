package com.eceshopping.views.components;

import java.util.ArrayList;
import java.util.List;

import com.eceshopping.configs.AppStyles;

import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.layout.HBox;

/*
 * UserNavBarView class is a utility class for creating a navigation bar.
 * It takes a list of LinkNavBarView.
 * It will display the links in the navigation bar.
 * It will also handle the layout of the navigation bar.
 */
public class UserNavBarView extends HBox {
    private List<LinkNavBarView> links;
    private SearchBarView searchBar;

    public UserNavBarView() {
        this.searchBar = new SearchBarView();
        this.getChildren().add(searchBar);
        HBox.setMargin(this.searchBar, new Insets(0, 200, 0, 0));
        this.links = new ArrayList<>();
        this.setStyle(AppStyles.NAVBAR_STYLE);
    }

    public UserNavBarView(List<LinkNavBarView> links) {
        this.links = links;
    }

    
    /** 
     * @return SearchBarView
     */
    public SearchBarView getSearchBar() {
        return searchBar;
    }

    
    /** 
     * @return List<LinkNavBarView>
     */
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
