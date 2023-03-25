package com.eceshopping.views.components;

import com.eceshopping.styles.AppStyles;
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
public class LoginFormView extends GridPane implements View {

    
    private Label userName;
    private Label password;
    private TextField userTextField;
    private PasswordField PasswordTextField;
    private Button loginButton;
    private HBox hbBtn;
    private Hyperlink hyperlink;
    private Text actiontarget;
    private Text scenetitle;
    private Text errorText;

    /**
     * Default Constructor for the LoginFormView class that creates the login form
     * view for the user.
     */
    public LoginFormView() {

        this.setAlignment(Pos.CENTER);
        this.setHgap(10);
        this.setVgap(10);
        this.setPadding(new Insets(25, 25, 25, 25));

        this.scenetitle = new Text("Welcome Back to Ece-Shopping");
        scenetitle.setFont(Font.font("Tahoma", FontWeight.NORMAL, 20));
        this.add(scenetitle, 0, 0, 2, 1);

        this.userName = new Label("User Name:");
        this.add(userName, 0, 1);

        this.password = new Label("Password:");
        this.add(password, 0, 2);

        this.userTextField = new TextField();
        this.add(userTextField, 1, 1);

        this.PasswordTextField = new PasswordField();
        this.add(PasswordTextField, 1, 2);

        this.loginButton = new Button("Sign in");
        this.hbBtn = new HBox(10);
        hbBtn.setAlignment(Pos.BOTTOM_RIGHT);
        hbBtn.getChildren().add(loginButton);
        this.add(hbBtn, 1, 4);

        this.actiontarget = new Text();
        this.add(actiontarget, 1, 6);

        this.errorText = new Text("No user found with this credentials !");
        this.errorText.setStyle(AppStyles.ERROR_TEXT_STYLE);
        this.errorText.setVisible(false);
        this.add(errorText, 1, 5);

        this.hyperlink = new Hyperlink("Not registered yet ? Click here to register !");
        this.add(hyperlink, 1, 8);
    }

    /**
     * Get the hyperlink for the login form view to the register form view.
     * 
     * @return the action target for the login form view
     */
    public Hyperlink getHyperlink() {
        return hyperlink;
    }

    /**
     * Get the action target for the hyperlink.
     * 
     * @param hyperlink the action target for the hyperlink
     */
    public void setHyperlink(Hyperlink hyperlink) {
        this.hyperlink = hyperlink;
    }

    /**
     * gets the scenetitle for the login form view.
     * 
     * @return the scenetitle for the login form view
     */
    public Text getScenetitle() {
        return this.scenetitle;
    }

    /**
     * Sets the scenetitle for the login form view.
     * 
     * @param scenetitle the scenetitle to set
     */
    public void setScenetitle(Text scenetitle) {
        this.scenetitle = scenetitle;
    }

    /**
     * Get the user name label for the login form view.
     * 
     * @return the user name label for the login form view
     */
    public Label getUserName() {
        return this.userName;
    }

    /**
     * Set the user name label for the login form view.
     * 
     * @param userName the user name label to set
     */
    public void setUserName(Label userName) {
        this.userName = userName;
    }

    /**
     * Get the password label for the login form view.
     * 
     * @return the password label for the login form view
     */
    public Label getPassword() {
        return this.password;
    }

    /**
     * Set the password label for the login form view.
     * 
     * @param pw the password label to set
     */
    public void setPassword(Label password) {
        this.password = password;
    }

    /**
     * Get the user text field for the login form view.
     * 
     * @return the user text field for the login form view
     */
    public TextField getUserTextField() {
        return this.userTextField;
    }

    /**
     * Set the user text field for the login form view.
     * 
     * @param userTextField the user text field to set
     */
    public void setUserTextField(TextField userTextField) {
        this.userTextField = userTextField;
    }

    /**
     * Get the password field for the login form view.
     * 
     * @return the password field for the login form view
     */
    public PasswordField getPasswordTextField() {
        return this.PasswordTextField;
    }

    /**
     * Set the password field for the login form view.
     * 
     * @param PasswordTextField the password field to set
     */
    public void setPasswordTextField(PasswordField PasswordTextField) {
        this.PasswordTextField = PasswordTextField;
    }

    /**
     * Get the button for the login form view.
     * 
     * @return the button for the login form view
     */
    public Button getButton() {
        return this.loginButton;
    }

    /**
     * Set the button for the login form view.
     * 
     * @param btn the button to set
     */
    public void setButton(Button loginButton) {
        this.loginButton = loginButton;
    }

    /**
     * Get the horizontal box for the login form view.
     * 
     * @return the horizontal box for the login form view
     */
    public HBox getHbBtn() {
        return this.hbBtn;
    }

    /**
     * Set the horizontal box for the login form view.
     * 
     * @param hbBtn the horizontal box to set
     */
    public void setHbBtn(HBox hbBtn) {
        this.hbBtn = hbBtn;
    }

    /**
     * Get the action target for the login form view.
     * 
     * @return the action target for the login form view
     */
    public Text getActiontarget() {
        return this.actiontarget;
    }

    /**
     * Set the action target for the login form view.
     * 
     * @param actiontarget the action target to set
     */
    public void setActiontarget(Text actiontarget) {
        this.actiontarget = actiontarget;
    }

    /**
     * Get the error text for the login form view.
     * 
     * @return the error text for the login form view
     */
    public Text getErrorText() {
        return this.errorText;
    }

    /**
     * Set the error text for the login form view.
     * 
     * @param errorText the error text to set
     */
    public void setErrorText(Text errorText) {
        this.errorText = errorText;
    }

    /**
     * Set the scenetitle for the login form view.
     * 
     * @param scenetitle the scenetitle to set
     * @return Scenetitle for the login form view
     */
    public LoginFormView scenetitle(Text scenetitle) {
        setScenetitle(scenetitle);
        return this;
    }

    /**
     * Set the user name label for the login form view.
     * 
     * @param userName the user name label to set
     * @return User name label for the login form view
     */
    public LoginFormView userName(Label userName) {
        setUserName(userName);
        return this;
    }

    /**
     * Set the password label for the login form view.
     * 
     * @param pw the password label to set
     * @return Password label for the login form view
     */
    public LoginFormView password(Label password) {
        this.setPassword(password);
        return this;
    }

    /**
     * Set the user text field for the login form view.
     * 
     * @param userTextField the user text field to set
     * @return User text field for the login form view
     */
    public LoginFormView userTextField(TextField userTextField) {
        setUserTextField(userTextField);
        return this;
    }

    /**
     * Set the password field for the login form view.
     * 
     * @param PasswordTextField the password field to set
     * @return Password field for the login form view
     */
    public LoginFormView PasswordTextField(PasswordField PasswordTextFieldPasswordTextFieldPasswordTextField) {
        setPasswordTextField(PasswordTextField);
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

    public LoginFormView hyperlink(Hyperlink hyperlink) {
        setHyperlink(hyperlink);
        return this;
    }

    public LoginFormView errorText(Text errorText) {
        setErrorText(errorText);
        return this;
    }

    @Override
    public Node getRootNode() {
        return this;
    }
}
