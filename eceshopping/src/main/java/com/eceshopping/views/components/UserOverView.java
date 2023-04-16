package com.eceshopping.views.components;

import javafx.scene.control.Label;
import javafx.scene.layout.GridPane;

public class UserOverView extends GridPane {
    Label email;
    Label name;
    boolean isAdmin;
    String email1;
    String name1;

    public UserOverView(String email, String name, boolean isAdmin) {
        super();
        this.email1 = email;
        this.name1 = name;
        this.email = new Label(email);
        this.name = new Label(name);
        this.add(this.name, 0, 1);
        this.add(this.email, 0, 2);
        this.isAdmin = isAdmin;
    }

    public String getEmail() {
        return email1;
    }

    public void setEmail(String email) {
        this.email1 = email;
    }

    public String getName() {
        return name1;
    }

    public void setName(String name) {
        this.name1 = name;
    }

    public boolean isAdmin() {
        return isAdmin;
    }

    public void setAdmin(boolean isAdmin) {
        this.isAdmin = isAdmin;
    }

    public Label getEmailLabel() {
        return email;
    }

    public Label getNameLabel() {
        return name;
    }

    public void setEmailLabel(Label email) {
        this.email = email;
    }

    public void setNameLabel(Label name) {
        this.name = name;
    }

}
