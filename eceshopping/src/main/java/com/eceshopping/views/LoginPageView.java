package com.eceshopping.views;

import com.eceshopping.views.components.LoginFormView;
import com.eceshopping.configs.AppStyles;
import com.eceshopping.configs.AppText;
import com.eceshopping.views.components.InputFieldView;

import javafx.geometry.HPos;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.ColumnConstraints;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.StackPane;
import javafx.scene.text.Text;
import javafx.scene.text.TextAlignment;

public class LoginPageView extends StackPane implements View {
    private GridPane gridPane;
    private LoginFormView loginFormView;
    private Text title;
    private GridPane RegisterBoxLayout;
    private Button RegisterButton;
    private Label RegisterLabel;
    private Insets margin;
    
    public LoginPageView() {
        this.gridPane = new GridPane();
        this.gridPane.setVgap(10);
        this.gridPane.setHgap(10);
        this.gridPane.setAlignment(Pos.CENTER);
        ColumnConstraints column1 = new ColumnConstraints();
        column1.setHalignment(HPos.CENTER); // center the elements in the column
        gridPane.getColumnConstraints().addAll(column1);

        setupTitle();
        setupLoginForm();
        setupRegisterBox();

        this.gridPane.add(this.RegisterBoxLayout, 0, 2);

        this.margin = new Insets(10, 10, 10, 10);
        
        this.gridPane.setPrefSize(400, 400);
        this.getChildren().add(this.gridPane);
        this.setAlignment(Pos.CENTER);
        setMargin(this.gridPane, this.margin);
    }

    private void setupRegisterBox() {
        this.RegisterBoxLayout = new GridPane();
        this.RegisterBoxLayout.setVgap(10);
        this.RegisterBoxLayout.setHgap(10);
        this.RegisterButton = new Button(AppText.LOGIN_FORM_REGISTER_BUTTON);
        this.RegisterButton.setPrefWidth(200);
        this.RegisterLabel = new Label(AppText.LOGIN_FORM_REGISTER_LABEL);
        this.RegisterLabel.setPrefWidth(200);
        this.RegisterLabel.setAlignment(Pos.CENTER);
        this.RegisterBoxLayout.add(this.RegisterLabel, 0, 0);
        this.RegisterBoxLayout.add(this.RegisterButton, 0, 1);
        this.RegisterBoxLayout.setAlignment(Pos.CENTER);
    }

    private void setupTitle() {
        this.title = new Text(AppText.LOGIN_PAGE_TITLE);
        this.title.setTextAlignment(TextAlignment.CENTER);
        this.gridPane.add(this.title, 0, 0);
        this.title.setStyle(AppStyles.TITLE_STYLE); 
    }

    private void setupLoginForm() {
        this.loginFormView = new LoginFormView();
        this.gridPane.setStyle(AppStyles.LOGIN_FORM_STYLE);
        this.loginFormView.getFormView().setStyle(AppStyles.FORM_STYLE);
        this.loginFormView.getFormView().setPrefSize(300, 300);
        this.loginFormView.getFormView().setPadding(new Insets(10, 10, 10, 10));
        this.loginFormView.getFormView().setVgap(10);
        this.gridPane.add(this.loginFormView.getFormView(), 0, 1);
        for(InputFieldView input : this.loginFormView.getFormView().getInputFields()) {
            input.getLabelField().setStyle(AppStyles.LABEL_STYLE);
            input.getTextField().setStyle(AppStyles.TEXT_FIELD_STYLE);
        }
        this.loginFormView.getSubmitButton().setStyle(AppStyles.SUBMIT_BUTTON_STYLE);
        this.loginFormView.getSubmitButton().setPrefWidth(300);
    }


    public GridPane getGridPane() {
        return this.gridPane;
    }

    public void setGridPane(GridPane gridPane) {
        this.gridPane = gridPane;
    }

    public LoginFormView getLoginFormView() {
        return this.loginFormView;
    }

    public void setLoginFormView(LoginFormView loginFormView) {
        this.loginFormView = loginFormView;
    }

    public Text getTitle() {
        return this.title;
    }

    public void setTitle(Text title) {
        this.title = title;
    }

    public GridPane getRegisterBoxLayout() {
        return this.RegisterBoxLayout;
    }

    public void setRegisterBoxLayout(GridPane RegisterBoxLayout) {
        this.RegisterBoxLayout = RegisterBoxLayout;
    }

    public Button getRegisterButton() {
        return this.RegisterButton;
    }

    public void setRegisterButton(Button RegisterButton) {
        this.RegisterButton = RegisterButton;
    }

    public Label getRegisterLabel() {
        return this.RegisterLabel;
    }

    public void setRegisterLabel(Label RegisterLabel) {
        this.RegisterLabel = RegisterLabel;
    }

    public Insets getMargin() {
        return this.margin;
    }

    public void setMargin(Insets margin) {
        this.margin = margin;
    }


    public LoginPageView gridPane(GridPane gridPane) {
        setGridPane(gridPane);
        return this;
    }

    public LoginPageView loginFormView(LoginFormView loginFormView) {
        setLoginFormView(loginFormView);
        return this;
    }

    public LoginPageView title(Text title) {
        setTitle(title);
        return this;
    }

    public LoginPageView RegisterBoxLayout(GridPane RegisterBoxLayout) {
        setRegisterBoxLayout(RegisterBoxLayout);
        return this;
    }

    public LoginPageView RegisterButton(Button RegisterButton) {
        setRegisterButton(RegisterButton);
        return this;
    }

    public LoginPageView RegisterLabel(Label RegisterLabel) {
        setRegisterLabel(RegisterLabel);
        return this;
    }

    public LoginPageView margin(Insets margin) {
        setMargin(margin);
        return this;
    }    

    @Override
    public Node getRootNode() {
        return this;
    }
}
