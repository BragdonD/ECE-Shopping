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
/**
 * Get the password input field view.
 * @return InputFieldView
 */
    public InputFieldView getPasswordInputFieldView() {
        return this.passwordInputFieldView;
    }

    /**
     * Get the submit button.
     * @return Button
     */
    public Button getSubmitButton() {
        return this.submitButton;
    }

    /**
     * Set the submit button.
     * @param submitButton
     */
    public void setSubmitButton(Button submitButton) {
        this.submitButton = submitButton;
    }

    /**
     * Set the form view.
     * @param formView
     */
    public void setFormView(FormView formView) {
        this.formView = formView;
    }

    /**
     * Set the email input field view.
     * @param emailInputFieldView
     */
    public void setEmailInputFieldView(InputFieldView emailInputFieldView) {
        this.emailInputFieldView = emailInputFieldView;
    }

    /**
     * Set the password input field view.
     * @param passwordInputFieldView
     */
    public void setPasswordInputFieldView(InputFieldView passwordInputFieldView) {
        this.passwordInputFieldView = passwordInputFieldView;
    }

    /**
     * Set the form view.
     * @param formView
     * @return
     */
    public LoginFormView formView(FormView formView) {
        setFormView(formView);
        return this;
    }

    /**
     * Set the email input field view.
     * @param emailInputFieldView
     * @return
     */
    public LoginFormView emailInputFieldView(InputFieldView emailInputFieldView) {
        setEmailInputFieldView(emailInputFieldView);
        return this;
    }

    /**
     * Set the password input field view.
     * @param passwordInputFieldView
     * @return
     */
    public LoginFormView passwordInputFieldView(InputFieldView passwordInputFieldView) {
        setPasswordInputFieldView(passwordInputFieldView);
        return this;
    }

    /**
     * Set the submit button.
     * @param submitButton
     * @return
     */
    public LoginFormView submitButton(Button submitButton) {
        setSubmitButton(submitButton);
        return this;
    }
}
