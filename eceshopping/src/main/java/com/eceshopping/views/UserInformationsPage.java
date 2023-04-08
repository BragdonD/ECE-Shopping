package com.eceshopping.views;

import com.eceshopping.configs.AppText;
import com.eceshopping.views.components.InputFieldView;
import com.eceshopping.views.layouts.UserLayoutView;

import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.text.Text;

public class UserInformationsPage extends UserLayoutView implements View {
    private InputFieldView nameInput;
    private InputFieldView passwordInput;
    private InputFieldView emailInput;
    private Text title;
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
        this.title = new Text(AppText.USER_INFORMATIONS_PAGE_TITLE);
        this.formLayout.add(this.title, 0, 0);
        this.formLayout.add(this.nameInput, 0, 1);
        this.formLayout.add(this.passwordInput, 0, 2);
        this.formLayout.add(this.emailInput, 0, 3);
        this.editButton = new Button(AppText.EDIT_BUTTON_TEXT);
        this.saveButton = new Button(AppText.SAVE_BUTTON_TEXT);
        this.cancelButton = new Button(AppText.CANCEL_BUTTON_TEXT);
        this.buttonsLayout = new HBox();
        this.buttonsLayout.getChildren().addAll(this.editButton);
        this.formLayout.add(this.buttonsLayout, 0, 4);
        this.setSlot(this.formLayout);
    }

    public InputFieldView getNameInput() {
        return this.nameInput;
    }

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

    @Override
    public Node getRootNode() {
        return this;
    }
}
