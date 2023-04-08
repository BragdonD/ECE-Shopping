package com.eceshopping.controllers;

import com.eceshopping.utils.Session;
import com.eceshopping.views.UserInformationsPage;

import javafx.beans.binding.BooleanBinding;
import javafx.beans.property.BooleanProperty;
import javafx.beans.property.SimpleBooleanProperty;
import javafx.scene.Scene;

public class UserInformationsPageController implements Controller {
    private UserInformationsPage view;
    private BooleanProperty editable;

    public UserInformationsPageController(UserInformationsPage view) {
        this.view = view;
        this.editable = new SimpleBooleanProperty(false);
        this.bindEditable();
        this.bindToCurrentUser();
    }

    private void bindEditable() {
        BooleanBinding binding = this.editable.not();
        this.view.getEmailInput().disableProperty().bind(binding);
        this.view.getNameInput().disableProperty().bind(binding);
        this.view.getPasswordInput().disableProperty().bind(binding);
        
        this.view.getEditButton().setOnMouseClicked(e -> {
            this.editable.set(true);
            this.view.getButtonsLayout().getChildren().remove(this.view.getEditButton());
            this.view.getButtonsLayout().getChildren().addAll(this.view.getCancelButton(), this.view.getSaveButton());
        });
        this.view.getCancelButton().setOnMouseClicked(e -> {
            this.editable.set(false);
            this.view.getButtonsLayout().getChildren().remove(this.view.getCancelButton());
            this.view.getButtonsLayout().getChildren().remove(this.view.getSaveButton());
            this.view.getButtonsLayout().getChildren().add(this.view.getEditButton());
        });
    }

    private void bindToCurrentUser() {
        Session.getInstance().addUserChangedListener((newValue) -> {
            if(newValue == null) return;
            this.view.getEmailInput().setValue(newValue.getEmail());
            this.view.getNameInput().setValue(newValue.getUsername());
            this.view.getPasswordInput().setValue(newValue.getPassword());
        });
    }

    @Override
    public void bindScene(Scene s) {
        this.view.bindScene(s);
    }
}
