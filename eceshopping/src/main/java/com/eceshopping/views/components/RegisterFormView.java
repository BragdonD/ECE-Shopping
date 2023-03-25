
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

/**
 * LoginFormView class that creates the login form view for the user.
 */
public class RegisterFormView extends GridPane implements View{

    private Label userNameLabel;
    private Label passwordLabel;
    private Label cPasswordLabel;
    private Label emailLabel;
    private TextField nameField;
    private TextField emailField;
    private PasswordField pwField;
    private PasswordField cPwField;
    private Button registerButton;
    private HBox hbBtn;
    private Text viewTitle;
    private Text actiontarget;
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
        viewTitle.setFont(Font.font("Tahoma", FontWeight.NORMAL, 20));
        this.add(viewTitle, 0, 0, 2, 1);

        this.userNameLabel = new Label("User Name:");
        this.add(userNameLabel, 0, 1);

        this.nameField = new TextField();
        this.add(nameField,1, 1);

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

        this.registerButton = new Button("Register");
        this.hbBtn = new HBox(10);
        hbBtn.setAlignment(Pos.BOTTOM_RIGHT);
        hbBtn.getChildren().add(registerButton);
        this.add(hbBtn, 1, 6);
        

        this.hyperlink = new Hyperlink("You already have an account ? Sign in !");
        this.add(hyperlink, 1, 8);
    }

    public Text getViewTitle() {
        return this.viewTitle;
    }
    /**
    * @param scenetitle the scenetitle to set

     */
    public void setViewTitle(Text scenetitle) {
        this.viewTitle = scenetitle;
    }

    public Label getUserNameLabel() {
        return this.userNameLabel;
    }

    public void setUserNameLabel(Label name) {
        this.userNameLabel = name;
    }

    public Label getPasswordLabel() {
        return this.passwordLabel;
    }

    public void setPasswordLabel(Label password) {
        this.passwordLabel = password;
    }

    public Label getCPasswordLabel() {
        return this.cPasswordLabel;
    }

    public void setCPasswordLabel(Label cPassword) {
        this.cPasswordLabel = cPassword;
    }

    public Label getEmailLabel() {
        return this.emailLabel;
    }

    public void setEmailLabel(Label email) {
        this.emailLabel = email;
    }

    public TextField getNameField() {
        return this.nameField;
    }

    public void setNameField(TextField nameField) {
        this.nameField = nameField;
    }

    public TextField getEmailField() {
        return this.emailField;
    }

    public void setEmailField(TextField emailField) {
        this.emailField = emailField;
    }

    public PasswordField getPwField() {
        return this.pwField;
    }

    public void setPwField(PasswordField pwBox) {
        this.pwField = pwBox;
    }

    public PasswordField getCPwField() {
        return this.cPwField;
    }

    public void setCPwField(PasswordField cPwBox) {
        this.cPwField = cPwBox;
    }

    public Button getRegisterButton() {
        return this.registerButton;
    }

    public void setRegisterButton(Button registerButton) {
        this.registerButton = registerButton;
    }

    public HBox getHbBtn() {
        return this.hbBtn;
    }

    public void setHbBtn(HBox hbBtn) {
        this.hbBtn = hbBtn;
    }

    public Text getActiontarget() {
        return this.actiontarget;
    }

    public void setActiontarget(Text actiontarget) {
        this.actiontarget = actiontarget;
    }

    public RegisterFormView viewTitle(Text scenetitle) {
        setViewTitle(scenetitle);
        return this;
    }

    public RegisterFormView userNameLabel(Label name) {
        setUserNameLabel(name);
        return this;
    }

    public RegisterFormView passwordLabel(Label password) {
        setPasswordLabel(password);
        return this;
    }

    public RegisterFormView cPassword(Label cPassword) {
        setCPasswordLabel(cPassword);
        return this;
    }

    public RegisterFormView email(Label email) {
        setEmailLabel(email);
        return this;
    }

    public RegisterFormView nameField(TextField nameField) {
        setNameField(nameField);
        return this;
    }

    public RegisterFormView emailField(TextField emailField) {
        setEmailField(emailField);
        return this;
    }

    public RegisterFormView pwBox(PasswordField pwField) {
        setPwField(pwField);
        return this;
    }

    public RegisterFormView cPwBox(PasswordField cPwField) {
        setCPwField(cPwField);
        return this;
    }

    public RegisterFormView loginButton(Button loginButton) {
        setRegisterButton(loginButton);
        return this;
    }

    public RegisterFormView hbBtn(HBox hbBtn) {
        setHbBtn(hbBtn);
        return this;
    }

    public RegisterFormView actiontarget(Text actiontarget) {
        setActiontarget(actiontarget);
        return this;
    }

    /**
     * Get the hyperlink for the login form view to the register form view.
     * @return the action target for the login form view
     */
    public Hyperlink getHyperlink() {
        return hyperlink;
    }
    /**
     * Get the action target for the hyperlink.
     * @param hyperlink the action target for the hyperlink
     */
    public void setHyperlink(Hyperlink hyperlink) {
        this.hyperlink = hyperlink;
    }

    @Override
    public Node getRootNode() {
        return this;
    }
}