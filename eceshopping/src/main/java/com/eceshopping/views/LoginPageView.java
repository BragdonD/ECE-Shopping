package com.eceshopping.views;

import com.eceshopping.styles.AppStyles;
import com.eceshopping.styles.AppText;
import com.eceshopping.views.components.LoginFormView;
import com.eceshopping.views.components.input.InputFieldView;

import javafx.geometry.HPos;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Node;
import javafx.scene.layout.ColumnConstraints;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.StackPane;
import javafx.scene.text.Text;
import javafx.scene.text.TextAlignment;

public class LoginPageView extends StackPane implements View {
    private GridPane gridPane;
    private LoginFormView loginFormView;
    private Text title;
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

        this.margin = new Insets(10, 10, 10, 10);
        
        this.gridPane.setPrefSize(400, 400);
        this.getChildren().add(this.gridPane);
        this.setAlignment(Pos.CENTER);
        setMargin(this.gridPane, this.margin);
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

    public LoginFormView getLoginFormView() {
        return this.loginFormView;
    }

    public Text getTitle() {
        return this.title;
    }

    public void setLoginFormView(LoginFormView loginFormView) {
        this.loginFormView = loginFormView;
    }

    public void setTitle(Text title) {
        this.title = title;
    }

    public LoginPageView loginFormView(LoginFormView loginFormView) {
        setLoginFormView(loginFormView);
        return this;
    }

    public LoginPageView title(Text title) {
        setTitle(title);
        return this;
    }

    @Override
    public Node getRootNode() {
        return this;
    }
}
