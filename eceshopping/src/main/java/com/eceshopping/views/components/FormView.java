package com.eceshopping.views.components;

import java.util.List;

import javafx.scene.control.Button;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;

/*
 * FormView class is a utility class for creating a form.
 * It takes a list of InputFieldView and a submit button.
 * It will display the input fields and the submit button.
 * It will also handle the layout of the form.
 * It is used in the LoginPageView and the RegisterPageView.
 * It is also used in the AdminPageView.
 */
public class FormView extends GridPane {
    Button submitButton;
    List<InputFieldView> inputFields;

    public FormView(List<InputFieldView> inputFields, Button submitButton) {
        this.inputFields = inputFields;
        this.submitButton = submitButton;
        initLayout();
    }

    /*
     * This method will initialize the layout of the form.
     */
    private void initLayout() {
        int i = 0;
        for (InputFieldView inputField : this.inputFields) {
            this.add(inputField, 0, i);
            i++;
        }
        if (this.submitButton != null) {
            HBox buttonBox = new HBox();
            buttonBox.getChildren().add(this.submitButton);
            this.add(buttonBox, 0, i);
        }
    }

    /*
     * get and set methods for the submit button and the input fields.
     */
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
