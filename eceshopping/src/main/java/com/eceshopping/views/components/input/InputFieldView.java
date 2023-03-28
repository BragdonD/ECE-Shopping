package com.eceshopping.views.components.input;

import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;

public class InputFieldView extends GridPane {
    private Label labelField;
    private TextField textField;

    public InputFieldView(String label, String placeholder, String type) {
        this.labelField = new Label(label);
        initTextField(type, placeholder);
        initLayout();
    } 

    private void initLayout() {
        this.add(this.labelField, 0, 0);
        this.add(this.textField, 0, 1);
    }

    private void initTextField(String type, String placeholder) {
        if(type.equals("password")) {
            this.textField = new PasswordField();
        } else {
            this.textField = new TextField();
        }
        this.textField.setPromptText(placeholder);
    }

    public TextField getTextField() {
        return this.textField;
    }
}
