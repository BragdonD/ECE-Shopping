package com.eceshopping.views.components;

import com.eceshopping.views.View;

import javafx.scene.Node;
import javafx.scene.layout.GridPane;

public class ManageUserView extends GridPane implements View{

    int row = 1;
    GridPane usersLayout;

public ManageUserView() {
    super();
    usersLayout = new GridPane();
    this.usersLayout.setAlignment(javafx.geometry.Pos.TOP_CENTER);
    this.usersLayout.setPadding(new javafx.geometry.Insets(20.0, 20.0, 20.0, 20.0));
    this.usersLayout.setHgap(20);
    this.usersLayout.setVgap(20);
    this.add(usersLayout, row, row);
    this.row++;
}

    public void addUser(UserOverView user) {
        int col = row % 1; // calculate the column index
        int rowIdx = row / 1; // calculate the row index
        
        this.usersLayout.add(user, col, rowIdx);
        this.row++;
    }

    @Override
    public Node getRootNode() {
        // TODO Auto-generated method stub
        return this;
    }
}
