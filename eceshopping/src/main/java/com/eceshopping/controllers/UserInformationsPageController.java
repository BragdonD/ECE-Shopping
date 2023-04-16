package com.eceshopping.controllers;

import java.util.List;

import com.eceshopping.configs.AppStyles;
import com.eceshopping.controllers.components.InputFieldController;
import com.eceshopping.dto.UserDto;
import com.eceshopping.services.UserService;
import com.eceshopping.utils.Session;
import com.eceshopping.utils.validator.EmailValidator;
import com.eceshopping.utils.validator.NotEmptyStringValidator;
import com.eceshopping.utils.validator.PasswordValidator;
import com.eceshopping.views.UserInformationsPage;

import javafx.beans.binding.BooleanBinding;
import javafx.beans.property.BooleanProperty;
import javafx.beans.property.SimpleBooleanProperty;
import javafx.concurrent.Task;
import javafx.scene.Scene;
import javafx.scene.text.Text;

public class UserInformationsPageController implements Controller {
    private UserInformationsPage view;
    private BooleanProperty editable;
    private List<InputFieldController> inputFieldsControllers;
    private UserService userService;

    /**
     * Constructor of UserInformationsPageController
     * 
     * @param view
     */
    public UserInformationsPageController(UserInformationsPage view) {
        this.view = view;
        new UserNavBarController(this.view.getNavBar());
        this.editable = new SimpleBooleanProperty(false);
        this.userService = new UserService();
        this.bindEditable();
        this.bindToCurrentUser();
        this.ButtonsStyle();
        this.SaveNewInformation();
        InputFieldController emailController = new InputFieldController(this.view.getEmailInput(), null);
        InputFieldController nameController = new InputFieldController(this.view.getNameInput(), null);
        InputFieldController passwordController = new InputFieldController(this.view.getPasswordInput(), null);
        this.inputFieldsControllers = List.of(emailController, nameController, passwordController);
    }

    private void SaveNewInformation() {
        this.view.getSaveButton().setOnMouseClicked(e -> {
            UserDto user = new UserDto()
                    .email(this.inputFieldsControllers.get(0).getValue())
                    .username(this.inputFieldsControllers.get(1).getValue())
                    .password(this.inputFieldsControllers.get(2).getValue());

            System.out.println(user);

            if (!user.getEmail().equals(Session.getInstance().getUser().getEmail())) {
                Task<UserDto> UpdateEmailTask = userService.updateEmailAsync(user.getEmail(),
                        Session.getInstance().getUser().getId());
                new Thread(UpdateEmailTask).start();

                UpdateEmailTask.setOnSucceeded(event -> {
                    Session.getInstance().setUser(UpdateEmailTask.getValue());
                    this.bindToCurrentUser();
                    this.editable.set(false);
                    this.view.getButtonsLayout().getChildren().remove(this.view.getCancelButton());
                    this.view.getButtonsLayout().getChildren().remove(this.view.getSaveButton());
                    this.view.getButtonsLayout().getChildren().add(this.view.getEditButton());
                    eraseError();
                });

                UpdateEmailTask.setOnFailed(event -> {
                    displayError(UpdateEmailTask.getException().getMessage());
                });
            }

            if (!user.getPassword().equals("")) {
                Task<UserDto> UpdatePasswordTask = userService.updatePasswordAsync(user.getPassword(),
                        Session.getInstance().getUser().getId());
                new Thread(UpdatePasswordTask).start();

                UpdatePasswordTask.setOnSucceeded(event -> {
                    Session.getInstance().setUser(UpdatePasswordTask.getValue());
                    this.bindToCurrentUser();
                    this.editable.set(false);
                    this.view.getButtonsLayout().getChildren().remove(this.view.getCancelButton());
                    this.view.getButtonsLayout().getChildren().remove(this.view.getSaveButton());
                    this.view.getButtonsLayout().getChildren().add(this.view.getEditButton());
                    eraseError();
                    this.view.getPasswordInput().setValue("");
                });

                UpdatePasswordTask.setOnFailed(event -> {
                    displayError(UpdatePasswordTask.getException().getMessage());
                });
            }

            if (!user.getUsername().equals(Session.getInstance().getUser().getUsername())) {
                Task<UserDto> UpdateUsernameTask = userService.updateNameAsync(user.getUsername(),
                        Session.getInstance().getUser().getId());
                new Thread(UpdateUsernameTask).start();

                UpdateUsernameTask.setOnSucceeded(event -> {
                    Session.getInstance().setUser(UpdateUsernameTask.getValue());
                    this.bindToCurrentUser();
                    this.editable.set(false);
                    this.view.getButtonsLayout().getChildren().remove(this.view.getCancelButton());
                    this.view.getButtonsLayout().getChildren().remove(this.view.getSaveButton());
                    this.view.getButtonsLayout().getChildren().add(this.view.getEditButton());
                    eraseError();
                });

                UpdateUsernameTask.setOnFailed(event -> {
                    displayError(UpdateUsernameTask.getException().getMessage());
                });
            }
        });
    }

    /**
     * @param error
     */
    private void displayError(String error) {
        Text errorText = new Text(error);
        errorText.getStyleClass().add(AppStyles.ERROR_TEXT_STYLE);
        this.view.getFormLayout().add(errorText, 0, 5);
    }

    private void eraseError() {
        this.view.getFormLayout().getChildren()
                .removeIf(node -> node.getStyleClass().contains(AppStyles.ERROR_TEXT_STYLE));
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

            this.inputFieldsControllers.get(0).validator(new EmailValidator());
            this.inputFieldsControllers.get(1).validator(new NotEmptyStringValidator());
            this.inputFieldsControllers.get(2).validator(new PasswordValidator());
        });
        this.view.getCancelButton().setOnMouseClicked(e -> {
            this.editable.set(false);
            this.view.getButtonsLayout().getChildren().remove(this.view.getCancelButton());
            this.view.getButtonsLayout().getChildren().remove(this.view.getSaveButton());
            this.view.getButtonsLayout().getChildren().add(this.view.getEditButton());

            this.inputFieldsControllers.get(0).validator(null);
            this.inputFieldsControllers.get(1).validator(null);
            this.inputFieldsControllers.get(2).validator(null);

            this.view.getEmailInput().setValue(Session.getInstance().getUser().getEmail());
            this.view.getNameInput().setValue(Session.getInstance().getUser().getUsername());
            this.view.getPasswordInput().setValue("");
        });
    }

    private void bindToCurrentUser() {
        Session.getInstance().addUserChangedListener((newValue) -> {
            if (newValue == null)
                return;
            this.view.getEmailInput().setValue(newValue.getEmail());
            this.view.getNameInput().setValue(newValue.getUsername());
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

    /**
     * @param s
     */
    @Override
    public void bindScene(Scene s) {
        this.view.bindScene(s);
    }
}
