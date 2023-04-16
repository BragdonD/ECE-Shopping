package com.eceshopping.views;

import com.eceshopping.configs.AppStyles;
import com.eceshopping.configs.AppText;
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

/**
 * RegisterPageView class that creates the register page view for the user.
 * Where the user can register for a new account
 */
public class RegisterPageView extends StackPane implements View {
    private GridPane gridPane;
    private RegisterFormView registerFormView;
    private Text title;
    private GridPane RegisterBoxLayout;
    private Button RegisterButton;
    private Label RegisterLabel;
    private Insets margin;

    /*
     * registerFormView is the register form view for the user.
     * Where the user can register for a new account
     */
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

    /*
     * Set up the register box
     * Where the user can register for a new account
     */
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

    /*
     * Set up the title for the register page
     */
    private void setupTitle() {
        this.title = new Text(AppText.REGISTER_PAGE_TITLE);
        this.title.setTextAlignment(TextAlignment.CENTER);
        this.gridPane.add(this.title, 0, 0);
        this.title.setStyle(AppStyles.TITLE_STYLE);
    }

    /*
     * Set up the register form for the user.
     * Where the user can register for a new account
     */
    private void setupRegisterForm() {
        this.registerFormView = new RegisterFormView();
        this.gridPane.setStyle(AppStyles.LOGIN_FORM_STYLE);
        this.registerFormView.getFormView().setStyle(AppStyles.FORM_STYLE);
        this.registerFormView.getFormView().setPrefSize(300, 500);
        this.registerFormView.getFormView().setPadding(new Insets(10, 10, 10, 10));
        this.registerFormView.getFormView().setVgap(10);
        this.gridPane.add(this.registerFormView.getFormView(), 0, 1);
        for (InputFieldView input : this.registerFormView.getFormView().getInputFields()) {
            input.getLabelField().setStyle(AppStyles.LABEL_STYLE);
            input.getTextField().setStyle(AppStyles.TEXT_FIELD_STYLE);
        }
        this.registerFormView.getSubmitButton().setStyle(AppStyles.SUBMIT_BUTTON_STYLE);
        this.registerFormView.getSubmitButton().setPrefWidth(300);
    }

    /**
     * @return GridPane
     */
    /*
     * Getters and setters for the register page view
     */
    public GridPane getGridPane() {
        return this.gridPane;
    }

    /**
     * @param gridPane
     */
    /*
     * Set the grid pane for the register page view
     */
    public void setGridPane(GridPane gridPane) {
        this.gridPane = gridPane;
    }

    /*
     * Get the register form view for the user.
     */
    public RegisterFormView getregisterFormView() {
        return this.registerFormView;
    }

    /*
     * Set the register form view for the user.
     */
    public void setregisterFormView(RegisterFormView registerFormView) {
        this.registerFormView = registerFormView;
    }

    /*
     * Get the title for the register page view
     */
    public Text getTitle() {
        return this.title;
    }

    /*
     * Set the title for the register page view
     */
    public void setTitle(Text title) {
        this.title = title;
    }

    /*
     * Get the register box layout for the user.
     */
    public GridPane getRegisterBoxLayout() {
        return this.RegisterBoxLayout;
    }

    /*
     * Set the register box layout for the user.
     */
    public void setRegisterBoxLayout(GridPane RegisterBoxLayout) {
        this.RegisterBoxLayout = RegisterBoxLayout;
    }

    /*
     * Get the register button for the user.
     */
    public Button getRegisterButton() {
        return this.RegisterButton;
    }

    /*
     * Set the register button for the user.
     */
    public void setRegisterButton(Button RegisterButton) {
        this.RegisterButton = RegisterButton;
    }

    /*
     * Get the register label for the user.
     */
    public Label getRegisterLabel() {
        return this.RegisterLabel;
    }

    /*
     * Set the register label for the user.
     */
    public void setRegisterLabel(Label RegisterLabel) {
        this.RegisterLabel = RegisterLabel;
    }

    /*
     * Get the margin for the register page view
     */
    public Insets getMargin() {
        return this.margin;
    }

    /*
     * Set the margin for the register page view
     */
    public void setMargin(Insets margin) {
        this.margin = margin;
    }

    /*
     * Set up the grid pane
     */
    public RegisterPageView gridPane(GridPane gridPane) {
        setGridPane(gridPane);
        return this;
    }

    /*
     * Set up the register form for the user.
     */
    public RegisterPageView registerFormView(RegisterFormView registerFormView) {
        setregisterFormView(registerFormView);
        return this;
    }

    /*
     * set the title for the register page
     */
    public RegisterPageView title(Text title) {
        setTitle(title);
        return this;
    }

    /*
     * Set up the register box
     */
    public RegisterPageView RegisterBoxLayout(GridPane RegisterBoxLayout) {
        setRegisterBoxLayout(RegisterBoxLayout);
        return this;
    }

    /*
     * Set up the register button
     */
    public RegisterPageView RegisterButton(Button RegisterButton) {
        setRegisterButton(RegisterButton);
        return this;
    }

    /*
     * Set up the register label
     */
    public RegisterPageView RegisterLabel(Label RegisterLabel) {
        setRegisterLabel(RegisterLabel);
        return this;
    }

    /*
     * Set up the margin for the register page
     */
    public RegisterPageView margin(Insets margin) {
        setMargin(margin);
        return this;
    }

    @Override
    public Node getRootNode() {
        return this;
    }
}
