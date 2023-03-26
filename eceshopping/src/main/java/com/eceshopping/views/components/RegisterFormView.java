
package com.eceshopping.views.components;

import com.eceshopping.views.View;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.control.Hyperlink;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.scene.text.TextAlignment;

/**
 * LoginFormView class that creates the login form view for the user.
 */
public class RegisterFormView extends GridPane implements View {

    private Label userNameLabel;
    private Label passwordLabel;
    private Label cPasswordLabel;
    private Label emailLabel;
    private Label helpLabel;
    private TextField nameField;
    private TextField emailField;
    private PasswordField pwField;
    private PasswordField cPwField;
    private Button registerButton;
    private HBox hbBtn;
    private Text viewTitle;
    private Text actiontarget;
    private Text passwordHelpNumber;
    private Text passwordHelpMajLetter;
    private Text passwordHelpMinLetter;
    private Text passwordHelpSpecial;
    private Text passwordHelpLength;
    private Text errorMessageText;
    private Hyperlink hyperlink;

    /**
     * Default Constructor for the LoginFormView class that creates the login form
     * view for the user.
     */
    public RegisterFormView() {
        this.setAlignment(Pos.CENTER);
        this.setHgap(10);
        this.setVgap(10);
        this.setPadding(new Insets(25, 25, 25, 25));
        
        this.viewTitle = new Text("Welcome to Ece-Shopping");
        this.viewTitle.setTextAlignment(TextAlignment.CENTER);
        this.viewTitle.setFont(Font.font("Tahoma", FontWeight.NORMAL, 20));
        this.add(viewTitle, 0, 0, 2, 1);

        this.userNameLabel = new Label("User Name:");
        this.add(userNameLabel, 0, 1);

        this.nameField = new TextField();
        this.add(nameField, 1, 1);

        this.emailLabel = new Label("Email:");
        this.add(emailLabel, 0, 2);

        this.emailField = new TextField();
        this.add(emailField, 1, 2);

        this.passwordLabel = new Label("Password:");
        this.add(passwordLabel, 0, 3);

        this.pwField = new PasswordField();
        this.add(pwField, 1, 3);

        this.cPasswordLabel = new Label("Confirm Password:");
        this.add(cPasswordLabel, 0, 4);

        this.cPwField = new PasswordField();
        this.add(cPwField, 1, 4);

        this.helpLabel = new Label("Password help:");
        this.add(helpLabel, 0, 5);

        this.passwordHelpNumber = new Text("[0-9] : 1 number is required");
        this.add(passwordHelpNumber, 1, 5);

        this.passwordHelpMajLetter = new Text("[A-Z] : 1 uppercase letter is required");
        this.add(passwordHelpMajLetter, 1, 6);

        this.passwordHelpMinLetter = new Text("[a-z] : 1 lowercase letter is required");
        this.add(passwordHelpMinLetter, 1, 7);

        this.passwordHelpSpecial = new Text("[!@#$%^&*] : 1 special character is required");
        this.add(passwordHelpSpecial, 1, 8);

        this.passwordHelpLength = new Text("[length] : 8 characters minimum");
        this.add(passwordHelpLength, 1, 9);

        this.registerButton = new Button("Register");
        this.hbBtn = new HBox(10);
        hbBtn.setAlignment(Pos.BOTTOM_RIGHT);
        hbBtn.getChildren().add(registerButton);
        this.add(hbBtn, 1, 10);

        this.errorMessageText = new Text("An account already exists with this email address");
        this.add(errorMessageText, 1, 11);

        this.hyperlink = new Hyperlink("You already have an account ? Sign in !");
        this.add(hyperlink, 1, 12);
    }

    /**
     * Get the user name label.
     * 
     * @return the user name label.
     */
    public Label getUserNameLabel() {
        return this.userNameLabel;
    }

    /**
     * Set the user name label.
     * 
     * @param userNameLabel the userNameLabel to set
     */
    public void setUserNameLabel(Label userNameLabel) {
        this.userNameLabel = userNameLabel;
    }

    /**
     * Get the password label.
     * 
     * @return the password label.
     */
    public Label getPasswordLabel() {
        return this.passwordLabel;
    }

    /**
     * Set the password label.
     * 
     * @param passwordLabel the passwordLabel to set
     */
    public void setPasswordLabel(Label passwordLabel) {
        this.passwordLabel = passwordLabel;
    }

    /**
     * Get the Confirmesd password label.
     * 
     * @return the Confirmed password label.
     */
    public Label getCPasswordLabel() {
        return this.cPasswordLabel;
    }

    /**
     * Set the Confirmed password label.
     * 
     * @param cPasswordLabel the cPasswordLabel to set
     */
    public void setCPasswordLabel(Label cPasswordLabel) {
        this.cPasswordLabel = cPasswordLabel;
    }

    /**
     * Get the email label.
     * 
     * @return the email label.
     */
    public Label getEmailLabel() {
        return this.emailLabel;
    }

    /**
     * Set the email label.
     * 
     * @param emailLabel the email Label to set
     */
    public void setEmailLabel(Label emailLabel) {
        this.emailLabel = emailLabel;
    }

    /**
     * Get the name field.
     * 
     * @return the name field.
     */
    public TextField getNameField() {
        return this.nameField;
    }

    /**
     * Set the name field.
     * 
     * @param nameField the nameField to set
     */
    public void setNameField(TextField nameField) {
        this.nameField = nameField;
    }

    /**
     * Get the email field.
     * 
     * @return the email field.
     */
    public TextField getEmailField() {
        return this.emailField;
    }

    /**
     * Set the email field.
     * 
     * @param emailField the emailField to set
     */
    public void setEmailField(TextField emailField) {
        this.emailField = emailField;
    }

    /**
     * Get the password field.
     * 
     * @return the password field.
     */
    public PasswordField getPwField() {
        return this.pwField;
    }

    /**
     * Set the password field.
     * 
     * @param pwField the pwField to set
     */
    public void setPwField(PasswordField pwField) {
        this.pwField = pwField;
    }

    /**
     * Get the confirmed password field.
     * 
     * @return the confirmed password field.
     */
    public PasswordField getCPwField() {
        return this.cPwField;
    }

    /**
     * Set the confirmed password field.
     * 
     * @param cPwField the cPwField to set
     */
    public void setCPwField(PasswordField cPwField) {
        this.cPwField = cPwField;
    }

    /**
     * get the register button.
     * 
     * @return the register button.
     */
    public Button getRegisterButton() {
        return this.registerButton;
    }

    /**
     * Set the register button.
     * 
     * @param registerButton the registerButton to set
     */
    public void setRegisterButton(Button registerButton) {
        this.registerButton = registerButton;
    }

    /**
     * get the horizontal Box.
     * 
     * @return the horizontal Box.
     */
    public HBox getHbBtn() {
        return this.hbBtn;
    }

    /**
     * Set the horizontal Box.
     * 
     * @param hbBtn the hbBtn to set
     */
    public void setHbBtn(HBox hbBtn) {
        this.hbBtn = hbBtn;
    }

    /**
     * get the Title View.
     * 
     * @return the Title View.
     */
    public Text getViewTitle() {
        return this.viewTitle;
    }

    /**
     * Set the Title View.
     * 
     * @param viewTitle the viewTitle to set
     */
    public void setViewTitle(Text viewTitle) {
        this.viewTitle = viewTitle;
    }

    /**
     * get the action target.
     * 
     * @return the action target.
     */
    public Text getActiontarget() {
        return this.actiontarget;
    }

    /**
     * Set the action target.
     * 
     * @param actiontarget the action target to set
     */
    public void setActiontarget(Text actiontarget) {
        this.actiontarget = actiontarget;
    }

    /**
     * get the password help number.
     * 
     * @return the password help number.
     */
    public Text getPasswordHelpNumber() {
        return this.passwordHelpNumber;
    }

    /**
     * Set the password help number.
     * 
     * @param passwordHelpNumber the password HelpNumber to set
     */
    public void setPasswordHelpNumber(Text passwordHelpNumber) {
        this.passwordHelpNumber = passwordHelpNumber;
    }

    /**
     * get the password help maj letter.
     * 
     * @return the password help maj letter.
     */
    public Text getPasswordHelpMajLetter() {
        return this.passwordHelpMajLetter;
    }

    /**
     * Set the password help maj letter.
     * 
     * @param passwordHelpMajLetter the password HelpMajLetter to set
     */
    public void setPasswordHelpMajLetter(Text passwordHelpMajLetter) {
        this.passwordHelpMajLetter = passwordHelpMajLetter;
    }

    /**
     * get the password help min letter.
     * 
     * @return the password help min letter.
     */
    public Text getPasswordHelpMinLetter() {
        return this.passwordHelpMinLetter;
    }

    /**
     * Set the password help min letter.
     * 
     * @param passwordHelpMinLetter the password HelpMinLetter to set
     */
    public void setPasswordHelpMinLetter(Text passwordHelpMinLetter) {
        this.passwordHelpMinLetter = passwordHelpMinLetter;
    }

    /**
     * get the password help special.
     * 
     * @return the password help special.
     */
    public Text getPasswordHelpSpecial() {
        return this.passwordHelpSpecial;
    }

    /**
     * Set the password help special.
     * 
     * @param passwordHelpSpecial the password HelpSpecial to set
     */
    public void setPasswordHelpSpecial(Text passwordHelpSpecial) {
        this.passwordHelpSpecial = passwordHelpSpecial;
    }

    /**
     * get the password help length.
     * 
     * @return the password help length.
     */
    public Text getPasswordHelpLength() {
        return this.passwordHelpLength;
    }

    /**
     * Set the password help length.
     * 
     * @param passwordHelpLength the password HelpLength to set
     */
    public void setPasswordHelpLength(Text passwordHelpLength) {
        this.passwordHelpLength = passwordHelpLength;
    }

    /**
     * get the password hyper link.
     * 
     * @return the hyper link.
     */
    public Hyperlink getHyperlink() {
        return this.hyperlink;
    }

    /**
     * get the error message text.
     * 
     * @return the error message text.
     */
    public Text getErrorMessageText() {
        return this.errorMessageText;
    }

    /**
     * Set the error message text.
     * 
     * @param errorMessageText the error message text to set
     */
    public void setErrorMessageText(Text errorMessageText) {
        this.errorMessageText = errorMessageText;
    }

    /**
     * Set the hyper link.
     * 
     * @param hyperlink the hyper link to set
     */
    public void setHyperlink(Hyperlink hyperlink) {
        this.hyperlink = hyperlink;
    }

    /**
     * Set the user name label the register form view.
     * 
     * @param userNameLabel the user name label to set
     * @return the register form view
     */
    public RegisterFormView userNameLabel(Label userNameLabel) {
        setUserNameLabel(userNameLabel);
        return this;
    }

    /**
     * Set the password label the register form view.
     * 
     * @param passwordLabel the password label to set
     * @return the register form view
     */
    public RegisterFormView passwordLabel(Label passwordLabel) {
        setPasswordLabel(passwordLabel);
        return this;
    }

    /**
     * Set the confirm password label the register form view.
     * 
     * @param cPasswordLabel the confirm password label to set
     * @return the register form view
     */
    public RegisterFormView cPasswordLabel(Label cPasswordLabel) {
        setCPasswordLabel(cPasswordLabel);
        return this;
    }

    /**
     * Set the email label the register form view.
     * 
     * @param emailLabel the email label to set
     * @return the register form view
     */

    public RegisterFormView emailLabel(Label emailLabel) {
        setEmailLabel(emailLabel);
        return this;
    }

    /**
     * Set the name field the register form view.
     * 
     * @param nameField the name Field to set
     * @return the register form view
     */

    public RegisterFormView nameField(TextField nameField) {
        setNameField(nameField);
        return this;
    }

    /**
     * Set the email field the register form view.
     * 
     * @param emailField the email Field to set
     * @return the register form view
     */
    public RegisterFormView emailField(TextField emailField) {
        setEmailField(emailField);
        return this;
    }

    /**
     * Set the Password field the register form view.
     * 
     * @param pwfield the user name Field to set
     * @return the register form view
     */
    public RegisterFormView pwField(PasswordField pwField) {
        setPwField(pwField);
        return this;
    }

    /**
     * Set the confirm Password field the register form view.
     * 
     * @param cPwField the confirm Password Field to set
     * @return the register form view
     */
    public RegisterFormView cPwField(PasswordField cPwField) {
        setCPwField(cPwField);
        return this;
    }

    /**
     * Set the register button the register form view.
     * 
     * @param registerButton the register button to set
     * @return the register form view
     */
    public RegisterFormView registerButton(Button registerButton) {
        setRegisterButton(registerButton);
        return this;
    }

    /**
     * Set the button the register form view.
     * 
     * @param hbBtn the cancel button to set
     * @return the register form view
     */
    public RegisterFormView hbBtn(HBox hbBtn) {
        setHbBtn(hbBtn);
        return this;
    }


    public RegisterFormView viewTitle(Text viewTitle) {
        setViewTitle(viewTitle);
        return this;
    }
    
    
    public RegisterFormView actiontarget(Text actiontarget) {
        setActiontarget(actiontarget);
        return this;
    }

    /**
     * Set the password help number.
     * 
     * @param passwordHelpNumber the password HelpNumber to set
     * @return the register form view
     */
    public RegisterFormView passwordHelpNumber(Text passwordHelpNumber) {
        setPasswordHelpNumber(passwordHelpNumber);
        return this;
    }

    /**
     * Set the password help maj letter.
     * 
     * @param passwordHelpMajLetter the password HelpMajLetter to set
     * @return the register form view
     */
    public RegisterFormView passwordHelpMajLetter(Text passwordHelpMajLetter) {
        setPasswordHelpMajLetter(passwordHelpMajLetter);
        return this;
    }

    /**
     * Set the password help min letter.
     * 
     * @param passwordHelpMinLetter the password HelpMinLetter to set
     * @return the register form view
     */
    public RegisterFormView passwordHelpMinLetter(Text passwordHelpMinLetter) {
        setPasswordHelpMinLetter(passwordHelpMinLetter);
        return this;
    }

    /**
     * Set the password help special.
     * 
     * @param passwordHelpSpecial the password HelpSpecial to set
     * @return the register form view
     */
    public RegisterFormView passwordHelpSpecial(Text passwordHelpSpecial) {
        setPasswordHelpSpecial(passwordHelpSpecial);
        return this;
    }

    /**
     * Set the password help length.
     * 
     * @param passwordHelpLength the password HelpLength to set
     * @return the register form view
     */
    public RegisterFormView passwordHelpLength(Text passwordHelpLength) {
        setPasswordHelpLength(passwordHelpLength);
        return this;
    }

    /**
     * Set the hyper link.
     * 
     * @param hyperlink the hyper link to set
     * @return the register form view
     */
    public RegisterFormView hyperlink(Hyperlink hyperlink) {
        setHyperlink(hyperlink);
        return this;
    }

    /**
     * Set the error message text.
     * 
     * @param errorMessageText the error message text to set
     * @return the register form view
     */
    public RegisterFormView errorMessageText(Text errorMessageText) {
        setErrorMessageText(errorMessageText);
        return this;
    }

    @Override
    public Node getRootNode() {
        return this;
    }
}