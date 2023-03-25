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

    
    private Label emailLabel;
    private Label passwordLabel;
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

        this.emailLabel = new Label("Email:");
        this.add(emailLabel, 0, 1);

        this.passwordLabel = new Label("Password:");
        this.add(passwordLabel, 0, 2);

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
     * Get the action target for the login form view.
     * 
     * @return action target for the login form view
     */
    public Label getEmailLabel() {
        return this.emailLabel;
    }

    /**
     * Set the email label for the login form view.
     * 
     * @param emailLabel the email label to set
     * @return email label for the login form view
     */
    public void setEmailLabel(Label emailLabel) {
        this.emailLabel = emailLabel;
    }

    /**
     * Get the password label for the login form view.
     * 
     * @return password label for the login form view
     */
    public Label getPasswordLabel() {
        return this.passwordLabel;
    }

    /**
     * Set the password label for the login form view.
     * 
     * @param passwordLabel the password label to set
     * @return password label for the login form view
     */
    public void setPasswordLabel(Label passwordLabel) {
        this.passwordLabel = passwordLabel;
    }

    /**
     * Get the user text field for the login form view.
     * 
     * @return user text field for the login form view
     */
    public TextField getUserTextField() {
        return this.userTextField;
    }

    /**
     * Set the user text field for the login form view.
     * 
     * @param userTextField the user text field to set
     * @return user text field for the login form view
     */
    public void setUserTextField(TextField userTextField) {
        this.userTextField = userTextField;
    }

    /**
     * Get the password text field for the login form view.
     * 
     * @return password text field for the login form view
     */
    public PasswordField getPasswordTextField() {
        return this.PasswordTextField;
    }

    /**
     * Set the password text field for the login form view.
     * 
     * @param PasswordTextField the password text field to set
     * @return password text field for the login form view
     */
    public void setPasswordTextField(PasswordField PasswordTextField) {
        this.PasswordTextField = PasswordTextField;
    }

    /**
     * Get the login button for the login form view.
     * 
     * @return login button for the login form view
     */
    public Button getLoginButton() {
        return this.loginButton;
    }

    /**
     * Set the login button for the login form view.
     * 
     * @param loginButton the login button to set
     * @return login button for the login form view
     */
    public void setLoginButton(Button loginButton) {
        this.loginButton = loginButton;
    }

    /**
     * Get the HBox for the login form view.
     * 
     * @return HBox for the login form view
     */
    public HBox getHbBtn() {
        return this.hbBtn;
    }

    /**
     * Set the HBox for the login form view.
     * 
     * @param hbBtn the HBox to set
     * @return HBox for the login form view
     */
    public void setHbBtn(HBox hbBtn) {
        this.hbBtn = hbBtn;
    }

    /**
     * Get the hyperlink for the login form view.
     * 
     * @return hyperlink for the login form view
     */
    public Hyperlink getHyperlink() {
        return this.hyperlink;
    }

    /**
     * Set the hyperlink for the login form view.
     * 
     * @param hyperlink the hyperlink to set
     * @return hyperlink for the login form view
     */
    public void setHyperlink(Hyperlink hyperlink) {
        this.hyperlink = hyperlink;
    }

    /**
     * Get the action target for the login form view.
     * 
     * @return action target for the login form view
     */
    public Text getActiontarget() {
        return this.actiontarget;
    }

    /**
     * Set the action target for the login form view.
     * 
     * @param actiontarget the action target to set
     * @return action target for the login form view
     */
    public void setActiontarget(Text actiontarget) {
        this.actiontarget = actiontarget;
    }

    /**
     * Get the scene title for the login form view.
     * 
     * @return scene title for the login form view
     */
    public Text getScenetitle() {
        return this.scenetitle;
    }

    /**
     * Set the scene title for the login form view.
     * 
     * @param scenetitle the scene title to set
     * @return scene title for the login form view
     */
    public void setScenetitle(Text scenetitle) {
        this.scenetitle = scenetitle;
    }

    /**
     * Get the error text for the login form view.
     * 
     * @return error text for the login form view
     */
    public Text getErrorText() {
        return this.errorText;
    }

    /**
     * Set the error text for the login form view.
     * 
     * @param errorText the error text to set
     * @return error text for the login form view
     */
    public void setErrorText(Text errorText) {
        this.errorText = errorText;
    }

    /**
     * Set the email label for the login form view.
     * 
     * @param emailLabel the email label to set
     * @return email label for the login form view
     */
    public LoginFormView emailLabel(Label emailLabel) {
        setEmailLabel(emailLabel);
        return this;
    }

    /**
     * Set the password label for the login form view.
     * 
     * @param passwordLabel the password label to set
     * @return password label for the login form view
     */
    public LoginFormView passwordLabel(Label passwordLabel) {
        setPasswordLabel(passwordLabel);
        return this;
    }

    /**
     * Set the user text field for the login form view.
     * 
     * @param userTextField the user text field to set
     * @return user text field for the login form view
     */
    public LoginFormView userTextField(TextField userTextField) {
        setUserTextField(userTextField);
        return this;
    }

    /**
     * Set the password text field for the login form view.
     * 
     * @param PasswordTextField the password text field to set
     * @return password text field for the login form view
     */
    public LoginFormView PasswordTextField(PasswordField PasswordTextField) {
        setPasswordTextField(PasswordTextField);
        return this;
    }

    /**
     * Set the login button for the login form view.
     * 
     * @param loginButton the login button to set
     * @return login button for the login form view
     */
    public LoginFormView loginButton(Button loginButton) {
        setLoginButton(loginButton);
        return this;
    }

    /**
     * Set the HBox button for the login form view.
     * 
     * @param hbBtn the HBox button to set
     * @return HBox button for the login form view
     */
    public LoginFormView hbBtn(HBox hbBtn) {
        setHbBtn(hbBtn);
        return this;
    }

    /**
     * Set the hyperlink for the login form view.
     * 
     * @param hyperlink the hyperlink to set
     * @return hyperlink for the login form view
     */
    public LoginFormView hyperlink(Hyperlink hyperlink) {
        setHyperlink(hyperlink);
        return this;
    }

    /**
     * Set the action target for the login form view.
     * 
     * @param actiontarget the action target to set
     * @return action target for the login form view
     */
    public LoginFormView actiontarget(Text actiontarget) {
        setActiontarget(actiontarget);
        return this;
    }

    /**
     * Set the scene title for the login form view.
     * 
     * @param scenetitle the scene title to set
     * @return scene title for the login form view
     */
    public LoginFormView scenetitle(Text scenetitle) {
        setScenetitle(scenetitle);
        return this;
    }

    /**
     * Set the error text for the login form view.
     * 
     * @param errorText the error text to set
     * @return error text for the login form view
     */
    public LoginFormView errorText(Text errorText) {
        setErrorText(errorText);
        return this;
    }
    
    /**
     * Set the grid pane for the login form view.
     * 
     * @param grid the grid to set
     * @return grid pane for the login form view
     */
    @Override
    public Node getRootNode() {
        return this;
    }
}
