package com.eceshopping.views.components.input;

import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.layout.ColumnConstraints;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Priority;

public class InputFieldView extends GridPane {
    private Label labelField;
    private TextField textField;

    public InputFieldView(String label, String placeholder, String type) {
        this.labelField = new Label(label);
        initTextField(type, placeholder);
        initLayout();
        ColumnConstraints column1 = new ColumnConstraints();
        column1.setHgrow(Priority.ALWAYS);
        this.getColumnConstraints().add(column1);

        // set the second column width to its preferred size
        ColumnConstraints column2 = new ColumnConstraints();
        column2.setHgrow(Priority.NEVER);
        this.getColumnConstraints().add(column2);
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

    public Label getLabelField() {
        return this.labelField;
    }
}
