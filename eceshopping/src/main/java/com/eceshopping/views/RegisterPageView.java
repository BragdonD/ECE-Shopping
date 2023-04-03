package com.eceshopping.views;

import com.eceshopping.styles.AppStyles;
import com.eceshopping.styles.AppText;
import com.eceshopping.views.components.InputFieldView;
import com.eceshopping.views.components.RegisterFormView;

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

public class RegisterPageView extends StackPane implements View {
    private GridPane gridPane;
    private RegisterFormView registerFormView;
    private Text title;
    private GridPane RegisterBoxLayout;
    private Button RegisterButton;
    private Label RegisterLabel;
    private Insets margin;
    
    public RegisterPageView() {
        this.gridPane = new GridPane();
        this.gridPane.setVgap(10);
        this.gridPane.setHgap(10);
        this.gridPane.setAlignment(Pos.CENTER);
        ColumnConstraints column1 = new ColumnConstraints();
        column1.setHalignment(HPos.CENTER); // center the elements in the column
        gridPane.getColumnConstraints().addAll(column1);

        setupTitle();
        setupRegisterForm();
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
        this.RegisterButton = new Button(AppText.REGISTER_FORM_REGISTER_BUTTON);
        this.RegisterButton.setPrefWidth(200);
        this.RegisterLabel = new Label(AppText.REGISTER_FORM_REGISTER_LABEL);
        this.RegisterLabel.setPrefWidth(200);
        this.RegisterLabel.setAlignment(Pos.CENTER);
        this.RegisterBoxLayout.add(this.RegisterLabel, 0, 0);
        this.RegisterBoxLayout.add(this.RegisterButton, 0, 1);
        this.RegisterBoxLayout.setAlignment(Pos.CENTER);
    }

    private void setupTitle() {
        this.title = new Text(AppText.REGISTER_PAGE_TITLE);
        this.title.setTextAlignment(TextAlignment.CENTER);
        this.gridPane.add(this.title, 0, 0);
        this.title.setStyle(AppStyles.TITLE_STYLE); 
    }

    private void setupRegisterForm() {
        this.registerFormView = new RegisterFormView();
        this.gridPane.setStyle(AppStyles.LOGIN_FORM_STYLE);
        this.registerFormView.getFormView().setStyle(AppStyles.FORM_STYLE);
        this.registerFormView.getFormView().setPrefSize(300, 300);
        this.registerFormView.getFormView().setPadding(new Insets(10, 10, 10, 10));
        this.registerFormView.getFormView().setVgap(10);
        this.gridPane.add(this.registerFormView.getFormView(), 0, 1);
        for(InputFieldView input : this.registerFormView.getFormView().getInputFields()) {
            input.getLabelField().setStyle(AppStyles.LABEL_STYLE);
            input.getTextField().setStyle(AppStyles.TEXT_FIELD_STYLE);
        }
        this.registerFormView.getSubmitButton().setStyle(AppStyles.SUBMIT_BUTTON_STYLE);
        this.registerFormView.getSubmitButton().setPrefWidth(300);
    }


    public GridPane getGridPane() {
        return this.gridPane;
    }

    public void setGridPane(GridPane gridPane) {
        this.gridPane = gridPane;
    }

    public RegisterFormView getregisterFormView() {
        return this.registerFormView;
    }

    public void setregisterFormView(RegisterFormView registerFormView) {
        this.registerFormView = registerFormView;
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


    public RegisterPageView gridPane(GridPane gridPane) {
        setGridPane(gridPane);
        return this;
    }

    public RegisterPageView registerFormView(RegisterFormView registerFormView) {
        setregisterFormView(registerFormView);
        return this;
    }

    public RegisterPageView title(Text title) {
        setTitle(title);
        return this;
    }

    public RegisterPageView RegisterBoxLayout(GridPane RegisterBoxLayout) {
        setRegisterBoxLayout(RegisterBoxLayout);
        return this;
    }

    public RegisterPageView RegisterButton(Button RegisterButton) {
        setRegisterButton(RegisterButton);
        return this;
    }

    public RegisterPageView RegisterLabel(Label RegisterLabel) {
        setRegisterLabel(RegisterLabel);
        return this;
    }

    public RegisterPageView margin(Insets margin) {
        setMargin(margin);
        return this;
    }    

    @Override
    public Node getRootNode() {
        return this;
    }
}
