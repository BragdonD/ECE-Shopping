package com.eceshopping.views.components;

import java.util.List;

import com.eceshopping.configs.AppText;

import javafx.scene.control.Button;
import javafx.scene.layout.ColumnConstraints;
import javafx.scene.layout.Priority;

/**
 * LoginFormView class that creates the login form view for the user.
 */
public class LoginFormView {

    private FormView formView;
    private InputFieldView emailInputFieldView;
    private InputFieldView passwordInputFieldView;
    private Button submitButton;

    public LoginFormView() {
        this.submitButton = new Button(AppText.LOGIN_FORM_SUBMIT_BUTTON);
        this.emailInputFieldView = new InputFieldView(AppText.LOGIN_FORM_EMAIL_LABEL,
                AppText.LOGIN_FORM_EMAIL_PLACEHOLDER, AppText.INPUT_EMAIL);
        this.passwordInputFieldView = new InputFieldView(AppText.LOGIN_FORM_PASSWORD_LABEL,
                AppText.LOGIN_FORM_PASSWORD_PLACEHOLDER, AppText.INPUT_PASSWORD);
        this.formView = new FormView(List.of(this.emailInputFieldView, this.passwordInputFieldView), this.submitButton);
        ColumnConstraints column1 = new ColumnConstraints();
        column1.setHgrow(Priority.ALWAYS);
        this.formView.getColumnConstraints().add(column1);

        // set the second column width to its preferred size
        ColumnConstraints column2 = new ColumnConstraints();
        column2.setHgrow(Priority.NEVER);
        this.formView.getColumnConstraints().add(column2);
    }

    
    /** 
     * @return FormView
     */
    /*
     * Getters and setters
     */
    public FormView getFormView() {
        return this.formView;
    }

    
    /** 
     * @return InputFieldView
     */
    public InputFieldView getEmailInputFieldView() {
        return this.emailInputFieldView;
    }

    public InputFieldView getPasswordInputFieldView() {
        return this.passwordInputFieldView;
    }

    public Button getSubmitButton() {
        return this.submitButton;
    }

    public void setSubmitButton(Button submitButton) {
        this.submitButton = submitButton;
    }

    public void setFormView(FormView formView) {
        this.formView = formView;
    }

    public void setEmailInputFieldView(InputFieldView emailInputFieldView) {
        this.emailInputFieldView = emailInputFieldView;
    }

    public void setPasswordInputFieldView(InputFieldView passwordInputFieldView) {
        this.passwordInputFieldView = passwordInputFieldView;
    }

    public LoginFormView formView(FormView formView) {
        setFormView(formView);
        return this;
    }

    public LoginFormView emailInputFieldView(InputFieldView emailInputFieldView) {
        setEmailInputFieldView(emailInputFieldView);
        return this;
    }

    public LoginFormView passwordInputFieldView(InputFieldView passwordInputFieldView) {
        setPasswordInputFieldView(passwordInputFieldView);
        return this;
    }

    public LoginFormView submitButton(Button submitButton) {
        setSubmitButton(submitButton);
        return this;
    }
}
