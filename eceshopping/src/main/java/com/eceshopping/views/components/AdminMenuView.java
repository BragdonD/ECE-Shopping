package com.eceshopping.views.components;

import com.eceshopping.views.View;

import javafx.geometry.Pos;
import javafx.scene.Node;
import javafx.scene.control.Hyperlink;
import javafx.scene.layout.GridPane;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;

public class AdminMenuView extends GridPane implements View {
    Text tittle;
    Hyperlink manageInvButton;
    Hyperlink manageUsersButton;
    Hyperlink manageOrdersButton;

    public AdminMenuView() {
        super();
        this.setAlignment(Pos.CENTER);
        this.setHgap(10);
        this.setVgap(10);
        this.tittle = new Text("Menu Administrateur");
        tittle.setFont(Font.font("Tahoma", FontWeight.NORMAL, 20));
        this.manageInvButton = new Hyperlink("Gestion de l'inventaire");
        this.manageUsersButton = new Hyperlink("Gestion des utilisateurs");
        this.manageOrdersButton = new Hyperlink("Gestion des commandes");
        this.add(this.tittle, 0, 0, 2, 1);
        this.add(this.manageInvButton, 0, 4);
        this.add(this.manageUsersButton, 0, 5);
        this.add(this.manageOrdersButton, 0, 6);

    }

    public Hyperlink getManageInvButton() {
        return this.manageInvButton;
    }

    public Hyperlink getManageUsersButton() {
        return this.manageUsersButton;
    }

    public Hyperlink getManageOrdersButton() {
        return this.manageOrdersButton;
    }

    @Override
    public Node getRootNode() {
        return this;
    }

}
