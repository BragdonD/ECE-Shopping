package com.eceshopping.controllers;

import com.eceshopping.styles.AppStyles;
import com.eceshopping.utils.EmailValidator;
import com.eceshopping.utils.PasswordValidator;
import com.eceshopping.utils.Router;
import com.eceshopping.utils.StringSanitizer;
import com.eceshopping.views.LoginFormView;
import com.eceshopping.views.components.LoadingCircle;

import javafx.concurrent.Task;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.layout.StackPane;

/**
 * This class is the controller of the login form view.
 **/
public class LoginFormController implements Controller {
    private final LoginFormView view;
    private final String textFieldErrorStyle = "-fx-border-radius: 4px; -fx-background-color: wheat; -fx-border-color: red; -fx-border-width: 1px";

    private String email;
    private String password;
    private boolean isLoading;

    /**
     * Constructor of the class.
     * 
     * @param view the view of the login form
     **/
    public LoginFormController(LoginFormView view) throws IllegalArgumentException {
        if (view == null) {
            throw new IllegalArgumentException("The view cannot be null");
        }

        this.view = view;
        this.isLoading = false;

        this.setupButton();

        // Email listener to check if the email is valid and enable the button if it is
        this.view.getUserTextField().textProperty().addListener((observable, oldValue, newValue) -> {
            email = newValue.trim();
            if (!EmailValidator.validate(email)) {
                this.view.getUserTextField().setStyle(textFieldErrorStyle);
                this.view.getButton().setDisable(true);
            } else {
                this.view.getUserTextField().setStyle("");
                if (password != null && PasswordValidator.validate(password)) {
                    this.view.getButton().setDisable(false);
                }
            }
        });

        // Password listener to check if the password is valid and enable the button if
        // it is
        this.view.getPasswordTextField().textProperty().addListener((observable, oldValue, newValue) -> {
            password = newValue;
            if (!PasswordValidator.validate(password)) {
                this.view.getPasswordTextField().setStyle(textFieldErrorStyle);
                this.view.getButton().setDisable(true);
            } else {
                this.view.getPasswordTextField().setStyle("");
                if (email != null && EmailValidator.validate(email)) {
                    this.view.getButton().setDisable(false);
                }
            }
        });

        // Hyperlink listener to navigate to the register form
        this.view.getHyperlink().setOnAction(e -> {
            Router.getInstance().navigateTo("/register");
        });
    }

    private void setupButtonStyleOnHover() {
        this.view.getButton().onMouseEnteredProperty().set(e -> {
            if (!isLoading && !this.view.getButton().isDisabled()) {
                this.view.getButton().setStyle(AppStyles.PRIMARY_BUTTON_STYLE_HOVER);
            }
        });
        this.view.getButton().onMouseExitedProperty().set(e -> {
            if (!isLoading && !this.view.getButton().isDisabled()) {
                this.view.getButton().setStyle(AppStyles.PRIMARY_BUTTON_STYLE);
            }
        });

    }

    private void setupButtonStyleOnDisable() {
        this.view.getButton().disableProperty().addListener((observable, oldValue, newValue) -> {
            if(isLoading) {
                return;
            }
            if (newValue == true) {
                this.view.getButton().setStyle(AppStyles.PRIMARY_BUTTON_STYLE_DEACTIVATED);
            } else {
                this.view.getButton().setStyle(AppStyles.PRIMARY_BUTTON_STYLE);
            }
        });
    }

    private void addLoadingAnimation() {
        LoadingCircle spinner = new LoadingCircle(20);
        StackPane stackPane = new StackPane(spinner);
        stackPane.setAlignment(Pos.CENTER);
        spinner.start();
        this.view.getButton().setMinWidth(120);
        this.view.getButton().setText("Loading...");
        this.view.getButton().setGraphic(stackPane);
        this.view.getButton().setDisable(true);
    }

    private void removeLoadingAnimation() {
        this.view.getButton().setMinWidth(0);
        this.view.getButton().setText("Sign in");
        this.view.getButton().setGraphic(null);
        this.view.getButton().setDisable(false);
    }

    private void setupButtonOnAction() {
        this.view.getButton().setOnAction(e -> {
            email = StringSanitizer.sanitize(email);
            password = StringSanitizer.sanitize(password);

            // To be changed latter to use the UserService
            Task<Integer> loginTask = new Task<Integer>() {
                @Override
                protected Integer call() throws Exception {
                    int iterations = 0;
                    for (iterations = 0; iterations < 100000; iterations++) {
                        if (isCancelled()) {
                            break;
                        }
                        System.out.println("Iteration " + iterations);
                    }
                    return iterations;
                }
            };

            new Thread(loginTask).start();
            this.isLoading = true;
            addLoadingAnimation();

            loginTask.setOnSucceeded(event -> {
                this.isLoading = false;
                removeLoadingAnimation();
            });

            loginTask.setOnFailed(event -> {
                this.isLoading = false;
                removeLoadingAnimation();
            });
        });
    }

    private void setupButton() {
        this.setupButtonStyleOnDisable();
        this.setupButtonStyleOnHover();
        this.setupButtonOnAction();

        // Don't change the order of the following lines or the default style will not
        // be applied
        this.view.getButton().setDisable(true); // Disable the button until the user enters valid credentials
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
