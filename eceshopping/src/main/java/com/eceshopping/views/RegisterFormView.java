
package com.eceshopping.views;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
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
public class RegisterFormView extends GridPane {

    private Text scenetitle;
    private Label name;
    private Label password;
    private Label cPassword;
    private Label email;
    private TextField nameField;
    private TextField emailField;
    private PasswordField pwBox;
    private PasswordField cPwBox;
    private Button registerButton;
    private HBox hbBtn;
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

        this.scenetitle = new Text("Welcome to Ece-Shopping");
        scenetitle.setFont(Font.font("Tahoma", FontWeight.NORMAL, 20));
        this.add(scenetitle, 0, 0, 2, 1);

        this.name = new Label("User Name:");
        this.add(name, 0, 1);

        this.nameField = new TextField();
        this.add(nameField,1, 1);

        this.email = new Label("Email:");
        this.add(email, 0, 2);

        this.emailField = new TextField();
        this.add(emailField, 1, 2);

        this.password = new Label("Password:");
        this.add(password, 0, 3);

        this.pwBox = new PasswordField();
        this.add(pwBox, 1, 3);

        this.cPassword = new Label("Confirm Password:");
        this.add(cPassword, 0, 4);

        this.cPwBox = new PasswordField();
        this.add(cPwBox, 1, 4);

        this.registerButton = new Button("Register");
        this.hbBtn = new HBox(10);
        hbBtn.setAlignment(Pos.BOTTOM_RIGHT);
        hbBtn.getChildren().add(registerButton);
        this.add(hbBtn, 1, 6);
        

        this.hyperlink = new Hyperlink("You already have an account ? Sign in !");
        this.add(hyperlink, 1, 8);
    }

    public Text getScenetitle() {
        return this.scenetitle;
    }

    public void setScenetitle(Text scenetitle) {
        this.scenetitle = scenetitle;
    }

    public Label getName() {
        return this.name;
    }

    public void setName(Label name) {
        this.name = name;
    }

    public Label getPassword() {
        return this.password;
    }

    public void setPassword(Label password) {
        this.password = password;
    }

    public Label getCPassword() {
        return this.cPassword;
    }

    public void setCPassword(Label cPassword) {
        this.cPassword = cPassword;
    }

    public Label getEmail() {
        return this.email;
    }

    public void setEmail(Label email) {
        this.email = email;
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

    public PasswordField getPwBox() {
        return this.pwBox;
    }

    public void setPwBox(PasswordField pwBox) {
        this.pwBox = pwBox;
    }

    public PasswordField getCPwBox() {
        return this.cPwBox;
    }

    public void setCPwBox(PasswordField cPwBox) {
        this.cPwBox = cPwBox;
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

    public RegisterFormView scenetitle(Text scenetitle) {
        setScenetitle(scenetitle);
        return this;
    }

    public RegisterFormView name(Label name) {
        setName(name);
        return this;
    }

    public RegisterFormView password(Label password) {
        setPassword(password);
        return this;
    }

    public RegisterFormView cPassword(Label cPassword) {
        setCPassword(cPassword);
        return this;
    }

    public RegisterFormView email(Label email) {
        setEmail(email);
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

    public RegisterFormView pwBox(PasswordField pwBox) {
        setPwBox(pwBox);
        return this;
    }

    public RegisterFormView cPwBox(PasswordField cPwBox) {
        setCPwBox(cPwBox);
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

}