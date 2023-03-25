package com.eceshopping.controllers;

import com.eceshopping.dto.UserDto;
import com.eceshopping.factories.UserFactory;
import com.eceshopping.services.UserService;
import com.eceshopping.styles.AppStyles;
import com.eceshopping.utils.EmailValidator;
import com.eceshopping.utils.PasswordValidator;
import com.eceshopping.utils.Router;
import com.eceshopping.utils.StringSanitizer;
import com.eceshopping.views.components.LoadingCircle;
import com.eceshopping.views.components.RegisterFormView;

import javafx.concurrent.Task;
import javafx.geometry.Pos;
import javafx.scene.control.Tooltip;
import javafx.scene.layout.StackPane;

/**
 * This class is the controller of the login form view.
 **/
public class RegisterFormController implements Controller {
    public final static String CHECKING_TEXT_STRING = "Checking...";
    public final static String REGISTER_TEXT_STRING = "Register";

    private final RegisterFormView view;
    private UserService userService;
    
    private String userName;
    private String email;
    private String password;
    private String checkPassword;
    private boolean isRegistering;

    /**
     * Constructor of the class.
     * 
     * @param view the view of the login form
     **/
    public RegisterFormController(RegisterFormView view) {
        this.view = view;
        this.userService = new UserService();

        this.isRegistering = false;

        this.userName = "";
        this.email = "";
        this.password = "";
        this.checkPassword = "";

        setupRegisterButton();
        setupHyperlink();
        setupUserNameChangeListener();
        setupEmailChangeListener();
        setupPasswordChangeListener();
        setupCheckPasswordChangeListener();
        handleColorsHelpTexts();
        setupTextFields();
        hideErrorText();
    }

    /**
     * Check if the user can register. If so, enable the button.
     * @return
     */
    private boolean canRegister() {
        return EmailValidator.validate(email)
                && PasswordValidator.validate(password)
                && password.equals(checkPassword)
                && userName.length() > 0;
    }

    private void setupEmailChangeListener() {
        // Email listener to check if the email is valid and enable the button if it is
        this.view.getEmailField().textProperty().addListener((observable, oldValue, newValue) -> {
            email = newValue.trim();
            if (!EmailValidator.validate(email)) {
                this.view.getEmailField().setStyle(AppStyles.TEXT_FIELD_STYLE_ERROR);
                this.view.getRegisterButton().setDisable(true);
            } else {
                this.view.getEmailField().setStyle(AppStyles.TEXT_FIELD_STYLE_CORRECT);
                if (canRegister()) {
                    this.view.getRegisterButton().setDisable(false);
                }
            }
        });
    }

    private void setupUserNameChangeListener() {
        // Name listener to check if the name is valid and enable the button if it is
        this.view.getNameField().textProperty().addListener((observable, oldValue, newValue) -> {
            userName = newValue.trim();
            if (userName.length() <= 0) {
                this.view.getNameField().setStyle(AppStyles.TEXT_FIELD_STYLE_ERROR);
                this.view.getRegisterButton().setDisable(true);
            } else {
                this.view.getNameField().setStyle(AppStyles.TEXT_FIELD_STYLE_CORRECT);
                if (canRegister()) {
                    this.view.getRegisterButton().setDisable(false);
                }
            }
        });
    }

    private void setupCheckPasswordChangeListener() {
        // Password listener to check if the password is valid and enable the button if
        // it is
        this.view.getCPwField().textProperty().addListener((observable, oldValue, newValue) -> {
            checkPassword = newValue;
            if (!password.equals(checkPassword)) {
                this.view.getCPwField().setStyle(AppStyles.TEXT_FIELD_STYLE_ERROR);
                this.view.getRegisterButton().setDisable(true);
            } else {
                this.view.getCPwField().setStyle(AppStyles.TEXT_FIELD_STYLE_CORRECT);
                if (canRegister()) {
                    this.view.getRegisterButton().setDisable(false);
                }
            }
        });
    }

    private void setupPasswordChangeListener() {
        // Password listener to check if the password is valid and enable the button if
        // it is
        this.view.getPwField().textProperty().addListener((observable, oldValue, newValue) -> {
            password = newValue;
            handleColorsHelpTexts();
            if (!PasswordValidator.validate(password)) {
                this.view.getPwField().setStyle(AppStyles.TEXT_FIELD_STYLE_ERROR);
                this.view.getRegisterButton().setDisable(true);
            } else {
                this.view.getPwField().setStyle(AppStyles.TEXT_FIELD_STYLE_CORRECT);
                if (canRegister()) {
                    this.view.getRegisterButton().setDisable(false);
                }
            }
        });
    }

    /**
     * Setup the style of the button when the mouse is hovering over it.
     */
    private void setupButtonStyleOnHover() {
        this.view.getRegisterButton().onMouseEnteredProperty().set(e -> {
            if (!isRegistering && !this.view.getRegisterButton().isDisabled()) {
                this.view.getRegisterButton().setStyle(AppStyles.PRIMARY_BUTTON_STYLE_HOVER);
            }
        });
        this.view.getRegisterButton().onMouseExitedProperty().set(e -> {
            if (!isRegistering && !this.view.getRegisterButton().isDisabled()) {
                this.view.getRegisterButton().setStyle(AppStyles.PRIMARY_BUTTON_STYLE);
            }
        });

    }

    /**
     * Setup the style of the button when the disable property is changed.
     */
    private void setupButtonStyleOnDisable() {
        this.view.getRegisterButton().disableProperty().addListener((observable, oldValue, newValue) -> {
            if (isRegistering) {
                return;
            }
            if (newValue == true) {
                this.view.getRegisterButton().setStyle(AppStyles.PRIMARY_BUTTON_STYLE_DEACTIVATED);
            } else {
                this.view.getRegisterButton().setStyle(AppStyles.PRIMARY_BUTTON_STYLE);
            }
        });
    }

    private void setupHyperlink() {
        this.view.getHyperlink().setOnAction(e -> {
            Router.getInstance().navigateTo("/login");
        });
    }

    /**
     * Activate the hyperlink.
     **/
    private void activatedHyperlink() {
        this.view.getHyperlink().setDisable(false);
    }

    private void deactivatedHyperlink() {
        this.view.getHyperlink().setDisable(true);
    }

    private void deactivatedTextFields() {
        this.view.getEmailField().setDisable(true);
        this.view.getPwField().setDisable(true);
    }

    private void activatedTextFields() {
        this.view.getEmailField().setDisable(false);
        this.view.getPwField().setDisable(false);
    }

    private void setupTextFields() {
        this.view.getEmailField().setStyle(AppStyles.TEXT_FIELD_STYLE);
        this.view.getPwField().setStyle(AppStyles.TEXT_FIELD_STYLE);
        this.view.getCPwField().setStyle(AppStyles.TEXT_FIELD_STYLE);
        this.view.getNameField().setStyle(AppStyles.TEXT_FIELD_STYLE);
    }

    private void resetTextFields() {
        this.view.getEmailField().setText("");
        this.view.getPwField().setText("");
        this.view.getCPwField().setText("");
        this.view.getNameField().setText("");
    }

    private void hideErrorText() {
        this.view.getErrorMessageText().setVisible(false);
    }

    private void showErrorText() {
        this.view.getErrorMessageText().setStyle(AppStyles.ERROR_TEXT_STYLE);
        this.view.getErrorMessageText().setVisible(true);
    }

    private void handleColorsHelpTexts() {
        if(this.password.matches(".*[a-z].*")) {
            this.view.getPasswordHelpMinLetter().setStyle(AppStyles.CORRECT_TEXT_STYLE);
        } else {
            this.view.getPasswordHelpMinLetter().setStyle(AppStyles.ERROR_TEXT_STYLE);
        }
        if(this.password.matches(".*[A-Z].*")) {
            this.view.getPasswordHelpMajLetter().setStyle(AppStyles.CORRECT_TEXT_STYLE);
        } else {
            this.view.getPasswordHelpMajLetter().setStyle(AppStyles.ERROR_TEXT_STYLE);
        }
        if(this.password.matches(".*[0-9].*")) {
            this.view.getPasswordHelpNumber().setStyle(AppStyles.CORRECT_TEXT_STYLE);
        } else {
            this.view.getPasswordHelpNumber().setStyle(AppStyles.ERROR_TEXT_STYLE);
        }
        if(this.password.matches(".*[!@#$%^&*()].*")) {
            this.view.getPasswordHelpSpecial().setStyle(AppStyles.CORRECT_TEXT_STYLE);
        } else {
            this.view.getPasswordHelpSpecial().setStyle(AppStyles.ERROR_TEXT_STYLE);
        }
        if(this.password.length() >= 8) {
            this.view.getPasswordHelpLength().setStyle(AppStyles.CORRECT_TEXT_STYLE);
        } else {
            this.view.getPasswordHelpLength().setStyle(AppStyles.ERROR_TEXT_STYLE);
        }
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
        this.view.getRegisterButton().setMinWidth(120);
        this.view.getRegisterButton().setText(REGISTER_TEXT_STRING);
        this.view.getRegisterButton().setGraphic(stackPane);
        this.view.getRegisterButton().setDisable(true);
        this.deactivatedHyperlink();
        this.deactivatedTextFields();
    }

    /**
     * Remove the loading animation from the button and set the button to the
     * default state.
     **/
    private void removeLoadingAnimation() {
        this.view.getRegisterButton().setMinWidth(0);
        this.view.getRegisterButton().setText(REGISTER_TEXT_STRING);
        this.view.getRegisterButton().setGraphic(null);
        this.view.getRegisterButton().setDisable(false);
        this.activatedHyperlink();
        this.activatedTextFields();
        this.resetTextFields();
    }

    /**
     * Setup every actions related to the button.
     */
    private void setupButtonOnAction() {
        this.view.getRegisterButton().setOnAction(e -> {
            email = StringSanitizer.sanitize(email);
            password = StringSanitizer.sanitize(password);
            checkPassword = StringSanitizer.sanitize(checkPassword);
            userName = StringSanitizer.sanitize(userName);

            UserDto user = UserFactory.createGuestUser(userName, email, password);

            addLoadingAnimation();

            try {
                Task<UserDto> registerTask = userService.saveUserAsync(user);
                new Thread(registerTask).start();
                this.isRegistering = true;
                

                registerTask.setOnSucceeded(event -> {
                    hideErrorText();
                    this.isRegistering = false;
                    removeLoadingAnimation();
                });

                registerTask.setOnFailed(event -> {
                    showErrorText();
                    this.isRegistering = false;
                    removeLoadingAnimation();
                });
            } catch (Exception exception) {
                showErrorText();
                removeLoadingAnimation();
            }
        });
    }

    /**
     * Setup the button to login. Call multiple private methods to setup the button
     * style and action.
     **/
    private void setupRegisterButton() {
        this.setupButtonStyleOnDisable();
        this.setupButtonStyleOnHover();
        this.setupButtonOnAction();

        // Don't change the order of the following lines or the default style will not
        // be applied
        this.view.getRegisterButton().setDisable(true); // Disable the button until the user enters valid credentials
    }

}
