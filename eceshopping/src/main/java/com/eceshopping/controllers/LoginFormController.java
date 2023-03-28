package com.eceshopping.controllers;

import com.eceshopping.dto.UserDto;
import com.eceshopping.services.UserService;
import com.eceshopping.styles.AppStyles;
import com.eceshopping.utils.Router;
import com.eceshopping.utils.StringSanitizer;
import com.eceshopping.utils.validator.EmailValidator;
import com.eceshopping.utils.validator.PasswordValidator;
import com.eceshopping.views.components.LoadingCircle;
import com.eceshopping.views.components.LoginFormView;

import javafx.concurrent.Task;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.layout.StackPane;

/**
 * This class is the controller of the login form view.
 **/
public class LoginFormController implements Controller {
    public final static String LOADING_TEXT_STRING = "Loading...";
    public final static String LOGIN_TEXT_STRING = "Login";

    private final LoginFormView view;
    private UserService userService;

    private String email;
    private String password;
    private boolean isLoading;

    /**
     * Constructor of the class.
     * 
     * @param view the view of the login form
     **/
    public LoginFormController(LoginFormView view) throws IllegalArgumentException {
        this.view = view;
        this.userService = new UserService();

        this.isLoading = false;
        this.email = "";
        this.password = "";

        setupButton();
        setupTextFields();
        setupEmailChangeListener();
        setupPasswordChangeListener();
        setupHyperlink();
        hideErrorText();
    }

    /**
     * Setup the email text field listener to check if the email is valid and enable
     * the button if it is.
     */
    private void setupEmailChangeListener() {
        // Email listener to check if the email is valid and enable the button if it is
        this.view.getUserTextField().textProperty().addListener((observable, oldValue, newValue) -> {
            email = newValue.trim();
            if (new EmailValidator().validate(email)) {
                this.view.getUserTextField().setStyle(AppStyles.TEXT_FIELD_STYLE_ERROR);

                this.view.getLoginButton().setDisable(true);
            } else {
                this.view.getUserTextField().setStyle(AppStyles.TEXT_FIELD_STYLE_CORRECT);
                if (password != null && new PasswordValidator().validate(password)) {
                    this.view.getLoginButton().setDisable(false);
                }
            }
        });
    }

    /**
     * Setup the password text field listener to check if the password is valid and
     * enable the button if it is.
     */
    private void setupPasswordChangeListener() {
        this.view.getPasswordTextField().textProperty().addListener((observable, oldValue, newValue) -> {
            password = newValue;
            if (new PasswordValidator().validate(password)) {
                this.view.getPasswordTextField().setStyle(AppStyles.TEXT_FIELD_STYLE_ERROR);
                this.view.getLoginButton().setDisable(true);
            } else {
                this.view.getPasswordTextField().setStyle(AppStyles.TEXT_FIELD_STYLE_CORRECT);
                if (email != null && new EmailValidator().validate(email)) {
                    this.view.getLoginButton().setDisable(false);
                }
            }
        });
    }

    /**
     * Setup the style of the button when the mouse is hovering over it.
     */
    private void setupButtonStyleOnHover() {
        this.view.getLoginButton().onMouseEnteredProperty().set(e -> {
            if (!isLoading && !this.view.getLoginButton().isDisabled()) {
                this.view.getLoginButton().setStyle(AppStyles.PRIMARY_BUTTON_STYLE_HOVER);
            }
        });
        this.view.getLoginButton().onMouseExitedProperty().set(e -> {
            if (!isLoading && !this.view.getLoginButton().isDisabled()) {
                this.view.getLoginButton().setStyle(AppStyles.PRIMARY_BUTTON_STYLE);
            }
        });

    }

    /**
     * Setup the style of the button when the disable property is changed.
     */
    private void setupButtonStyleOnDisable() {
        this.view.getLoginButton().disableProperty().addListener((observable, oldValue, newValue) -> {
            if (isLoading) {
                return;
            }
            if (newValue == true) {
                this.view.getLoginButton().setStyle(AppStyles.PRIMARY_BUTTON_STYLE_DEACTIVATED);
            } else {
                this.view.getLoginButton().setStyle(AppStyles.PRIMARY_BUTTON_STYLE);
            }
        });
    }

    /**
     * Add the loading animation to the button and set the button to the loading
     * state.
     */
    private void addLoadingAnimation() {
        LoadingCircle spinner = new LoadingCircle(20);
        StackPane stackPane = new StackPane(spinner);
        stackPane.setAlignment(Pos.CENTER);
        spinner.start();
        this.view.getLoginButton().setMinWidth(120);
        this.view.getLoginButton().setText(LOADING_TEXT_STRING);
        this.view.getLoginButton().setGraphic(stackPane);
        this.view.getLoginButton().setDisable(true);
        this.deactivatedHyperlink();
        this.deactivatedTextFields();
    }

    /**
     * Remove the loading animation from the button and set the button to the
     * default state.
     **/
    private void removeLoadingAnimation() {
        this.view.getLoginButton().setMinWidth(0);
        this.view.getLoginButton().setText(LOGIN_TEXT_STRING);
        this.view.getLoginButton().setGraphic(null);
        this.view.getLoginButton().setDisable(false);
        this.activatedHyperlink();
        this.activatedTextFields();
        this.resetTextFields();
    }

    /**
     * Setup every actions related to the button.
     */
    private void setupButtonOnAction() {
        this.view.getLoginButton().setOnAction(e -> {
            email = StringSanitizer.sanitize(email);
            password = StringSanitizer.sanitize(password);

            // To be changed latter to use the UserService
            Task<UserDto> loginTask = userService.getUserByEmailAsync(email);

            new Thread(loginTask).start();
            this.isLoading = true;
            addLoadingAnimation();

            loginTask.setOnSucceeded(event -> {
                hideErrorText();
                this.isLoading = false;
                removeLoadingAnimation();
            });

            loginTask.setOnFailed(event -> {
                showErrorText();
                this.isLoading = false;
                removeLoadingAnimation();
            });
        });
    }

    /**
     * Setup the button to login. Call multiple private methods to setup the button
     * style and action.
     **/
    private void setupButton() {
        this.setupButtonStyleOnDisable();
        this.setupButtonStyleOnHover();
        this.setupButtonOnAction();

        // Don't change the order of the following lines or the default style will not
        // be applied
        this.view.getLoginButton().setDisable(true); // Disable the button until the user enters valid credentials
    }

    /**
     * Setup the hyperlink to navigate to the register form.
     **/
    private void setupHyperlink() {
        this.view.getHyperlink().setOnAction(e -> {
            Router.getInstance().navigateTo("/register");
        });
    }

    /**
     * Deactivate the hyperlink.
     **/
    private void deactivatedHyperlink() {
        this.view.getHyperlink().setDisable(true);
    }

    /**
     * Activate the hyperlink.
     **/
    private void activatedHyperlink() {
        this.view.getHyperlink().setDisable(false);
    }

    /**
     * Deactivate the text fields.
     */
    private void deactivatedTextFields() {
        this.view.getUserTextField().setDisable(true);
        this.view.getPasswordTextField().setDisable(true);
    }

    /**
     * Activate the text fields.
     */
    private void activatedTextFields() {
        this.view.getUserTextField().setDisable(false);
        this.view.getPasswordTextField().setDisable(false);
    }

    /**
     * Setup the text fields.
     */
    private void setupTextFields() {
        this.view.getUserTextField().setStyle(AppStyles.TEXT_FIELD_STYLE);
        this.view.getPasswordTextField().setStyle(AppStyles.TEXT_FIELD_STYLE);
    }

    /**
     * Reset the text fields.
     */
    private void resetTextFields() {
        this.view.getUserTextField().setText("");
        this.view.getPasswordTextField().setText("");
    }

    /**
     * Hide the error text.
     */
    private void hideErrorText() {
        this.view.getErrorText().setVisible(false);
    }

    /**
     * Show the error text.
     */
    private void showErrorText() {
        // this.view.getErrorText().setFill(Color.RED);
        this.view.getErrorText().setVisible(true);
    }

    /**
     * Get the scene of the login form view.
     * 
     * @return the scene of the login form view
     **/
    public Scene getScene() {
        return this.view.getScene();
    }
}
