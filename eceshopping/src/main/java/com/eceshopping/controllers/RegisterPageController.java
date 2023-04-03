package com.eceshopping.controllers;

import java.util.ArrayList;
import java.util.List;

import com.eceshopping.controllers.components.FormController;
import com.eceshopping.controllers.components.InputFieldController;
import com.eceshopping.dto.UserDto;
import com.eceshopping.services.UserService;
import com.eceshopping.utils.Router;
import com.eceshopping.utils.validator.EmailValidator;
import com.eceshopping.utils.validator.NotEmptyStringValidator;
import com.eceshopping.utils.validator.PasswordValidator;
import com.eceshopping.views.RegisterPageView;
import com.eceshopping.views.components.InputFieldView;

import javafx.concurrent.Task;

public class RegisterPageController implements Controller {
    private RegisterPageView view;
    private FormController registerFormController;
    private UserService userService;
    /**
     * Constructor of the class.
     * 
     * @param view the view of the login form
     **/
    public RegisterPageController(RegisterPageView view) {
        this.view = view;
        this.userService = new UserService();

        List<InputFieldView> inputFieldViews = new ArrayList<InputFieldView>();
        inputFieldViews.add(this.view.getregisterFormView().getNameInputFieldView());
        inputFieldViews.add(this.view.getregisterFormView().getEmailInputFieldView());
        inputFieldViews.add(this.view.getregisterFormView().getPasswordInputFieldView());
        inputFieldViews.add(this.view.getregisterFormView().getConfirmPasswordInputFieldView());
        List<InputFieldController> inputFieldsControllers = new ArrayList<InputFieldController>();
        inputFieldsControllers.add(new InputFieldController(inputFieldViews.get(0), new NotEmptyStringValidator()));
        inputFieldsControllers.add(new InputFieldController(inputFieldViews.get(1), new EmailValidator()));
        inputFieldsControllers.add(new InputFieldController(inputFieldViews.get(2), new PasswordValidator()));
        inputFieldsControllers.add(new InputFieldController(inputFieldViews.get(3), new PasswordValidator()));

        this.registerFormController = new FormController(this.view.getregisterFormView().getFormView(), inputFieldsControllers); 
        
        onSubmit();

        setupRegisterLink();
    }

    /**
     * This method is called when the user click on the submit button of the login form.
     **/
    public void onSubmit() {
        this.registerFormController.addIsSubmittingListener((observable, oldValue, newValue) -> {
            System.out.println("Is submitting: " + newValue);
            if(newValue) {
                String email = this.registerFormController.getinputFieldsController().get(0).getValue();
                String password = this.registerFormController.getinputFieldsController().get(1).getValue();
                Task<UserDto> getUserTask = this.userService.getUserByEmailAsync(email);
                new Thread(getUserTask).start();

                getUserTask.setOnSucceeded(event -> {
                    UserDto user = getUserTask.getValue();
                    if(user != null) {
                        if(!userService.verifyPassword(password, user.getPassword())) {
                            /// Display credential error
                            System.out.println("Credential error");
                            this.registerFormController.reset();
                        } else {
                            Router.getInstance().navigateTo("/");
                        }
                    } else {
                        // Display user not found
                        System.out.println("User not found");
                        this.registerFormController.reset();
                    }
                });

                getUserTask.setOnFailed(event -> {
                    // Display user not found
                    // Display error
                    System.out.println(getUserTask.getException().getMessage());
                    System.out.println("Login Task Error");
                    this.registerFormController.reset();
                });
            }
        });
    }
    
    private void setupRegisterLink() {
        this.view.getRegisterButton().setOnAction(event -> {
            Router.getInstance().navigateTo("/login");
        });
    }
}
