package com.eceshopping.views;

import com.eceshopping.configs.AppStyles;
import com.eceshopping.configs.AppText;
import com.eceshopping.views.components.InputFieldView;
import com.eceshopping.views.layouts.UserLayoutView;

import javafx.geometry.HPos;
import javafx.geometry.Pos;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;

public class UserInformationsPage extends UserLayoutView implements View {
    private InputFieldView nameInput;
    private InputFieldView passwordInput;
    private InputFieldView emailInput;
    private Label title;
    private Button editButton;
    private Button saveButton;
    private Button cancelButton;
    private HBox buttonsLayout;
    private GridPane formLayout;

    public UserInformationsPage() {
        this.nameInput = new InputFieldView("Name", "Enter your name", "text");
        this.passwordInput = new InputFieldView("Password", "Enter your password", "password");
        this.emailInput = new InputFieldView("Email", "Enter your email", "text");
        this.formLayout = new GridPane();
        this.title = new Label(AppText.USER_INFORMATIONS_PAGE_TITLE);
        this.title.setStyle(AppStyles.PROFILE_INFORMATION_FORM_TITLE_STYLE);
        GridPane.setHalignment(this.title, HPos.CENTER);
        this.formLayout.add(this.title, 0, 0);
        this.formLayout.add(this.nameInput, 0, 1);
        this.formLayout.add(this.passwordInput, 0, 2);
        this.formLayout.add(this.emailInput, 0, 3);
        this.nameInput.getTextField().setStyle(AppStyles.TEXT_FIELD_STYLE);
        this.passwordInput.getTextField().setStyle(AppStyles.TEXT_FIELD_STYLE);
        this.emailInput.getTextField().setStyle(AppStyles.TEXT_FIELD_STYLE);
        this.editButton = new Button(AppText.EDIT_BUTTON_TEXT);
        this.editButton.setStyle(AppStyles.EDIT_BUTTON_STYLE);
        this.saveButton = new Button(AppText.SAVE_BUTTON_TEXT);
        this.saveButton.setStyle(AppStyles.SAVE_BUTTON_STYLE);
        this.cancelButton = new Button(AppText.CANCEL_BUTTON_TEXT);
        this.cancelButton.setStyle(AppStyles.CANCEL_BUTTON_STYLE);
        this.buttonsLayout = new HBox();
        this.buttonsLayout.getChildren().addAll(this.editButton);
        this.buttonsLayout.setAlignment(Pos.CENTER_RIGHT);
        HBox.setMargin(this.cancelButton, new javafx.geometry.Insets(0, 10, 0, 0));
        this.formLayout.add(this.buttonsLayout, 0, 4);
        this.formLayout.setStyle(AppStyles.PROFILE_INFORMATION_FORM_STYLE);
        this.formLayout.setVgap(10);
        this.formLayout.setAlignment(Pos.CENTER);
        this.setSlot(this.formLayout);
        this.slot.setAlignment(Pos.CENTER);
    }

    /**
     * @return InputFieldView
     */
    public InputFieldView getNameInput() {
        return this.nameInput;
    }

    /**
     * @return InputFieldView
     */
    public InputFieldView getPasswordInput() {
        return this.passwordInput;
    }

    public InputFieldView getEmailInput() {
        return this.emailInput;
    }

    public Button getEditButton() {
        return this.editButton;
    }

    public Button getSaveButton() {
        return this.saveButton;
    }

    public Button getCancelButton() {
        return this.cancelButton;
    }

    public HBox getButtonsLayout() {
        return this.buttonsLayout;
    }

    public GridPane getFormLayout() {
        return this.formLayout;
    }

    @Override
    public Node getRootNode() {
        return this;
    }
}
