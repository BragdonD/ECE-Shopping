package com.eceshopping.controllers;

import java.util.ArrayList;
import java.util.List;

import com.eceshopping.configs.AppStyles;
import com.eceshopping.configs.AppText;
import com.eceshopping.controllers.components.FormController;
import com.eceshopping.controllers.components.InputFieldController;
import com.eceshopping.dto.UserDto;
import com.eceshopping.services.UserService;
import com.eceshopping.utils.Router;
import com.eceshopping.utils.Session;
import com.eceshopping.utils.validator.EmailValidator;
import com.eceshopping.utils.validator.NotEmptyStringValidator;
import com.eceshopping.views.LoginPageView;
import com.eceshopping.views.components.InputFieldView;

import javafx.concurrent.Task;
import javafx.scene.Scene;
import javafx.scene.text.Text;

/**
 * This class is the controller of the login form view.
 **/
public class LoginPageController implements Controller {
    private LoginPageView view;
    private FormController loginFormController;
    private UserService userService;

    /**
     * Constructor of the class.
     * 
     * @param view the view of the login form
     **/
    public LoginPageController(LoginPageView view) {
        this.view = view;
        this.userService = new UserService();

        List<InputFieldView> inputFieldViews = new ArrayList<InputFieldView>();
        inputFieldViews.add(this.view.getLoginFormView().getEmailInputFieldView());
        inputFieldViews.add(this.view.getLoginFormView().getPasswordInputFieldView());
        List<InputFieldController> inputFieldsControllers = new ArrayList<InputFieldController>();
        inputFieldsControllers.add(new InputFieldController(inputFieldViews.get(0), new EmailValidator()));
        inputFieldsControllers.add(new InputFieldController(inputFieldViews.get(1), new NotEmptyStringValidator()));

        this.loginFormController = new FormController(this.view.getLoginFormView().getFormView(),
                inputFieldsControllers);

        onSubmit();
        setupRegisterLink();
    }

    /**
     * This method is called when the user click on the submit button of the login
     * form.
     **/
    public void onSubmit() {
        this.loginFormController.addIsSubmittingListener((observable, oldValue, newValue) -> {
            System.out.println("Is submitting: " + newValue);
            if (newValue) {
                String email = this.loginFormController.getinputFieldsController().get(0).getValue();
                String password = this.loginFormController.getinputFieldsController().get(1).getValue();
                Task<UserDto> getUserTask = this.userService.getUserByEmailAsync(email);
                new Thread(getUserTask).start();

                getUserTask.setOnSucceeded(event -> {
                    UserDto user = getUserTask.getValue();
                    if (user != null) {
                        if (!userService.verifyPassword(password, user.getPassword())) {
                            /// Display credential error
                            DisplayError(AppText.NO_USER_FOUND);
                            this.loginFormController.reset();
                        } else {
                            Session.getInstance().setUser(user);
                            if (user.getAdmin())
                                Router.getInstance().navigateTo("/admin");
                            else
                                Router.getInstance().navigateTo("/");
                        }
                    } else {
                        if (getUserTask.getException().getMessage() != null) {
                            DisplayError(getUserTask.getException().getMessage());
                            this.loginFormController.reset();
                            return;
                        }
                    }
                });

                getUserTask.setOnFailed(event -> {
                    // Display user not found
                    if (getUserTask.getException().getMessage() != null) {
                        DisplayError(getUserTask.getException().getMessage());
                        this.loginFormController.reset();
                        return;
                    }
                });
            }
        });
    }

    /**
     * This method is used to display an error message.
     * 
     * @param message the error message
     **/
    private void DisplayError(String message) {
        if (this.view.getLoginFormView().getFormView().getChildren().size() == 4) {
            this.view.getLoginFormView().getFormView().getChildren().remove(3);
        }
        Text errorText = new Text(message);
        errorText.setStyle(AppStyles.ERROR_TEXT_STYLE);
        this.view.getLoginFormView().getFormView().add(errorText, 0, 3);
    }

    /**
     * This method is called when the user click on the register link.
     **/
    private void setupRegisterLink() {
        this.view.getRegisterButton().setOnAction(event -> {
            Router.getInstance().navigateTo("/register");
        });
    }

    @Override
    public void bindScene(Scene s) {
        this.view.prefWidthProperty().bind(s.widthProperty());
        this.view.prefHeightProperty().bind(s.heightProperty());
    }
}
