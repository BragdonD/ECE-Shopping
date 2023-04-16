package com.eceshopping.views.components;

import com.eceshopping.views.View;

import javafx.scene.Node;
import javafx.scene.control.Hyperlink;
import javafx.scene.layout.GridPane;

public class ManageUserView extends GridPane implements View {

    int row = 1;
    GridPane usersLayout;
    private Hyperlink backLink;

    public ManageUserView() {
        super();
        usersLayout = new GridPane();
        this.usersLayout.setAlignment(javafx.geometry.Pos.TOP_CENTER);
        this.usersLayout.setPadding(new javafx.geometry.Insets(20.0, 20.0, 20.0, 20.0));
        this.usersLayout.setHgap(20);
        this.usersLayout.setVgap(20);
        this.add(usersLayout, row, row);
        this.row++;
        this.backLink = new Hyperlink("Retour");
        this.add(backLink, 0, 9, 1, 1);
    }

    public void addUser(UserOverView user) {
        int col = row % 1; // calculate the column index
        int rowIdx = row / 1; // calculate the row index

        this.usersLayout.add(user, col, rowIdx);
        this.row++;
    }

    public Hyperlink getBackLink() {
        return backLink;
    }

    public void setBackLink(Hyperlink backLink) {
        this.backLink = backLink;
    }

    @Override
    public Node getRootNode() {
        // TODO Auto-generated method stub
        return this;
    }
}
