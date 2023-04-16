package com.eceshopping.views.components;

import com.eceshopping.configs.AppStyles;

import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.layout.ColumnConstraints;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Priority;

/*
 * InputFieldView class is a utility class for creating an input field.
 * It takes a label, a placeholder and a type.
 * It will display the label and the input field.
 * It will also handle the layout of the input field.
 * It is used in the LoginPageView and the RegisterPageView.
 */
public class InputFieldView extends GridPane {
    private Label labelField;
    private TextField textField;

    public InputFieldView(String label, String placeholder, String type) {
        this.labelField = new Label(label.toUpperCase());
        initTextField(type, placeholder);
        initLayout();
        ColumnConstraints column1 = new ColumnConstraints();
        column1.setHgrow(Priority.ALWAYS);
        this.getColumnConstraints().add(column1);
        this.labelField.setStyle(AppStyles.LABEL_STYLE);

        // set the second column width to its preferred size
        ColumnConstraints column2 = new ColumnConstraints();
        column2.setHgrow(Priority.NEVER);
        this.getColumnConstraints().add(column2);
    }

    private void initLayout() {
        this.add(this.labelField, 0, 0);
        this.add(this.textField, 0, 1);
    }

    
    /** 
     * @param type
     * @param placeholder
     */
    private void initTextField(String type, String placeholder) {
        if (type.equals("password")) {
            this.textField = new PasswordField();
        } else {
            this.textField = new TextField();
        }
        this.textField.setPromptText(placeholder);
    }

    
    /** 
     * @return TextField
     */
    public TextField getTextField() {
        return this.textField;
    }

    public Label getLabelField() {
        return this.labelField;
    }

    public void setValue(String value) {
        this.textField.setText(value);
    }
}
