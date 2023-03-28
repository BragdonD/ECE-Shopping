package com.eceshopping.views.components;

import java.util.List;

import com.eceshopping.views.components.input.InputFieldView;

import javafx.scene.control.Button;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;

public class FormView extends GridPane {
    Button submitButton;
    List<InputFieldView> inputFields;

    public FormView(List<InputFieldView> inputFields, Button submitButton) {
        this.inputFields = inputFields;
        this.submitButton = submitButton;
        initLayout();
    }

    private void initLayout() {
        int i = 0;
        for(InputFieldView inputField : this.inputFields) {
            this.add(inputField, 0, i);
            i++;
        }
        HBox buttonBox = new HBox();
        buttonBox.getChildren().add(this.submitButton);
        this.add(buttonBox, 0, i);
    }

    public Button getSubmitButton() {
        return this.submitButton;
    }

    public void setSubmitButton(Button submitButton) {
        this.submitButton = submitButton;
    }

    public List<InputFieldView> getInputFields() {
        return this.inputFields;
    }

    public void setInputFields(List<InputFieldView> inputFields) {
        this.inputFields = inputFields;
    }

    public FormView inputFields(List<InputFieldView> inputFields) {
        this.inputFields = inputFields;
        return this;
    }
}
