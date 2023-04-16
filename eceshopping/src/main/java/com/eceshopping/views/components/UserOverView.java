package com.eceshopping.views.components;

import javafx.scene.layout.GridPane;

public class UserOverView extends GridPane {
    String email;
    String name;
    boolean isAdmin;

    public UserOverView(String email,String name, boolean isAdmin) {
        super();
        this.email = email;
        this.name = name;
        this.isAdmin = isAdmin;
    }
    
    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public boolean isAdmin() {
        return isAdmin;
    }

    public void setAdmin(boolean isAdmin) {
        this.isAdmin = isAdmin;
    }

}
