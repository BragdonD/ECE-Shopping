package com.eceshopping.controllers;

import java.util.List;

import com.eceshopping.configs.AppStyles;
import com.eceshopping.controllers.components.InputFieldController;
import com.eceshopping.utils.Session;
import com.eceshopping.views.UserInformationsPage;

import javafx.beans.binding.BooleanBinding;
import javafx.beans.property.BooleanProperty;
import javafx.beans.property.SimpleBooleanProperty;
import javafx.scene.Scene;

public class UserInformationsPageController implements Controller {
    private UserInformationsPage view;
    private BooleanProperty editable;
    private UserNavBarController navBarController;

    public UserInformationsPageController(UserInformationsPage view) {
        this.view = view;
        this.navBarController = new UserNavBarController(this.view.getNavBar());
        this.editable = new SimpleBooleanProperty(false);
        this.bindEditable();
        this.bindToCurrentUser();
        this.ButtonsStyle();
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

    private void ButtonsStyle() {
        this.view.getEditButton().setOnMouseEntered(e -> {
            this.view.getEditButton().setStyle(AppStyles.EDIT_BUTTON_STYLE_HOVER);
        });
        this.view.getEditButton().setOnMouseExited(e -> {
            this.view.getEditButton().setStyle(AppStyles.EDIT_BUTTON_STYLE);
        });
        this.view.getCancelButton().setOnMouseEntered(e -> {
            this.view.getCancelButton().setStyle(AppStyles.CANCEL_BUTTON_STYLE_HOVER);
        });
        this.view.getCancelButton().setOnMouseExited(e -> {
            this.view.getCancelButton().setStyle(AppStyles.CANCEL_BUTTON_STYLE);
        });
        this.view.getSaveButton().setOnMouseEntered(e -> {
            this.view.getSaveButton().setStyle(AppStyles.SAVE_BUTTON_STYLE_HOVER);
        });
        this.view.getSaveButton().setOnMouseExited(e -> {
            this.view.getSaveButton().setStyle(AppStyles.SAVE_BUTTON_STYLE);
        });
    }

    @Override
    public void bindScene(Scene s) {
        this.view.bindScene(s);
    }
}
