
package com.eceshopping.views.components;

import java.util.List;

import com.eceshopping.configs.AppText;

import javafx.scene.control.Button;
import javafx.scene.layout.ColumnConstraints;
import javafx.scene.layout.Priority;

/**
 * REGISTERFormView class that creates the REGISTER form view for the user.
 */
public class RegisterFormView {
    private FormView formView;
    private InputFieldView nameInputFieldView;
    private InputFieldView emailInputFieldView;
    private InputFieldView passwordInputFieldView;
    private Button submitButton;

    public RegisterFormView() {
        this.submitButton = new Button(AppText.REGISTER_FORM_SUBMIT_BUTTON);
        this.nameInputFieldView = new InputFieldView(AppText.REGISTER_FORM_NAME_LABEL, AppText.REGISTER_FORM_NAME_PLACEHOLDER, AppText.INPUT_NAME);
        this.emailInputFieldView = new InputFieldView(AppText.REGISTER_FORM_EMAIL_LABEL, AppText.REGISTER_FORM_EMAIL_PLACEHOLDER, AppText.INPUT_EMAIL);
        this.passwordInputFieldView = new InputFieldView(AppText.REGISTER_FORM_PASSWORD_LABEL, AppText.REGISTER_FORM_PASSWORD_PLACEHOLDER, AppText.INPUT_PASSWORD);
        this.formView = new FormView(List.of(this.nameInputFieldView, this.emailInputFieldView, this.passwordInputFieldView), this.submitButton);
        ColumnConstraints column1 = new ColumnConstraints();
        column1.setHgrow(Priority.ALWAYS);
        this.formView.getColumnConstraints().add(column1);

        // set the second column width to its preferred size
        ColumnConstraints column2 = new ColumnConstraints();
        column2.setHgrow(Priority.NEVER);
        this.formView.getColumnConstraints().add(column2);
    }


    public FormView getFormView() {
        return this.formView;
    }

    public void setFormView(FormView formView) {
        this.formView = formView;
    }

    public InputFieldView getNameInputFieldView() {
        return this.nameInputFieldView;
    }

    public void setNameInputFieldView(InputFieldView nameInputFieldView) {
        this.nameInputFieldView = nameInputFieldView;
    }

    public InputFieldView getEmailInputFieldView() {
        return this.emailInputFieldView;
    }

    public void setEmailInputFieldView(InputFieldView emailInputFieldView) {
        this.emailInputFieldView = emailInputFieldView;
    }

    public InputFieldView getPasswordInputFieldView() {
        return this.passwordInputFieldView;
    }

    public void setPasswordInputFieldView(InputFieldView passwordInputFieldView) {
        this.passwordInputFieldView = passwordInputFieldView;
    }

    public Button getSubmitButton() {
        return this.submitButton;
    }

    public void setSubmitButton(Button submitButton) {
        this.submitButton = submitButton;
    }


    public RegisterFormView formView(FormView formView) {
        setFormView(formView);
        return this;
    }

    public RegisterFormView nameInputFieldView(InputFieldView nameInputFieldView) {
        setNameInputFieldView(nameInputFieldView);
        return this;
    }

    public RegisterFormView emailInputFieldView(InputFieldView emailInputFieldView) {
        setEmailInputFieldView(emailInputFieldView);
        return this;
    }

    public RegisterFormView passwordInputFieldView(InputFieldView passwordInputFieldView) {
        setPasswordInputFieldView(passwordInputFieldView);
        return this;
    }

    public RegisterFormView submitButton(Button submitButton) {
        setSubmitButton(submitButton);
        return this;
    }

}