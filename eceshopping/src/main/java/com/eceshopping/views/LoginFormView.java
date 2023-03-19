package com.eceshopping.views;


import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;


public class LoginFormView extends GridPane {

    private Text scenetitle;
    private Label userName;
    private Label pw;
    private TextField userTextField;
    private PasswordField pwBox;
    private Button btn;
    private HBox hbBtn;
    private Text actiontarget;

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

        this.pw = new Label("Password:");
        this.add(pw, 0, 2);

        this.userTextField = new TextField();
        this.add(userTextField, 1, 1);

        this.pwBox = new PasswordField();
        this.add(pwBox, 1, 2);

        this.btn = new Button("Sign in");
        this.hbBtn = new HBox(10);
        hbBtn.setAlignment(Pos.BOTTOM_RIGHT);
        hbBtn.getChildren().add(btn);
        this.add(hbBtn, 1, 4);

        this.actiontarget = new Text();
        this.add(actiontarget, 1, 6);
    }

    public Text getScenetitle() {
        return this.scenetitle;
    }

    public void setScenetitle(Text scenetitle) {
        this.scenetitle = scenetitle;
    }

    public Label getUserName() {
        return this.userName;
    }

    public void setUserName(Label userName) {
        this.userName = userName;
    }

    public Label getPw() {
        return this.pw;
    }

    public void setPw(Label pw) {
        this.pw = pw;
    }

    public TextField getUserTextField() {
        return this.userTextField;
    }

    public void setUserTextField(TextField userTextField) {
        this.userTextField = userTextField;
    }

    public PasswordField getPwBox() {
        return this.pwBox;
    }

    public void setPwBox(PasswordField pwBox) {
        this.pwBox = pwBox;
    }

    public Button getBtn() {
        return this.btn;
    }

    public void setBtn(Button btn) {
        this.btn = btn;
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

    public LoginFormView scenetitle(Text scenetitle) {
        setScenetitle(scenetitle);
        return this;
    }

    public LoginFormView userName(Label userName) {
        setUserName(userName);
        return this;
    }

    public LoginFormView pw(Label pw) {
        setPw(pw);
        return this;
    }

    public LoginFormView userTextField(TextField userTextField) {
        setUserTextField(userTextField);
        return this;
    }

    public LoginFormView pwBox(PasswordField pwBox) {
        setPwBox(pwBox);
        return this;
    }

    public LoginFormView btn(Button btn) {
        setBtn(btn);
        return this;
    }

    public LoginFormView hbBtn(HBox hbBtn) {
        setHbBtn(hbBtn);
        return this;
    }

    public LoginFormView actiontarget(Text actiontarget) {
        setActiontarget(actiontarget);
        return this;
    }

}