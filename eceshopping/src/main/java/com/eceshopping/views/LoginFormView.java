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
public class LoginFormView extends GridPane {

    private Text scenetitle;
    private Label userName;
    private Label password;
    private TextField userTextField;
    private PasswordField pwBox;
    private Button loginButton;
    private HBox hbBtn;
    private Text actiontarget;
    private Hyperlink hyperlink;

    /**
     * Default Constructor for the LoginFormView class that creates the login form
     * view for the user.
     */
    public LoginFormView() {

        this.setAlignment(Pos.CENTER);
        this.setHgap(10);
        this.setVgap(10);
        this.setPadding(new Insets(25, 25, 25, 25));

        this.scenetitle = new Text("Welcome to Ece-Shopping");
        scenetitle.setFont(Font.font("Tahoma", FontWeight.NORMAL, 20));
        this.add(scenetitle, 0, 0, 2, 1);

        this.userName = new Label("User Name:");
        this.add(userName, 0, 1);

        this.password = new Label("Password:");
        this.add(password, 0, 2);

        this.userTextField = new TextField();
        this.add(userTextField, 1, 1);

        this.pwBox = new PasswordField();
        this.add(pwBox, 1, 2);

        this.loginButton = new Button("Sign in");
        this.hbBtn = new HBox(10);
        hbBtn.setAlignment(Pos.BOTTOM_RIGHT);
        hbBtn.getChildren().add(loginButton);
        this.add(hbBtn, 1, 4);

        this.actiontarget = new Text();
        this.add(actiontarget, 1, 6);

        this.hyperlink = new Hyperlink("Go to Eclipse home page");
        this.add(hyperlink, 1, 8);
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


    /**
     * gets the scenetitle for the login form view. 
     * @return the scenetitle for the login form view 
     */
    public Text getScenetitle() {
        return this.scenetitle;
    }

    /**
     * Sets the scenetitle for the login form view.
     * @param scenetitle the scenetitle to set 
     */
    public void setScenetitle(Text scenetitle) {
        this.scenetitle = scenetitle;
    }

    /**
     * Get the user name label for the login form view.
     * @return the user name label for the login form view 
     */
    public Label getUserName() {
        return this.userName;
    }

    /**
     * Set the user name label for the login form view.
     * @param userName the user name label to set 
     */
    public void setUserName(Label userName) {
        this.userName = userName;
    }

    /**
     * Get the password label for the login form view.
     * @return the password label for the login form view
     */
    public Label getPassword() {
        return this.password;
    }

    /**
     * Set the password label for the login form view.
     * @param pw the password label to set 
     */
    public void setPassword(Label password) {
        this.password = password;
    }

    /**
     * Get the user text field for the login form view.
     * @return the user text field for the login form view 
     */
    public TextField getUserTextField() {
        return this.userTextField;
    }

    /**
     * Set the user text field for the login form view.
     * @param userTextField the user text field to set 
     */
    public void setUserTextField(TextField userTextField) {
        this.userTextField = userTextField;
    }

    /**
     * Get the password field for the login form view.
     * @return the password field for the login form view 
     */
    public PasswordField getPwBox() {
        return this.pwBox;
    }
    
    /**
     * Set the password field for the login form view.
     * @param pwBox the password field to set 
     */
    public void setPwBox(PasswordField pwBox) {
        this.pwBox = pwBox;
    }

    /**
     * Get the button for the login form view.
     * @return the button for the login form view 
     */
    public Button getButton() {
        return this.loginButton;
    }

    /**
     * Set the button for the login form view.
     * @param btn the button to set 
     */
    public void setButton(Button loginButton) {
        this.loginButton = loginButton;
    }

    /**
     * Get the horizontal box for the login form view.
     * @return the horizontal box for the login form view 
     */
    public HBox getHbBtn() {
        return this.hbBtn;
    }

    /**
     * Set the horizontal box for the login form view.
     * @param hbBtn the horizontal box to set 
     */
    public void setHbBtn(HBox hbBtn) {
        this.hbBtn = hbBtn;
    }

    /**
     * Get the action target for the login form view.
     * @return the action target for the login form view 
     */
    public Text getActiontarget() {
        return this.actiontarget;
    }

    /**
     * Set the action target for the login form view.
     * @param actiontarget the action target to set 
     */
    public void setActiontarget(Text actiontarget) {
        this.actiontarget = actiontarget;
    }

    /**
     * Set the scenetitle for the login form view.
     * @param scenetitle the scenetitle to set
     * @return Scenetitle for the login form view 
     */
    public LoginFormView scenetitle(Text scenetitle) {
        setScenetitle(scenetitle);
        return this;
    }

    /**
     * Set the user name label for the login form view.
     * @param userName the user name label to set
     * @return User name label for the login form view 
     */
    public LoginFormView userName(Label userName) {
        setUserName(userName);
        return this;
    }

    /**
     * Set the password label for the login form view.
     * @param pw the password label to set
     * @return Password label for the login form view 
     */
    public LoginFormView password(Label password) {
        this.setPassword(password);
        return this;
    }

    /**
     * Set the user text field for the login form view.
     * @param userTextField the user text field to set
     * @return User text field for the login form view 
     */
    public LoginFormView userTextField(TextField userTextField) {
        setUserTextField(userTextField);
        return this;
    }

    /**
     * Set the password field for the login form view.
     * @param pwBox the password field to set
     * @return Password field for the login form view 
     */
    public LoginFormView pwBox(PasswordField pwBox) {
        setPwBox(pwBox);
        return this;
    }
    /**
     * @param btn the btn to set
     * @return button for the login form view
     */
    public LoginFormView btn(Button btn) {
        setButton(btn);
        return this;
    }

    /**
     * @param hbBtn the hbBtn to set
     * @return horizontal box for the login form view
     */
    public LoginFormView hbBtn(HBox hbBtn) {
        setHbBtn(hbBtn);
        return this;
    }
    /**
     * @param actiontarget the actiontarget to set 
     */
    public LoginFormView actiontarget(Text actiontarget) {
        setActiontarget(actiontarget);
        return this;
    }

}

